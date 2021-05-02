package com.example.menuwidget2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.usuario:
                    Intent intent = new Intent(MainActivity.this, dos.class);
                    startActivity(intent);
                return true;

                case R.id.compartir:
                    ApplicationInfo api = getApplicationContext().getApplicationInfo();
                    String shareBody = "Comparto a todo el mundo que mi menu compartir funciona";
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Saludos desde mi app");

                    i.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

                    startActivity(Intent.createChooser(i, "compartir con"));
                    return  true;

                default:
                    return super.onOptionsItemSelected(item);
            }


    }
}