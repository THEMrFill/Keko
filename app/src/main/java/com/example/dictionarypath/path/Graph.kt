package com.example.dictionarypath.path

import java.util.*

class Graph {
    var map: HashMap<String, LinkedHashSet<String>> = HashMap()

    fun addEdge(node1: String, node2: String) {
        var adjacent = map.get(node1)
        if (adjacent == null) {
            adjacent = LinkedHashSet()
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    fun addTwoWayVertex(node1: String, node2: String) {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    fun isConnected(node1: String, node2: String): Boolean {
        var adjacent = map.get(node1)
        if (adjacent == null) {
            return false
        }
        return adjacent.contains(node2)
    }

    fun adjacentNodes(last: String ): LinkedList<String> {
        var adjacent: LinkedHashSet<String>? = map.get(last)
        if (adjacent == null) {
            return LinkedList()
        }
        return LinkedList<String>(adjacent);
    }
}