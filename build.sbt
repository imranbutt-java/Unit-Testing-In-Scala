name := "Unit Testing in Scala"

version := "0.1"

scalaVersion := "2.13.1"

// <test library key available in sbt> % <library dependency> % <versoin> % <scope, means when we bundle project test
// shouldn't be added for production>
libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.1.0" % "test"