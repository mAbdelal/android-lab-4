package com.example.lab_4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn=(Button) findViewById(R.id.button1);
        Button order_btn=(Button) findViewById(R.id.button2);
        Button dessets_btn=(Button) findViewById(R.id.desserts);
        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFoodOrder("order food activity");
            }
        });
        dessets_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDesserts("desserts activity");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShowAlert(view);
            }
        });
    }

    public void onClickShowAlert(View view) {
         AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
         myAlertBuilder.setTitle("Alert");
         // Set the dialog message.
         myAlertBuilder.setMessage("Click OK to continue, or Cancel to stop:");
         // Add the buttons.
         myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                 // User clicked OK button.
                 Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
             }
	    });
         myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                 // User cancelled the dialog.
                 Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
             }
         });
        myAlertBuilder.show();

    }
    public void showFoodOrder(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
    public void showDesserts(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Desserts.class);
        startActivity(intent);
    }

}