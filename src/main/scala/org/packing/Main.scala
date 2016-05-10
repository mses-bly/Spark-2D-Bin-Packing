package org.packing

/**
	* Created by moises on 5/9/16.
	*/

object Main {
	val g1 = Assembly.wktToGeometry("POLYGON((50 50, 100 50, 100 50, 50 100, 50 50))")
	val g2 = Assembly.wktToGeometry("POLYGON((50  50, 150 50 , 100 100, 50  50))")

	def main(args: Array[String]) {
		val app = DrawUtils.draw(shapes = List(DrawUtils.toFXPolygon(g2)))
		app.main(args)
	}


}