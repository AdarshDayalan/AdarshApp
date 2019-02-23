package com.adarsh.adarshtracker;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity
{

    private DatabaseReference ref;
    private FirebaseDatabase db;

    private int letter = 65;
    private String currentLetter = "A";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("letter").push();
        ref.setValue("fe");

    }

    public void promote(View v)
    {
        if (letter > 65)
        {
            letter--;
        }
        else
        {
            Toast.makeText(this, "This is not allowed", Toast.LENGTH_SHORT).show();
        }
        updateLetter();
    }

    public void demote(View v)
    {
        if (letter < 90)
        {
            letter++;
        }
        else
        {
            Toast.makeText(this, "Amaan", Toast.LENGTH_SHORT).show();
        }
        updateLetter();
    }

    public void updateLetter()
    {
        currentLetter = Character.toString((char) letter);
        Log.i("TEST", "Current Letter " + currentLetter);
        TextView number = findViewById(R.id.level);
        number.setText(currentLetter + "darsh");
    }

}
