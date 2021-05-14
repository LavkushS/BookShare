package com.firstapp.bookshare

//import com.codinginflow.recyclerviewexample.ExampleAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myCollection=findViewById<TextView>(R.id.myCollection)
        val next=findViewById<FloatingActionButton>(R.id.next)
        val recyclerview=findViewById<RecyclerView>(R.id.RecyclerView)


        val exampleList = generateDummyList(500)
        recyclerview.adapter = ExampleAdapter(exampleList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)


        next.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //here
                startActivity(Intent(this@MainActivity, store::class.java))
            }
        })

    }
    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_book
               // 1 -> R.drawable.ic_audio
                else -> R.drawable.ic_baseline_book
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}