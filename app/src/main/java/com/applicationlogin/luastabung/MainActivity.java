package com.applicationlogin.luastabung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_tinggi, edt_jarijari;
    Button hitung;
    TextView text_luas;
    final double phi = 3.14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_tinggi = (EditText) findViewById(R.id.input_tinggi);
        edt_jarijari = (EditText) findViewById(R.id.input_jarijari);
        text_luas = (TextView) findViewById(R.id.text_luas);
        hitung = (Button) findViewById(R.id.btn_permukaan);

    }

    public void hitungluas(View view) {
        try {
            validasi();
            double t = Double.parseDouble(edt_tinggi.getText().toString());
            double r = Double.parseDouble(edt_jarijari.getText().toString());
            double luas = phi * r * r + 2 * t;

            text_luas.setText(String.valueOf(luas));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validasi() {
        if (edt_tinggi.getText().toString().length() == 0) {
            edt_tinggi.setError("tinggi tidak boleh kosong!");
        } else if (edt_jarijari.getText().toString().length() == 0) {
            edt_jarijari.setError("jari-jari tidak boleh kosong!");
        } else {
            Toast.makeText(getApplicationContext(), "Tabung Dihitung!", Toast.LENGTH_SHORT).show();
        }
    }
}