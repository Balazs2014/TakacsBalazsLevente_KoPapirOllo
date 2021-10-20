package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView jatekosTipp, computerTipp;
    private Button koBtn, papirBtn, olloBtn;
    private TextView eredmenyText;
    private static Random rnd;
    private String jatekos;
    private int pontComputer, pontJatekos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosTipp.setImageResource(R.drawable.rock);
                jatekos = "ko";
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosTipp.setImageResource(R.drawable.paper);
                jatekos = "papir";
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosTipp.setImageResource(R.drawable.scissors);
                jatekos = "ollo";
            }
        });

        jatek(generateComputerTipp(), jatekos);
    }

    public void init() {
        jatekosTipp = findViewById(R.id.jatekosTipp);
        computerTipp = findViewById(R.id.computerTipp);
        koBtn = findViewById(R.id.koBtn);
        papirBtn = findViewById(R.id.papirBtn);
        olloBtn = findViewById(R.id.olloBtn);
    }

    public String generateComputerTipp() {
        int random = rnd.nextInt((3) + 1) + 1;
        String tipp = "";

        switch (random) {
            case 1:
                computerTipp.setImageResource(R.drawable.rock);
                tipp = "ko";
                break;
            case 2:
                computerTipp.setImageResource(R.drawable.paper);
                tipp = "papir";
                break;
            case 3:
                computerTipp.setImageResource(R.drawable.scissors);
                tipp = "ollo";
                break;
        }

        return tipp;
    }

    public void jatek(String computer, String jatekos) {
        if (computer.equals(jatekos)) {

        } else if (computer.equals("ko") && jatekos.equals("papir")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
        } else if (computer.equals("papir") && jatekos.equals("ollo")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
        } else if (computer.equals("ollo") && jatekos.equals("ko")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
        }
    }
}
