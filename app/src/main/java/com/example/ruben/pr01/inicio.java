package com.example.ruben.pr01;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import android.widget.TextView;





public class inicio extends ActionBarActivity {

    final public static String DATOS_nombre = "com.example.ruben.pr01.DicNombre"; // es bueno definir el nombre de la variable para poder diferenciara entre otras app
    //DEFINIMOS la key para la entrada en mi diccionario, con el final hacemos que el valor no se pueda modificar en ningun sitio y es publica para todos
    final public static String DATOS_apellido = "com.example.ruben.pr01.DicApellido";

    public String Sexo;
    final public static String DATOS_sex = "com.example.ruben.pr01.DicSex";

    final public static String DATOS_fecha = "com.example.ruben.pr01.DicFecha";

    //final public static String DATOS_peso = "com.example.ruben.pr01.DicPeso";


    TextView elseekPeso ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        SeekBar seekBar;

        seekBar = (SeekBar) findViewById(R.id.skeePeso);

        elseekPeso = (TextView) findViewById(R.id.ShowPeso);

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {


            @Override

            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                elseekPeso.setText("" + progresValue); //  asignamos el valor al view

            }
            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });



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

            switch(item.getItemId()) {
                case R.id.action_settings:

                    return true;

                case R.id.action_send:

                    SendValues(findViewById(id));

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


        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkCondiciones);
        if (checkBox.isChecked()) {


            Intent newView = new Intent(this, getdatos.class); //preparamos la view que queremos lanzar

            //recivimos los datos

            //nombre

            EditText NombreUsiario = (EditText) findViewById(R.id.formNombre);
            String myName = NombreUsiario.getText().toString();
            newView.putExtra(DATOS_nombre, myName); //añadimos el valor de la variable al diccionario

            //apellido

            EditText ApellidoUsiario = (EditText) findViewById(R.id.formApellido);
            String myApe = ApellidoUsiario.getText().toString();
            newView.putExtra(DATOS_apellido, myApe); ////añadimos el valor de la variable al diccionario

            //Sex

            newView.putExtra(DATOS_sex, Sexo);


            //Fecha
            EditText FechaUsiario = (EditText) findViewById(R.id.Cumple);
            String myFecha = FechaUsiario.getText().toString();
            newView.putExtra(DATOS_fecha, myFecha); ////añadimos el valor de la variable al diccionario

            // trabajo & estudios

            final CheckBox checkBoxTrabajo = (CheckBox) findViewById(R.id.checkTrabajo);
            if (checkBoxTrabajo.isChecked()){

                newView.putExtra("siTrabaja", true);
            }
            final CheckBox checkBoxEstudios = (CheckBox) findViewById(R.id.checkEstudio);
            if (checkBoxEstudios.isChecked()){


                newView.putExtra("siEstudia", true);

            }











            startActivity(newView); //abrimos la nueva view, mirar mainactivity2.java funcion onCreate

        }else{
            new AlertDialog.Builder(this)
                    .setMessage("Tienes que aceptar las condiciones")
                    .setPositiveButton("ok", null)
                    .show();
        }



    }



}
