name := "LiteratureScala"

version := "0.1"

scalaVersion := "2.12.8"

antlr4Version in Antlr4 := "4.5"
antlr4GenListener in Antlr4 := false
antlr4GenVisitor in Antlr4 := true
enablePlugins(Antlr4Plugin)

libraryDependencies += "org.ow2.asm" % "asm" % "5.0.3"
