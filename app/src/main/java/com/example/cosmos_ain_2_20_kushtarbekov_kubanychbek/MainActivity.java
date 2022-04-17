package com.example.cosmos_ain_2_20_kushtarbekov_kubanychbek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSend1;
    private Button btnSend2;
    private EditText text;
    private String textToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend1 = findViewById(R.id.btn_send1);
        btnSend2 = findViewById(R.id.btn_send2);
        text = findViewById(R.id.et);

        btnSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSend1.setVisibility(View.GONE);
                text.setVisibility(View.VISIBLE);
                btnSend2.setVisibility(View.VISIBLE);
            }
        });

        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSend = text.getText().toString();
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] {"kushtarbekovkuba2002@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Пожелания астронавту Шарипову Салижану");
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        textToSend);
                MainActivity.this.startActivity(Intent.createChooser(emailIntent,
                        "Отправка письма..."));
            }
        });
    }

}