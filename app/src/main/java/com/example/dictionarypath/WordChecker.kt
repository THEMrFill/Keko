package com.example.dictionarypath

open class WordChecker {
    fun CheckWordLengths(word1: String, word2: String): Boolean {
        if (word1.length == 0 || word2.length == 0)
            return false
        if (word1.length != word2.length)
            return false
        return true
    }

    fun CheckWordDifferences(word1: String, word2: String): Int {
        if (!CheckWordLengths(word1, word2))
            return -1
        if (word1.equals(word2))
            return 0
        var counter = 0
        for (i in 0..(word1.length-1)) {
            if (!word1.substring(i, i+1).equals(word2.substring(i, i+1)))
                counter++
        }
        return counter
    }

    fun CheckWordSteps(word1: String, word2: String): Int {
        if (!CheckWordLengths(word1, word2))
            return -1
        if (word1.equals(word2))
            return 0
        return CheckWordDifferences(word1, word2)
    }
}