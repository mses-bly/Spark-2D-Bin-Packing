package org.packing

import com.vividsolutions.jts.geom.Geometry

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.shape.Polygon

/**
	* Created by moises on 5/9/16.
	*/
object DrawUtils {

	def draw(
						width: Double = 800,
						height: Double = 600,
						shapes: Seq[Polygon]
					): JFXApp = {
		new JFXApp {
			stage = new JFXApp.PrimaryStage {
				title = "Spark-2D-Bin-Packing-Drawing"
				scene = new Scene(width.toDouble, height.toDouble) {
					content = shapes
				}
			}
		}
	}

	/**
		* Convert from JTS Geometry to FX Polygon. Only necessary when drawing.
		*
		* @param g
		* @return
		*/
	def toFXPolygon(g: Geometry) = Polygon(g.getCoordinates.flatMap(coord => Seq(coord.x, coord.y)): _*)
}
