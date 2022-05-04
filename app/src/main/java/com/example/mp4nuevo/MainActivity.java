package com.example.mp4nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    Integer i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crear(8);
    }
    public void crear(Integer fin){
        ImageButton btnguia=findViewById(R.id.btnguia);
        ImageButton btnguia2=findViewById(R.id.btnguia2);
        TableLayout tableLayout=findViewById(R.id.tablelayout);
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) btnguia.getLayoutParams();
        LinearLayout.LayoutParams params1= (LinearLayout.LayoutParams) btnguia2.getLayoutParams();
        ArrayAdapter<CharSequence> pelis= ArrayAdapter.createFromResource(this,R.array.links,android.R.layout.simple_list_item_1);
        TableRow row = new TableRow(this);
        TableRow rowdes=new TableRow(this);

        while(i!=fin){
            if(i%2==0){
                rowdes=new TableRow(this);
                row = new TableRow(this);
            }

            ImageButton ib= new ImageButton(this);
            ImageButton b= new ImageButton(this);
            CharSequence string = pelis.getItem(i);
            String[] array = string.toString().split("---");
            ib.setImageResource(this.getResources().getIdentifier("@drawable/"+ array[0], "string", this.getPackageName()));
            b.setTag(array[1]);
            ib.setLayoutParams(params);
            b.setLayoutParams(params1);
            b.setImageResource(R.drawable.pelicula);
            b.setBackgroundResource(R.color.transparente);
            b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ib.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ib.setTag(i);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    des(ib);
                }
            });
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    peliculaescogida(b);
                }
            });

            //ib.setText(array!!.get(0))
            ib.setBackgroundResource(R.color.transparente);
            row.addView(ib);
            rowdes.addView(b);
            if(i%2==0) {
                tableLayout.addView(rowdes,0);
                tableLayout.addView(row, 0);
            }
            i++;

        }

    }
    void des(View view){
        String index=view.getTag().toString();
        Intent intent= new Intent(this, descripcion.class);
        intent.putExtra("index",index);
        startActivity(intent);

    }


    void peliculaescogida(View view){

        String pelicula=view.getTag().toString();
        Intent intent= new Intent(this,peliculas.class);
        intent.putExtra("pelicula",pelicula);
        startActivity(intent);
    }



    public void siguiente(View view) {
        TableLayout tableLayout=findViewById(R.id.tablelayout);
        Integer cantidad=0;

        ArrayAdapter<CharSequence> pelis = ArrayAdapter.createFromResource(this,R.array.links,android.R.layout.simple_list_item_1);
        if(i<pelis.getCount()) {
            tableLayout.removeAllViews();
            if (i + 8 > pelis.getCount()) {
                cantidad = pelis.getCount();
            } else {
                cantidad = i + 8;
            }
            crear(cantidad);
        }
    }

    public void anterior(View view) {
        TableLayout tableLayout=findViewById(R.id.tablelayout);
        Integer cantidad=i;
        ArrayAdapter<CharSequence> pelis= ArrayAdapter.createFromResource(this,R.array.links,android.R.layout.simple_list_item_1);

        if(i>8) {
            tableLayout.removeAllViews();
            if (i%8==0) {
                cantidad=i;
                i=i-8;
            } else {
                while(i%8!=0){
                    i--;
                }
                cantidad=i;
                i=i-8;
            }
            crear(cantidad);
        }
    }
}