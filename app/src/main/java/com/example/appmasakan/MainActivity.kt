package com.example.appmasakan

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_makanan.view.*

class MainActivity : AppCompatActivity() {

    val listMakanan = ArrayList<Makanan>()
    var adapter : AdapterMakanan ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listMakanan.add(Makanan("Gepuk", "Gepuk Raos Nyonya Inong", R.drawable.gepuk))
        listMakanan.add(Makanan("Gurame", "Gepuk Mang Engking Asam Manis", R.drawable.gurame))
        listMakanan.add(Makanan("Jengkol", "Jengkol balado Nyonya Inong", R.drawable.jengkol))
        listMakanan.add(Makanan("Kerang", "Kerang hijau khas cikijing", R.drawable.kerang))
        listMakanan.add(Makanan("Sayur Lodeh", "Sayur lodeh raos", R.drawable.lodeh))
        listMakanan.add(Makanan("Lotek", "Lotek khas sunda", R.drawable.lotek))
        listMakanan.add(Makanan("Pepes Ikan", "Pepes ikan punclut", R.drawable.pais))
        listMakanan.add(Makanan("Rawon", "Nasi Rawon murmer", R.drawable.rawon))
        listMakanan.add(Makanan("Risoles", "Gorengan risoles", R.drawable.risoles))
        listMakanan.add(Makanan("Steak", "Steak sapi balados", R.drawable.steak))

        adapter = AdapterMakanan(this, listMakanan)
        gvListMakanan.adapter = adapter
    }

    inner class AdapterMakanan : BaseAdapter{
        var listMakanan = ArrayList<Makanan>()
        var context : Context ?= null
        constructor(context: Context, listOfFood: ArrayList<Makanan>) : super(){
            this.context = context
            this.listMakanan = listOfFood
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val makanan = this.listMakanan[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.item_makanan, null)
            foodView.ivGambarMakanan.setImageResource(makanan.gambar!!)
            foodView.ivGambarMakanan.setOnClickListener {
                val intent = Intent(context, DetailMakanan::class.java)
                intent.putExtra("nama", makanan.nama!!)
                intent.putExtra("deskripsi", makanan.deskripsi!!)
                intent.putExtra("gambar", makanan.gambar!!)
                context!!.startActivity(intent)
            }
            foodView.tvNamaMakanan.text = makanan.nama!!
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listMakanan[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listMakanan.size
        }
    }
}
