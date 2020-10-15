package com.niverarrigonni.myappsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);

        Bundle bundleName = getIntent().getExtras();
        Bundle bundleDate = getIntent().getExtras();
        Bundle bundlePhone = getIntent().getExtras();
        Bundle bundleEmail = getIntent().getExtras();
        Bundle bundleDescription = getIntent().getExtras();

        String datoName = bundleName.getString("InfoNombre").toString();
        String datoDate = bundleDate.getString("InfoFecha".toString());
        String datoPhone = bundlePhone.getString("InfoTelefono".toString());
        String datoEmail = bundleEmail.getString("InfoEmail".toString());
        String datoDescription = bundleDescription.getString("InfoDescripcion".toString());

        tvNombre.setText("Nombre completo:"+datoName);
        tvFecha.setText("Fecha de nacimiento:"+datoDate);
        tvTelefono.setText("Telefono:"+datoPhone);
        tvEmail.setText("E-mail:"+datoEmail);
        tvDescripcion.setText("Descripción:"+datoDescription);
    }

    public void onClick(View View){
        Intent myIntent=new Intent(Activity2.this,MainActivity.class);
        finish();
    }

}
