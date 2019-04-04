package parser

import ast.CompilationUnit
import org.antlr.v4.runtime.{CharStream, CommonTokenStream}
import syntax.{LiteratureLexer, LiteratureParser}

class Parser {
  def getCompilationUnit(sourceCode: CharStream): CompilationUnit = {
    val lexer = new LiteratureLexer(sourceCode)
    val tokenStream = new CommonTokenStream(lexer)
    val literatureParser = new LiteratureParser(tokenStream)

    literatureParser.compilationUnit().accept(new CompilationUnitVisitor)
  }
}
