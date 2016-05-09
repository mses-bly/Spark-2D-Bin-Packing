name := "Spark-2D-Bin-Packing"

version := "1.0"

scalaVersion := "2.11.8"

startYear := Some(2016)

//Library repositories
resolvers ++= Seq(
  Resolver.mavenLocal,
  "Scala-Tools Maven2 Repository" at "http://scala-tools.org/repo-releases"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library-all" % scalaVersion.value,

  "com.vividsolutions" % "jts" % "1.13",

  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

test in assembly := {}