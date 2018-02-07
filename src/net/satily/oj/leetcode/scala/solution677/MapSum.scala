package net.satily.oj.leetcode.scala.solution677

class TrieNode {
    var count: Int = 0
    val children: scala.collection.mutable.Map[Char, TrieNode] = scala.collection.mutable.Map.empty
    def getChild(char: Char): TrieNode = children.getOrElse(char, {
        val node = new TrieNode
        children.put(char, node)
        node
    })
}

class MapSum {
    val root: TrieNode = new TrieNode
    val keyMap: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map.empty

    def insert(key: String, `val`: Int) {
        var p = root
        val valInc = `val` - keyMap.put(key, `val`).getOrElse(0)
        p.count += valInc
        for (char <- key) {
            p = p.getChild(char)
            p.count += valInc
        }
    }

    def sum(prefix: String): Int = {
        var p = root
        for (char <- prefix) {
            p = p.getChild(char)
        }
        p.count
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        var obj = new MapSum()
        obj.insert("aa", 3)
        println(obj.sum("a"))
        obj.insert("aa", 2)
        println(obj.sum("a"))
    }
}