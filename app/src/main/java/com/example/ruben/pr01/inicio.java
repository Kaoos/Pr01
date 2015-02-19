package com.example.ruben.pr01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class inicio extends ActionBarActivity {

    final public static String DATOS_nombre = "com.example.ruben.pr01.DicNombre"; // es bueno definir el nombre de la variable para poder diferenciara entre otras app
    //DEFINIMOS la key para la entrada en mi diccionario, con el final hacemos que el valor no se pueda modificar en ningun sitio y es publica para todos
    final public static String DATOS = "com.example.ruben.pr01.DicNombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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

//iniciamos la funcion del boton

    public void SendValues (View myText){

        Intent newView = new Intent(this, getdatos.class); //preparamos la view que queremos lanzar

        //recivimos los datos de los diferentes EditText

        EditText NombreUsiario = (EditText) findViewById(R.id.formNombre);
        String myName = NombreUsiario.getText().toString(); // Nom tenemos lo que ha introducido el usuario en el campo txtNombre
        newView.putExtra(DATOS,myName ); //añadimos el valor de la variable al diccionario


        EditText ApellidoUsiario = (EditText) findViewById(R.id.formApellido);
        String myApe = ApellidoUsiario.getText().toString(); // Ape tenemos lo que ha introducido el usuario en el campo txtApellido
        newView.putExtra(DATOS,myApe ); ////añadimos el valor de la variable al diccionario







        startActivity(newView); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate

    }



}
