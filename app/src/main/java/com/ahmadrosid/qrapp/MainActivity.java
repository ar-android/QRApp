package com.ahmadrosid.qrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGenerate;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        input = (EditText) findViewById(R.id.inputCode);

        btnGenerate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGenerate:
                if (input.getText().length() > 1){
                    startActivity(new Intent(this, QRActivity.class).putExtra(Intent.EXTRA_TEXT, input.getText()));
                }else{
                    Toast.makeText(MainActivity.this, "Text is empety or leng less than one char", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
