package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlaza con label de id texto1
        final TextView lblEtiqueta = (TextView) findViewById(R.id.texto1);
        String texto = lblEtiqueta.getText().toString();
        texto += " concatenado";
        lblEtiqueta.setText(texto);

        //EditText
        final EditText txtEdit = (EditText) findViewById(R.id.editTexto);
        texto = txtEdit.getText().toString();
        txtEdit.setText("Nuevo Texto");

        //Evento Button
        final Button btnBoton1 = (Button) findViewById(R.id.boton);
        btnBoton1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                lblEtiqueta.setText("¡Boton 1 Pulsado");
            }
        });

        //Evento ToggleButton
        final ToggleButton btnBoton2 = (ToggleButton)findViewById(R.id.toggleButton);
        btnBoton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(btnBoton2.isChecked())
                    lblEtiqueta.setText("Encendido");
                else
                    lblEtiqueta.setText("Apagado");
            }
        });

        //Acceso CheckBox
        final CheckBox cb1 = (CheckBox) findViewById(R.id.check1);
        final CheckBox cb2 = (CheckBox) findViewById(R.id.check2);
        final Button botonCB = (Button) findViewById(R.id.botonCB);

        //Evento del CheckBox
        CompoundButton.OnCheckedChangeListener CBChangeListener = new CheckBox.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if(isChecked)
                    lblEtiqueta.setText("CheckBox" + button.getText() + "Marcado !!!!!!!");
                else
                    lblEtiqueta.setText("CheckBox " + button.getText() + "Desmarcado !!!!!!");

            }
        };

        //Asociamos el evento a ambos check
        cb1.setOnCheckedChangeListener(CBChangeListener);
        cb2.setOnCheckedChangeListener(CBChangeListener);

        //Evento del boton "Confirmar"
        botonCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() && cb2.isChecked())
                    lblEtiqueta.setText("Usas Android e IOS");
                else if(cb1.isChecked())
                    lblEtiqueta.setText("Usas Android");
                else if(cb2.isChecked())
                    lblEtiqueta.setText("Usas IOS");
                else
                    lblEtiqueta.setText("No has marcado el móvil que usas");
            }
        });

        //Eventos de RadioButtons
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Obtenemos el radioButton seleccionado
                final RadioButton rb = (RadioButton) findViewById(checkedId);
                lblEtiqueta.setText("Radio seleccionado " + rb.getText());
            }
        });




    }
}