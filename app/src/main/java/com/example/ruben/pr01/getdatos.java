package com.example.ruben.pr01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class getdatos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdatos);// creamos la view


        // ----- Nombre -----
        Intent DiccionarioNombre = getIntent();//recuperarmos el diccionario Nombre

        String nom = DiccionarioNombre.getStringExtra(inicio.DATOS_nombre); // Assignamos el valor del nombre

        TextView elNombre = (TextView) findViewById(R.id.getNombre); // buscamos el view donde introducioremos los datos

        elNombre.setText(nom); //  asignamos el valor al view


        // ----- Apellido -----
        Intent DiccionarioApellido = getIntent();//recuperarmos el diccionario Apellido

        String ape = DiccionarioApellido.getStringExtra(inicio.DATOS_apellido); // Assignamos el valor del apellido

        TextView elApellido = (TextView) findViewById(R.id.getApellido); // buscamos el view donde introducioremos los datos

        elApellido.setText(ape); //  asignamos el valor al view


        // ----- Sexo -----
        Intent DiccionarioSexo = getIntent();//recuperarmos el diccionario Apellido

        String sex = DiccionarioSexo.getStringExtra(inicio.DATOS_sex); // Assignamos el valor del apellido

        TextView elSexo = (TextView) findViewById(R.id.getSexo); // buscamos el view donde introducioremos los datos

        elSexo.setText(sex); //  asignamos el valor al view

        // ----- Fecha -----
        Intent DiccionarioFecha = getIntent();//recuperarmos el diccionario Apellido

        String date = DiccionarioFecha.getStringExtra(inicio.DATOS_fecha); // Assignamos el valor del apellido

        TextView laFecha = (TextView) findViewById(R.id.getFecha); // buscamos el view donde introducioremos los datos

        laFecha.setText(date); //  asignamos el valor al view



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_getdatos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
