package generator

import ast.CompilationUnit

class CompilationUnitGenerator {
  def generate(compilationUnit: CompilationUnit): Array[Byte] = {
    val expression = compilationUnit.expression
    val generator = new ClassGenerator

    generator.generate(expression).toByteArray
  }
}
