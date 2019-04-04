package parser

import ast.Expression
import syntax.LiteratureBaseVisitor
import syntax.LiteratureParser.{AdditiveExpressionContext, MultiplicativeExpressionContext, PrimExpressionContext}

class ExpressionVisitor extends LiteratureBaseVisitor[Expression] {
  private val arithmeticExpressionVisitor = new ArithmeticExpressionVisitor(this)
  private val primaryExpressionVisitor = new PrimaryExpressionVisitor(this)

  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext): Expression = {
    arithmeticExpressionVisitor.visitMultiplicativeExpression(ctx)
  }

  override def visitAdditiveExpression(ctx: AdditiveExpressionContext): Expression = {
    arithmeticExpressionVisitor.visitAdditiveExpression(ctx)
  }

  override def visitPrimExpression(ctx: PrimExpressionContext): Expression = {
    primaryExpressionVisitor.visitPrimExpression(ctx)
  }
}
