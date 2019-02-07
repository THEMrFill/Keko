package com.example.dictionarypath

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dictionarypath.database.GetWords
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.dictionarypath.path.Search


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findPath.setOnClickListener({ checkWords()})

        var wordsList = GetWords().GetWords()
        val adapter1 = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            wordsList
        )
        val adapter2 = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            wordsList
        )
        word1.adapter = adapter1
        word2.adapter = adapter2
    }

    fun checkWords() {
        var search = Search(word1.selectedItem as String, word2.selectedItem as String)
        search.main()
        var shortest = ArrayList<String>()
        var len = 99
        var long = 0
        for (item in search.paths) {
            if (item.size < len) {
                shortest = item
                len = item.size
            }
            if (item.size > long)
                long = item.size
        }
        longest.text = String.format("%d", long)
        var adapter = ShortestWords(shortest)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    class ShortestWords: RecyclerView.Adapter<ShortestWords.Holder> {
        var list = ArrayList<String>()
        constructor(list: ArrayList<String>) {
            this.list = list
        }
        override fun onCreateViewHolder(parent: ViewGroup, type: Int): ShortestWords.Holder {
            val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_text_view, parent, false) as TextView
            return Holder(textView)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ShortestWords.Holder, position: Int) {
            holder.textView.text = list.get(position)
        }

        class Holder(val textView: TextView): RecyclerView.ViewHolder(textView) { }
    }
}
