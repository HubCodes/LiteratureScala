import ast.CompilationUnit
import generator.CompilationUnitGenerator
import org.antlr.v4.runtime.CharStream
import parser.Parser

object Compiler {
  def compile(sourceCode: CharStream): Array[Byte] = {
    val astRoot = getCompilationUnit(new Parser, sourceCode)
    val jvmCode = getJvmCode(new CompilationUnitGenerator, astRoot)

    jvmCode
  }

  def getCompilationUnit(parser: Parser, sourceCode: CharStream): CompilationUnit = {
    parser getCompilationUnit sourceCode
  }

  def getJvmCode(generator: CompilationUnitGenerator, astRoot: CompilationUnit): Array[Byte] = {
    generator generate astRoot
  }
}
