package net.satily.oj.leetcode.scala.solution537

case class Complex(real: Int, imag: Int) {
    override def toString: String = s"$real+${imag}i"
}

object Complex {
    def fromString(complex: String): Complex = {
        val s: Array[String] = complex.split('+')
        new Complex(s(0).toInt, s(1).substring(0, s(1).length - 1).toInt)
    }
    def toString(complex: Complex): String = s"${complex.real}+${complex.imag}i"
}

object Solution {
    def complexNumberMultiply(a: String, b: String): String = {
        val complexA = Complex.fromString(a)
        val complexB = Complex.fromString(b)
        Complex(
            complexA.real * complexB.real - complexA.imag * complexB.imag,
            complexA.imag * complexB.real + complexA.real * complexB.imag
        ).toString
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(Solution.complexNumberMultiply("1+1i", "1+1i"))
        println(Solution.complexNumberMultiply("1+-1i", "1+-1i"))
    }
}
