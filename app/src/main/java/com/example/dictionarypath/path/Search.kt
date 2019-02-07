package com.example.dictionarypath.path

import java.util.*

class Search {
    constructor() {
        this.START = "lack"
        this.END = "mock"
    }
    constructor(START: String, END: String) {
        this.START = START
        this.END = END
    }
    var START: String = ""
    var END: String = ""
    var paths = ArrayList<ArrayList<String>>()

    private fun depthFirst(graph: Graph, visited: LinkedList<String>) {
        val nodes = graph.adjacentNodes(visited.getLast())
        // examine adjacent nodes
        for (node in nodes) {
            if (visited.contains(node)) {
                continue
            }
            if (node == END) {
                visited.add(node)
//                printPath(visited)
                var newList = ArrayList<String>()
                for (word in visited) {
                    newList.add(word)
                }
                paths.add(newList)
                visited.removeLast()
                break
            }
        }
        for (node in nodes) {
            if (visited.contains(node) || node == END) {
                continue
            }
            visited.addLast(node)
            depthFirst(graph, visited)
            visited.removeLast()
        }
    }

    private fun printPath(visited: LinkedList<String>) {
        for (node in visited) {
            print(node)
            print(" ")
        }
        println()
    }

    fun main() {
        // this graph is directional
        val graph = Graph()
        for (node in FindPath().adjacentNodes) {
            graph.addEdge(node.word1, node.word2)
        }
        val visited = LinkedList<String>()
        visited.add(START)
        depthFirst(graph, visited)
    }
}