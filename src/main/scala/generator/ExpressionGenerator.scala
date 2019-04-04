package generator

import ast._
import org.objectweb.asm.{MethodVisitor, Opcodes}

class ExpressionGenerator(visitor: MethodVisitor) {
  private val valueExpressionGenerator = new ValueExpressionGenerator(this, visitor)

  def generate(expression: Value): Unit = {
    valueExpressionGenerator generate expression
  }

  def generate(expression: MultiplyExpression): Unit = {
    acceptLeftAndRight(expression)
    visitor visitInsn Opcodes.IMUL
  }

  def generate(expression: DivideExpression): Unit = {
    acceptLeftAndRight(expression)
    visitor visitInsn Opcodes.IDIV
  }

  def generate(expression: AddExpression): Unit = {
    acceptLeftAndRight(expression)
    visitor visitInsn Opcodes.IADD
  }

  private def acceptLeftAndRight(expression: ArithmeticExpression): Unit = {
    val left = expression.left
    val right = expression.right

    left accept this
    right accept this
  }

  def generate(expression: SubtractExpression): Unit = {
    acceptLeftAndRight(expression)
    visitor visitInsn Opcodes.ISUB
  }
}
