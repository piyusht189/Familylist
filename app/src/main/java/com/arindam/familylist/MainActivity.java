package com.arindam.familylist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends Activity {
    ListView list;
    String[] name = {
            "Mr. Father",
            "Mrs. Mom",
            "Mr. Brother",
            "Ms. Sister",
            "Mr. GrandPa",
            "Mrs. GrandMa",
    } ;
    String[] relation = {
            "Father",
            "Mother",
            "Brother",
            "Sister",
            "GrandFather",
            "GrandMother",
    } ;
    Integer[] imageId = {
            R.drawable.dad,
            R.drawable.mom,
            R.drawable.bro,
            R.drawable.sis,
            R.drawable.grandpa,
            R.drawable.grandma
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CustomList adapter = new CustomList(MainActivity.this, name, relation, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

}
