package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*kisiSil()
        kisiEkle()
        kisiUdapte()
        tumKisiler()*/

    }

    fun kisiSil(){

        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiSil(387).enqueue(object : Callback<CRUDCevap> {

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun kisiEkle(){

        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiEkle("Aybüke FIRAT", "123456789").enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }

        })
    }

    fun kisiUdapte(){

        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.kisiUpdate(388,"updatetest", "12345").enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null){
                    Log.e("Başarı",response.body().success.toString())
                    Log.e("Mesaj", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }

        })
    }

    fun tumKisiler(){

        val kdi = ApiUtils.getKisilerDaoInterface()
        kdi.tumKisiler().enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if (response!=null){

                    val kisiListe = response.body().kisiler

                    for (i in kisiListe){
                        Log.e("kisi id", (i.kisiId).toString())
                        Log.e("kisi ad", i.kisiAd)
                        Log.e("kisi tel", i.kisiTel)
                    }

                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }
        })




    }




}