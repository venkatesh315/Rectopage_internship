package com.example.tasksix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button db = (Button) findViewById(R.id.alertbutton);
        Button tb = (Button) findViewById(R.id.toastbutton);

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder gen = new AlertDialog.Builder(MainActivity.this);
                gen.setMessage("Confirm Booking?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No",null)
                        .setCancelable(false);
                AlertDialog alertdis = gen.create();
                alertdis.show();
            }

        });

        tb.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "Thank You for visiting", Toast.LENGTH_SHORT).show();
            }
        });
    }
}