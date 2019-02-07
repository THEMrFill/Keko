package com.example.dictionarypath

import org.junit.Test
import org.junit.Assert.*

class WordCheckerTests {
    val wordChecker = WordChecker()
    var getWords = LookupWords()

    @Test
    fun TestWordsEmpty() {
        assertFalse(wordChecker.CheckWordLengths("", ""))
    }
    @Test
    fun TestWordsNotSameLength() {
        assertFalse(wordChecker.CheckWordLengths("word", "word2"))
    }
    @Test
    fun TestWordsSameLength() {
        assertTrue(wordChecker.CheckWordLengths("word", "word"))
    }

    @Test
    fun TestWordSimilarity() {
        assertEquals(wordChecker.CheckWordDifferences("word", "word"), 0)
    }
    @Test
    fun TestWordSimilarityOne() {
        assertEquals(wordChecker.CheckWordDifferences("word", "work"), 1)
    }
    @Test
    fun TestWordSimilarityFour() {
        assertEquals(wordChecker.CheckWordDifferences("word", "seen"), 4)
    }

    @Test
    fun TestWordStepsZero() {
        assertEquals(wordChecker.CheckWordSteps("word", "word"), 0)
    }
    @Test
    fun TestWordStepsOne() {
        assertEquals(wordChecker.CheckWordSteps("word", "work"), 1)
    }
}