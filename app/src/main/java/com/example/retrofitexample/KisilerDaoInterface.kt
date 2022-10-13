package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface KisilerDaoInterface {

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded

    fun kisiSil(@Field("kisi_id") kisi_id:Int): Call<CRUDCevap>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded

    fun kisiEkle(@Field("kisi_ad") kisi_ad:String,
                 @Field("kisi_tel") kisi_tel:String) : Call<CRUDCevap>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded

    fun kisiUpdate(@Field("kisi_id") kisi_id:Int
                   ,@Field("kisi_ad") kisi_ad: String
                   ,@Field("kisi_tel") kisi_tel: String )

    @GET("kisiler/tum_kisiler.php")
    fun tumKisiler():Call<KisilerCevap>

}