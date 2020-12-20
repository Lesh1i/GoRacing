package com.example.goracing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGameAction(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void closeAction(View view) {

        System.exit(0);
    }

    public void changePlayerNameAction (View view) {
        final EditText input = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Setting player name");
        builder.setMessage("Enter new player name");
        builder.setView(input);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (input.getText().length() !=0) {
                    Data.playerName = input.getText().toString();
                    Toast.makeText(getApplicationContext(), "You change name to: " + Data.playerName, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Name no save, input is clear", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.show();
    }
}