package com.example.dictionarypath

import com.example.dictionarypath.path.FindPath
import com.example.dictionarypath.path.Graph
import com.example.dictionarypath.path.Search
import org.junit.Test
import org.junit.Assert.*

class FindPathTests {
    val findPath = FindPath()

    @Test
    fun CompareWordsOne() {
        // same word, so no steps
        assertEquals(findPath.FindNextPath("word", "word").size, 2)
    }

    @Test
    fun FindNextWordTest() {
        // word order has "hack" following "lack", changing the words & order will break this test
        assertTrue(findPath.FindNextWord("lack", ArrayList()).equals("hack"))
    }

    @Test
    fun FindNextWordTestUsed() {
        // "lick" follows "hack" in the word list, changing the words & order will break this test
        var used : ArrayList<String> = ArrayList()
        used.add("hack")
        assertTrue(findPath.FindNextWord("lack", used).equals("lick"))
    }

    @Test
    fun FindNextWordTestThirdEmpty() {
        // "hack" should have no path from it
        var used : ArrayList<String> = ArrayList()
        used.add("lack")
        assertTrue(findPath.FindNextWord("hack", used).equals(""))
    }

    @Test
    fun FindNextWordTestThird() {
        // without "hack" in the line, we should skip to "lick"
        var used : ArrayList<String> = ArrayList()
        used.add("hack")
        assertTrue(findPath.FindNextWord("lack", used).equals("lick"))
    }

    @Test
    fun FindNextPathTest() {
        // finds a path, as long as it exists
        var path = findPath.FindNextPath("lack", "mock")
        assertTrue(path.size > 0)
    }

    @Test
    fun FindAdjacentTests() {
        var adjacent = findPath.adjacentNodes
        assertTrue(adjacent.size > 0)
    }

    @Test
    fun SearchTest() {
        var search = Search("lack", "word")
        search.main()
        assertTrue(search.paths.size > 0)
    }
}