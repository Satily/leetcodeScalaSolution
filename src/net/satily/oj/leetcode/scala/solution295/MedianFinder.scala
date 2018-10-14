package net.satily.oj.leetcode.scala.solution295

class MedianFinder() {
  private val small: scala.collection.mutable.PriorityQueue[Int] = scala.collection.mutable.PriorityQueue.empty[Int]
  private val big: scala.collection.mutable.PriorityQueue[Int] = scala.collection.mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
  private var median: Option[Int] = None

  def addNum(num: Int): Unit = {
    median = median match {
      case None =>
        if (num < small.headOption.getOrElse(Int.MinValue)) {
          small.enqueue(num)
          Some(small.dequeue())
        } else if (num > big.headOption.getOrElse(Int.MaxValue)) {
          big.enqueue(num)
          Some(big.dequeue())
        } else {
          Some(num)
        }
      case Some(x) if x > num =>
        small.enqueue(num)
        big.enqueue(x)
        None
      case Some(x) =>
        small.enqueue(x)
        big.enqueue(num)
        None
    }
  }

  def findMedian(): Double = {
    median match {
      case Some(x) => x.toDouble
      case None => small.headOption.flatMap(s => big.headOption.map(_ + s)).getOrElse(0).toDouble / 2
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val medianFinder = new MedianFinder
    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian())
    medianFinder.addNum(3)
    println(medianFinder.findMedian())
  }
}