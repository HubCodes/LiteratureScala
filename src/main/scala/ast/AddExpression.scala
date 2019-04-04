package ast

import generator.ExpressionGenerator

case class AddExpression(override val left: Expression, override val right: Expression)
  extends ArithmeticExpression(left, right) {

  override def accept(generator: ExpressionGenerator): Unit = {
    generator generate this
  }
}