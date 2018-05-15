package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ChessPieceListener{

    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);

        //the phone is in portrait mode
        if(findViewById(R.id.layout_default) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        if(findViewById(R.id.layout_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onChessPieceSelected(int index) {

        if (findViewById(R.id.layout_default) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();

        }

        //String [] descriptions = getResources().getStringArray(R.array.description);
        //tvDetails.setText(descriptions[index]);// Q: Why use two lines and a new variable instead of one line command?
        tvDetails.setText(getResources().getStringArray(R.array.description)[index]);

    }
}
