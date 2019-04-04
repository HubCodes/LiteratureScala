package ast

import generator.ExpressionGenerator

case class Value(value: String) extends Expression {

  override def accept(generator: ExpressionGenerator): Unit = {
    generator generate this
  }
}