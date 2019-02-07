package com.example.dictionarypath.path

import com.example.dictionarypath.WordChecker
import com.example.dictionarypath.database.GetWords

class FindPath {
    var wordChecker = WordChecker()
    var words = GetWords().GetWords()
    var paths: ArrayList<ArrayList<String>> = ArrayList()
    var brokenPaths: ArrayList<ArrayList<String>> = ArrayList()
    var adjacentNodes: ArrayList<Node> = FindAdjacentWords()


    fun FindPath(word1: String, word2: String) : ArrayList<String> {
        var path: ArrayList<String> = ArrayList()
        paths.add(FindNextPath(word1, word2))

        return path
    }

    fun FindNextPath(word1: String, word2: String) : ArrayList<String> {
        var skipWords: ArrayList<String> = ArrayList()
        skipWords.add(word1)
        var nextPath: ArrayList<String> = ArrayList()
        nextPath.add(word1)

        if (!word1.equals(word2)) {
            while (true) {
                var addWord = true
                var next = FindNextWord(nextPath.get(nextPath.size - 1), skipWords)
                if (next.equals(word2))
                    break
                if (next.length == 0) {
                    brokenPaths.add(nextPath)
                    // reset the current path and restart for the next one
                    nextPath = ArrayList()
                    nextPath.add(word1)
                    addWord = false
                } else {
                    for (broken in brokenPaths) {
                        if (broken.size == nextPath.size + 1) {
                            if (next.equals(broken.get(broken.size - 1))) {
                                skipWords.add(next)
                                addWord = false
                                break
                            }
                        }
                    }
                }
                if (addWord) {
                    nextPath.add(next)
                    skipWords.add(next)
                }
            }
        }
        nextPath.add(word2)
        return nextPath
    }

    fun FindNextWord(word1: String, used: ArrayList<String>) : String {
        var next = ""

        for (word in words) {
            if (WordChecker().CheckWordDifferences(word1, word) == 1) {
                var found = false
                for (lookup in used) {
                    if (lookup.equals(word))
                        found = true
                }
                if (!found) {
                    next = word
                    break
                }
            }
        }
        return next
    }

    fun FindAdjacentWords() : ArrayList<Node> {
        var nodes = ArrayList<Node>()
        for (i in 0..(words.size - 2)) {
            var word1 = words.get(i)
            for (j in (i+1)..(words.size - 1)) {
                var word2 = words.get(j)
                if (wordChecker.CheckWordDifferences(word1, word2) == 1) {
                    nodes.add(Node(word1, word2))
                }
            }
        }
        return nodes
    }

    class Node( var word1: String,
                var word2: String) {}
}