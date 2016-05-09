name := "Spark-2D-Bin-Packing"

version := "1.0"

scalaVersion := "2.11.8"

startYear := Some(2016)

//Library repositories
resolvers ++= Seq(
	Resolver.mavenLocal
	, "Scala-Tools Maven2 Repository" at "http://scala-tools.org/repo-releases"
	, "GeoTools" at "http://download.osgeo.org/webdav/geotools"
)

//Library versions
val geotools_version = "14.2"

libraryDependencies ++= Seq(
	"org.scala-lang" % "scala-library-all" % scalaVersion.value
	, "com.vividsolutions" % "jts" % "1.13"
	, "org.geotools" % "gt-data" % geotools_version
	, "org.scalafx" %% "scalafx" % "8.0.92-R10"
	, "org.scalatest" %% "scalatest" % "2.2.4" % "test"

)

test in assembly := {}