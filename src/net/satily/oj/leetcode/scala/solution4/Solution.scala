package net.satily.oj.leetcode.scala.solution4

object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var p1: Int = 0
    var p2: Int = 0
    var sum: Int = 0

    def nextNum: Int = {
      var result: Int = 0
      (p1 < nums1.length, p2 < nums2.length) match {
        case (false, _) =>
          result = nums2(p2)
          p2 += 1
        case (_, false) =>
          result = nums1(p1)
          p1 += 1
        case _ if nums1(p1) < nums2(p2) =>
          result = nums1(p1)
          p1 += 1
        case _ =>
          result = nums2(p2)
          p2 += 1
      }
      result
    }

    while (p1 + p2 < (nums1.length + nums2.length) / 2) {
      sum = nextNum
    }
    (nums1.length + nums2.length) & 1 match {
      case 0 => (sum + nextNum).toDouble / 2
      case 1 => nextNum
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.findMedianSortedArrays(Array(1, 3), Array(2)))
    println(Solution.findMedianSortedArrays(Array(1, 2), Array(3, 4)))
    println(Solution.findMedianSortedArrays(Array(1, 2), Array(3, 4, 5, 6, 7)))
  }
}
