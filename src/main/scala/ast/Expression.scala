package ast

import generator.ExpressionGenerator

trait Expression {
  def accept(generator: ExpressionGenerator)
}
