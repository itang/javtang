name := "javtang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

organization := "me.itang"

javaOptions += "-Xmx912m"

javacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

//compile
libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "10.0.1")

//test
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test",
  "junit" % "junit" % "4.8.2" % "test")
