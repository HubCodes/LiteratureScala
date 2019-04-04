package generator

import ast.Expression
import org.objectweb.asm.{ClassWriter, Opcodes}

class ClassGenerator {
  private val classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS)

  def generate(expression: Expression): ClassWriter = {
    val classVersion = ClassGenerator.CLASS_VERSION
    val publicStatic = Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC
    val className = "Main"
    val classInherits = "java/lang/Object"

    classWriter.visit(classVersion, publicStatic, className, null, classInherits, null)

    val methodName = "main"
    val methodSignature = "([Ljava/lang/String;)V"
    val methodVisitor = classWriter.visitMethod(publicStatic, methodName, methodSignature, null, null)

    methodVisitor.visitCode()
    methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")

    val expressionGenerator = new ExpressionGenerator(methodVisitor)
    expression accept expressionGenerator
    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Ljava/io/PrintStream;", "println", "(I)V", false)
    methodVisitor visitInsn Opcodes.RETURN
    methodVisitor.visitMaxs(-1, -1)
    methodVisitor.visitEnd()

    classWriter.visitEnd()
    classWriter
  }
}

object ClassGenerator {
  val CLASS_VERSION = 52
}
