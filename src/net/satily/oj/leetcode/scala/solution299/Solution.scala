package net.satily.oj.leetcode.scala.solution299

object Solution {
    def getHint(secret: String, guess: String): String = {
        def folder(s: String) =
            s.foldLeft(Map.empty[Char, Int])((r, c) => r.updated(c, r.getOrElse(c, 0) + 1))


        val r = (
            secret.zip(guess)
                    .count(p =>p._1 == p._2),
            {
                for {
                    (sKey, sValue) <- folder(secret)
                    (gKey, gValue) <- folder(guess)
                    if sKey == gKey
                } yield (sKey, sValue.min(gValue))
            }.values.sum
        )

        s"${r._1}A${r._2 - r._1}B"
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(Solution.getHint("1807", "7810"))
        println(Solution.getHint("1123", "0111"))
    }
}

