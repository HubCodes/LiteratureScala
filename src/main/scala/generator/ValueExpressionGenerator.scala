package generator

import ast.Value
import org.objectweb.asm.MethodVisitor

class ValueExpressionGenerator(generator: ExpressionGenerator, visitor: MethodVisitor) {
  def generate(value: Value): Unit = {
    val stringValue = value.value

    visitor visitLdcInsn stringValue.toInt
  }
}
