name := "javtang"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.2"

organization := "me.itang"

javacOptions ++= Seq("-encoding", "UTF-8", "-source", "1.7", "-target", "1.7", "-Xlint:unchecked", "-Xlint:deprecation")

//compile
libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "14.0.1",
  "com.google.code.findbugs" % "jsr305" % "2.0.1")

//test
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.8" % "test->default")
