package parser

import ast._
import syntax.LiteratureBaseVisitor
import syntax.LiteratureLexer._
import syntax.LiteratureParser.{AdditiveExpressionContext, MultiplicativeExpressionContext}

class ArithmeticExpressionVisitor(private val expressionVisitor: ExpressionVisitor)
  extends LiteratureBaseVisitor[ArithmeticExpression] {

  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext): ArithmeticExpression = {
    ctx.op.getType match {
      case MULTIPLY => visitMultiplyExpression(ctx)
      case DIVIDE => visitDivideExpression(ctx)
      case _ => ??? // TODO: throw exception
    }
  }

  private def visitMultiplyExpression(ctx: MultiplicativeExpressionContext): ArithmeticExpression = {
    val (left, right) = visitChildren(ctx)

    MultiplyExpression(left, right)
  }

  private def visitChildren(ctx: MultiplicativeExpressionContext): (Expression, Expression) = {
    val left = ctx.expression(0)
    val right = ctx.expression(1)

    (left accept expressionVisitor, right accept expressionVisitor)
  }

  private def visitDivideExpression(ctx: MultiplicativeExpressionContext): ArithmeticExpression = {
    val (left, right) = visitChildren(ctx)

    DivideExpression(left, right)
  }

  override def visitAdditiveExpression(ctx: AdditiveExpressionContext): ArithmeticExpression = {
    ctx.op.getType match {
      case ADD => visitAddExpression(ctx)
      case SUBTRACT => visitSubtractExpression(ctx)
      case _ => ??? // TODO: throw exception
    }
  }

  private def visitAddExpression(ctx: AdditiveExpressionContext): ArithmeticExpression = {
    val (left, right) = visitChildren(ctx)

    AddExpression(left, right)
  }

  private def visitChildren(ctx: AdditiveExpressionContext): (Expression, Expression) = {
    val left = ctx.expression(0)
    val right = ctx.expression(1)

    (left accept expressionVisitor, right accept expressionVisitor)
  }

  private def visitSubtractExpression(ctx: AdditiveExpressionContext): ArithmeticExpression = {
    val (left, right) = visitChildren(ctx)

    SubtractExpression(left, right)
  }
}
