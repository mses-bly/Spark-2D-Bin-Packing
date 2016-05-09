package org.packing

import com.vividsolutions.jts.geom.util.AffineTransformation
import com.vividsolutions.jts.geom.{Coordinate, Geometry, GeometryFactory, MultiPolygon}
import com.vividsolutions.jts.io.WKTReader
import collection.JavaConverters._
import org.geotools.geometry.jts.JTSFactoryFinder

import scala.util.Try

/**
	* Created by moises on 5/9/16.
	*/
object Assembly {
	def getMinimalAssembly(g1: Geometry, g2: Geometry): Seq[Geometry] = {
		//Set one piece as fixed and the other to rotate around.
		val (astroG, satelliteG) = if (g1.getArea > g2.getArea) (g1, g2) else (g2, g1)
		val angles = 0 to 360 by 180
		val satelliteGRotations : Seq[Geometry] = angles.par map { angle =>
			val aft = new AffineTransformation()
			aft.rotate(angle)
			aft.transform(satelliteG)
		} toList

		satelliteGRotations
	}

	def wktToGeometry(wkt: String): Geometry = {
		val reader = new WKTReader(JTSFactoryFinder.getGeometryFactory())
		Try(reader.read(wkt)).getOrElse(null)
	}

	def main(args: Array[String]): Unit = {
		val g1 = wktToGeometry("POLYGON((0 0, 1 0, 1 1, 0 1, 0 0))")
		val g2 = wktToGeometry("POLYGON((0 0, 2 0, 1 1, 0 0))")
		getMinimalAssembly(g1, g2)
	}
}
