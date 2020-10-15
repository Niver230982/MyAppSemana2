package com.niverarrigonni.myappsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSig;
    EditText txNombreCompleto;
    EditText txTelefono;
    TextView tvFecha;
    EditText txEmail;
    EditText txDescripcion;


    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSig = (Button)findViewById(R.id.btn_next);

        txNombreCompleto = (EditText)findViewById(R.id.txNombre);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        txTelefono = (EditText)findViewById(R.id.txTelefono);
        txEmail = (EditText)findViewById(R.id.txEmail);
        txDescripcion = (EditText)findViewById(R.id.txDescripcion);

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("InfoNombre", txNombreCompleto.getText().toString());
                intent.putExtra("InfoFecha",tvFecha.getText().toString());
                intent.putExtra("InfoTelefono",txTelefono.getText().toString());
                intent.putExtra("InfoEmail",txEmail.getText().toString());
                intent.putExtra("InfoDescripcion",txDescripcion.getText().toString());
                startActivity(intent);
            }
        });

        mDisplayDate = (TextView) findViewById(R.id.tvFecha);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

}