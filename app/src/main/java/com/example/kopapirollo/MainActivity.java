package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
    private TextView eredmenyText, dontetlenText;
    private static Random rnd = new Random();
    private String jatekos;
    private int pontComputer, pontJatekos, pontDontetlen;

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
                jatek(generateComputerTipp(), jatekos);
            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosTipp.setImageResource(R.drawable.paper);
                jatekos = "papir";
                jatek(generateComputerTipp(), jatekos);
            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekosTipp.setImageResource(R.drawable.scissors);
                jatekos = "ollo";
                jatek(generateComputerTipp(), jatekos);
            }
        });
    }

    public void init() {
        jatekosTipp = findViewById(R.id.jatekosTipp);
        computerTipp = findViewById(R.id.computerTipp);
        koBtn = findViewById(R.id.koBtn);
        papirBtn = findViewById(R.id.papirBtn);
        olloBtn = findViewById(R.id.olloBtn);
        eredmenyText = findViewById(R.id.eredmenyText);
        dontetlenText = findViewById(R.id.dontetlenText);
    }

    public String generateComputerTipp() {
        int random = rnd.nextInt(4 - 1) + 1;
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
            Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
            pontDontetlen++;
        } else if (computer.equals("ko") && jatekos.equals("papir")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
            pontJatekos++;
        } else if (computer.equals("papir") && jatekos.equals("ollo")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
            pontJatekos++;
        } else if (computer.equals("ollo") && jatekos.equals("ko")) {
            Toast.makeText(MainActivity.this, "Győzelem", Toast.LENGTH_SHORT).show();
            pontJatekos++;
        } else {
            pontComputer++;
        }
        kiir();
        if (pontJatekos == 3 || pontComputer == 3) {
            jatekVege();
        }
    }

    public void jatekVege() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(false);
        if (pontJatekos == 3) {
            alertBuilder.setTitle("Győzelem");
        } else if (pontComputer == 3) {
            alertBuilder.setTitle("Vereség");
        }

        alertBuilder.setMessage("Szeretnél új játékot játszani?");
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ujJatek();
            }
        });

        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertBuilder.create().show();
    }

    public void kiir() {
        eredmenyText.setText("Eredmény: Ember: " + pontJatekos + " Computer: " + pontComputer);
        dontetlenText.setText("Döntetlenek száma: " + pontDontetlen);
    }

    public void ujJatek() {
        pontDontetlen = 0;
        pontJatekos = 0;
        pontComputer = 0;
        jatekos = "";
        eredmenyText.setText("Eredmény: Ember: 0 Computer: 0");
        dontetlenText.setText("Döntetlenek száma: 0");
    }
}
