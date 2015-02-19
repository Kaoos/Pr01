package com.example.ruben.pr01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;



public class inicio extends ActionBarActivity {

    final public static String DATOS_nombre = "com.example.ruben.pr01.DicNombre"; // es bueno definir el nombre de la variable para poder diferenciara entre otras app
    //DEFINIMOS la key para la entrada en mi diccionario, con el final hacemos que el valor no se pueda modificar en ningun sitio y es publica para todos
    final public static String DATOS_apellido = "com.example.ruben.pr01.DicApellido";

    public String Sexo;
    final public static String DATOS_sex = "com.example.ruben.pr01.DicSex";

    final public static String DATOS_fecha = "com.example.ruben.pr01.DicFecha";

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

//Miramos que radio buton esta seleccionado
    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fomrSexo01:

                    Sexo = "Hombre";

                    break;
            case R.id.fomrSexo02:

                    Sexo = "Mujer";

                    break;
        }
    }


//iniciamos la funcion del boton

    public void SendValues (View myText){




            Intent newView = new Intent(this, getdatos.class); //preparamos la view que queremos lanzar

            //recivimos los datos

            //nombre

            EditText NombreUsiario = (EditText) findViewById(R.id.formNombre);
            String myName = NombreUsiario.getText().toString(); // Nom tenemos lo que ha introducido el usuario en el campo txtNombre
            newView.putExtra(DATOS_nombre, myName); //añadimos el valor de la variable al diccionario

            //apellido

            EditText ApellidoUsiario = (EditText) findViewById(R.id.formApellido);
            String myApe = ApellidoUsiario.getText().toString(); // Ape tenemos lo que ha introducido el usuario en el campo txtApellido
            newView.putExtra(DATOS_apellido, myApe); ////añadimos el valor de la variable al diccionario

            //Sex

            newView.putExtra(DATOS_sex, Sexo);


            //Fecha
            EditText FechaUsiario = (EditText) findViewById(R.id.Cumple);
            String myFecha = FechaUsiario.getText().toString(); // Ape tenemos lo que ha introducido el usuario en el campo txtApellido
            newView.putExtra(DATOS_fecha, myFecha); ////añadimos el valor de la variable al diccionario




            startActivity(newView); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate




    }



}
