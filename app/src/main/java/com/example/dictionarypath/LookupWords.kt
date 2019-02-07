package com.example.dictionarypath

import android.net.Uri
import java.io.File

class LookupWords {
    fun GetStrings(fileName: String): ArrayList<String> {
        var wordList = ArrayList<String>()
        //val fileName = "raw/wordslist.txt"
        val uri = Uri.parse("android.resource://com.example.dictionarypath/raw/" + fileName)
        val file = File(uri.getPath())
        file.forEachLine {
            if (it.length > 0)
                wordList.add(it)
        }
        return wordList
    }
}