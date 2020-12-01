package com.example.simpleadapter;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String []{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int [] imageIds =new int[] {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> listItems= new ArrayList<>();
        for(int i= 0;i<names.length;i++)
        {
            Map<String,Object>listItem=new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItems.add(listItem);

        }
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.simple_item,new String []{"personName","header"},new  int[]{R.id.name,R.id.header});
        ListView list =findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_SHORT).show();
            }
        });


    }
}

























