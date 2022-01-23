package com.fkomuniku.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        setListener();
    }

    public void findViewById(){
        btn_scanner = findViewById(R.id.btn_scan);
    }

    public void setListener(){
        btn_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Scanner.class);
                startActivity(intent);
            }
        });
    }

    boolean doubleBackToExit = false;
    @Override
    public void onBackPressed() {
        if(doubleBackToExit){
            finishAffinity();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }

        this.doubleBackToExit = true;
        Toast.makeText(this, "Click again to exit!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 1500);
        return;
    }
}
