package org.packing

import com.vividsolutions.jts.geom.Geometry
import com.vividsolutions.jts.geom.util.AffineTransformation
import com.vividsolutions.jts.io.WKTReader
import org.geotools.geometry.jts.JTSFactoryFinder

import scala.util.Try

/**
	* Created by moises on 5/9/16.
	*/
object Assembly {
	def getMinimalAssembly(g1: Geometry, g2: Geometry): Seq[Geometry] = {
		//Set one piece as fixed and the other to rotate around.
		val (astroG, satelliteG) = if (g1.getArea > g2.getArea) (g1, g2) else (g2, g1)
		val angles = 0 to 360 by 5
		val satelliteGRotations = angles.par map { angle =>
			val aft = new AffineTransformation()
			aft.rotate(0)
			aft.transform(satelliteG)
		}

		satelliteGRotations map { satelliteGRotation =>
			astroG.getCoordinates map { p =>

			}

		}
	}

	def wktToGeometry(wkt: String): Geometry = {
		val reader = new WKTReader(JTSFactoryFinder.getGeometryFactory())
		Try(reader.read(wkt)).getOrElse(null)
	}
}
