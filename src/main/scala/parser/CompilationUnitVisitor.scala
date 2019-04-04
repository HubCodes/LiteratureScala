package parser

import ast.CompilationUnit
import syntax.LiteratureBaseVisitor
import syntax.LiteratureParser.CompilationUnitContext

class CompilationUnitVisitor extends LiteratureBaseVisitor[CompilationUnit] {
  override def visitCompilationUnit(ctx: CompilationUnitContext): CompilationUnit = {
    val context = ctx.expression
    val expression = context.accept(new ExpressionVisitor)

    CompilationUnit(expression)
  }
}
