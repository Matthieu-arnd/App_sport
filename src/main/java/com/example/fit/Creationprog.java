package com.example.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Creationprog extends AppCompatActivity {

    private ListView listView_seance;

    private ArrayList<String> Listeofseance = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationprog);

        listView_seance = findViewById(R.id.type_seance);

        Listeofseance.add("Séance 1");
        Listeofseance.add("Séance 2");
        Listeofseance.add("Séance 3");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Listeofseance);

        listView_seance.setAdapter(adapter);


    }
}
