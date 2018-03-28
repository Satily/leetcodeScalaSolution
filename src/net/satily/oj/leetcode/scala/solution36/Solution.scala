package net.satily.oj.leetcode.scala.solution36

object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        def vaildate(nums: Seq[Int]): Boolean = nums.toSet.size == nums.size
        def removeDot(chars: Seq[Char]): Seq[Int] = chars.filterNot('.' == _).map(_.toInt)
        val vaildateSubboard: Seq[Char] => Boolean = removeDot _ andThen vaildate
        Seq(
            board.map(_.toSeq).toSeq,
            board.flatMap(_.zipWithIndex).groupBy(_._2).values.map(_.map(_._1).toSeq).toSeq,
            board.map(_.zipWithIndex.toSeq).zipWithIndex.toSeq.flatMap {
                case (row, rowIndex) => row.map {
                    case (element, columnIndex) => (element, rowIndex, columnIndex)
                }
            }.groupBy(t => (t._2 / 3, t._3 / 3)).map(_._2.map(_._1))
        ).flatten
        .map(_.filterNot('.' == _).map(_.toInt))
        .forall(s => s.toSet.size == s.size)
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(
            Solution.isValidSudoku(
                Array(
                    Array('5', '3', '.', '.', '7', '.','.', '.', '.'),
                    Array('6', '.', '.', '1', '9', '5','.', '.', '.'),
                    Array('.', '9', '8', '.', '.', '.','.', '6', '.'),
                    Array('8', '.', '.', '.', '6', '.','.', '.', '3'),
                    Array('4', '.', '.', '8', '.', '3','.', '.', '1'),
                    Array('7', '.', '.', '.', '2', '.','.', '.', '6'),
                    Array('.', '6', '.', '.', '.', '.','2', '8', '.'),
                    Array('.', '.', '.', '4', '1', '9','.', '.', '5'),
                    Array('.', '.', '.', '.', '8', '.','.', '7', '9')
                )
            )
        )
    }
}