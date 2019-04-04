import java.io.FileOutputStream

import org.antlr.v4.runtime.{ANTLRFileStream, CharStream}

object Main {
  def main(args: Array[String]): Unit = {
    val sourceFilePath = "/home/hub/workspace/LiteratureScala/resource/test.li"
    val sourceCode: CharStream = new ANTLRFileStream(sourceFilePath)

    val byteCode = Compiler.compile(sourceCode)

    val className = "Main"
    val fileName = className + ".class"
    val outputStream = new FileOutputStream(fileName)
    outputStream write byteCode
  }
}
