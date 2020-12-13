package com.example.ejercicio10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ImageButton btnBoton1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar con las vistas
        btnBoton1 = (ImageButton) findViewById(R.id.btnBoton1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnBoton1 : btnBoton1.setImageResource(R.drawable.ficha1);
                                    btnBoton1.setEnabled(false);
                                    break;
        }
    }
}