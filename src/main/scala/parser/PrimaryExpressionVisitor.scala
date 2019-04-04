package parser

import ast.{Expression, Value}
import syntax.LiteratureBaseVisitor
import syntax.LiteratureParser.{NestedExpressionContext, ValueContext, ValueExpressionContext}

class PrimaryExpressionVisitor(visitor: ExpressionVisitor) extends LiteratureBaseVisitor[Expression] {
  override def visitValueExpression(ctx: ValueExpressionContext): Expression = visitValue(ctx.value)

  override def visitValue(ctx: ValueContext): Expression = Value(ctx.getText)

  override def visitNestedExpression(ctx: NestedExpressionContext): Expression = ctx.expression.accept(visitor)
}
