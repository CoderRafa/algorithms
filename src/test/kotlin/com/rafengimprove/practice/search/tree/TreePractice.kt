package com.rafengimprove.practice.search.tree

interface Tree {
    fun add(element: Int)
    fun contains(element: Int): Boolean
    fun size(node: Node? = null): Int
}

class BinaryTree(list: List<Int>): Tree {
    private var root: Node

    init {
        val sorted = list.sorted()
        val mid = sorted.size / 2
        root = Node(sorted[mid])
        addLeft(root, sorted.subList(0, mid))
        addRight(root, sorted.subList(mid + 1, sorted.size))
    }

    private fun addLeft(element: Node, leftPart: List<Int>) {
        if (leftPart.isNotEmpty()) {
            element.left = Node(leftPart[leftPart.size - 1])
            if (leftPart.size > 1) {
                addLeft(element.left!!, leftPart.subList(0, leftPart.size - 1))
            }
        }
    }
    private fun addRight(element: Node, rightPart: List<Int>) {
        if (rightPart.isNotEmpty()) {
            element.right = Node(rightPart[0])
            if (rightPart.size > 1) {
                addRight(element.right!!, rightPart.subList(1, rightPart.size))
            }
        }
    }
    override fun add(element: Int) {
        TODO("Not yet implemented")
    }
    override fun contains(element: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun size(node: Node?): Int {
        var result = 0
        result += if (node != null) {
            if (node.hasLeft()) {
                1 + size(node.left)
            } else if (node.hasRight()) {
                1 + size(node.right)
            } else {
                1
            }
        } else {
            1 + size(root)
        }
        return result
    }

    fun printAll(element: Node = root, type: DirectionType = DirectionType.ASC) {
        when(type) {
            DirectionType.ASC -> printAsc(element)
            DirectionType.DESC -> printDesc(element)
        }
    }

    private fun printDesc(element: Node) {
        TODO("Not yet implemented")
    }

    private fun printAsc(element: Node) {
        if (element.hasLeft()) {
            printAsc(element.left!!)
        } else if (element.hasRight()) {
            printAsc(element.right!!)
        } else {
            println(element.value)
        }
    }
}

data class Node (
    var value: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun Node.hasLeft() = left != null
fun Node.hasRight() = right != null

enum class DirectionType {
    ASC, DESC
}

val binaryTree = BinaryTree(listOf(2,5,4,3,1,0,7,9))

