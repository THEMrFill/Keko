package com.example.dictionarypath.database

class GetWords {
    fun GetWords(len: Int = 0) : List<String> {
        var words: List<String> = ArrayList()
        if (len == 0) {
//            words = arrayOf("lack" ,"hack", "lick", "pick", "sick", "hock", "lock", "dock", "sock", "mock", "work", "worm", "turn", "torn", "word").toList()
            words = arrayOf("lack" ,"hack", "lick", "sick", "sock", "mock", "work", "worm").toList()
        }
        return words
    }
}