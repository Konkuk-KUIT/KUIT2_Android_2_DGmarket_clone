package com.example.carrotmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//데이터베이스가 가지고 있는 테이블이 무엇인지, 데이터베이스 Version이 무엇인지 명시해줌.
@Database(entities = [MyProduct::class], version = 1)
//추상 클래스는 Room DB를 상속하고 있음.
abstract class MyProductDatabase : RoomDatabase() {
    //DB에 접근할 수 있는 DAO를 가짐. 그 DAO를 가져오는 Abstract 선언
    abstract fun getMyProductDAO() : MyProductDAO

    //MyProductEntity 편집 가능 → singleton pattern 이용
    //companion object : 자바의 static 같은 존재로, 항상 객체가 존재함
    companion object{
        var instance : MyProductDatabase? = null
        //MyProductDB를 가져올 수 있게 getInstance를 만듦.
        //getInstance는 .으로 접근할 수 있음. getInstance함수를 호출하면 MyProductDB를 호출함
        fun getInstance(context: Context) : MyProductDatabase{
            if(instance == null){
                //databaseBuilder : 데이터베이스를 만들어주는 함수, Room DB 사용법대로 만들어놓은 MyProductDB를 넘겨주면 알아서 DB를 만들어서 넘겨줌
                instance = Room.databaseBuilder(
                    //context를 넘겨주므로, context를 받아옴.
                    //여기선 fragment이므로, applicationContext를 받아옴.
                    context.applicationContext,
                    //database class를 넣어줌.
                    MyProductDatabase::class.java,
                    //database name
                    "myproduct-database"
                ).fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }

    }
}