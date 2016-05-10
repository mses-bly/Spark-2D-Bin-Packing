package org.packing

import com.vividsolutions.jts.geom.util.AffineTransformation
import com.vividsolutions.jts.geom.{Coordinate, Geometry, GeometryFactory, Point}

/**
	* Created by moises on 5/9/16.
	*/
object GeometricUtils {
	val GEOMETRY_FACTORY = new GeometryFactory()

	/**
		* Rotate a Geometry.
		*
		* @param degrees
		* @param g
		* @return
		*/
	def rotate(degrees: Double, g: Geometry): Geometry = {
		val aft = new AffineTransformation()
		aft.rotate(Math.toRadians(degrees), g.getCentroid.getX, g.getCentroid.getY)
		aft.transform(g)
	}

	/**
		* Translate a geometry so that it's upper left corner matches the poosition of point `p`.
		*
		* @param p
		* @param g
		* @return
		*/
	def translateToPoint(p: Point, g: Geometry): Geometry = {
		val upperLeft = GEOMETRY_FACTORY.createPoint(
			new Coordinate(
				g.getEnvelopeInternal.getMinX,
				g.getEnvelopeInternal.getMinY
			)
		)
		val aft = new AffineTransformation()
		aft.translate(p.getX - upperLeft.getX, p.getY - upperLeft.getY)
		aft.transform(g)
	}
}
