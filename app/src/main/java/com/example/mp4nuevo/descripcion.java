package com.example.mp4nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class descripcion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        TextView nombrepeli=findViewById(R.id.nombrepeli);
        TextView descri=findViewById(R.id.descri);
        ImageView imagenpeli=findViewById(R.id.imagenpeli);
        ImageButton play=findViewById(R.id.play);
        ArrayAdapter<CharSequence> pelis = ArrayAdapter.createFromResource(this,R.array.links,android.R.layout.simple_list_item_1);
        String peli= getIntent().getStringExtra("index").toString();

        String[] array = pelis.getItem(Integer.valueOf(peli)).toString().split("---");
        nombrepeli.setText(array[2]);
        descri.setText(array[3]);
        imagenpeli.setImageResource(this.getResources().getIdentifier("@drawable/"+ array[0], "string", this.getPackageName()));
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pelicula=array[1];
                play(pelicula);
            }
        });

    }
    void play(String pelicula){
        Intent intent= new Intent(this, peliculas.class);
        intent.putExtra("pelicula",pelicula);
        startActivity(intent);
    }
}