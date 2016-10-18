package com.example.chris.starsigns_withfragment;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements starSignFragment.OnFragmentInteractionListener {


    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    String starSign = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    //.add(R.id.container, new starSignFragment())
                    .commit();
        }

        // For some reason, the app crashs if this is up with the other variables
        ListView listView = (ListView)findViewById(R.id.lvStarSigns);

        // Create an adapter between the list we have in this file (that we add items too) and the listView control on the interface
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        listView.setAdapter(adapter);

        // Add the star signs
        listItems.add("Aries");
        listItems.add("Taurus");
        listItems.add("Gemini");
        listItems.add("Cancer");
        listItems.add("Leo");
        listItems.add("Virgo");
        listItems.add("Libra");
        listItems.add("Scorpio");
        listItems.add("Sagittarius");
        listItems.add("Capricorn");
        listItems.add("Aquarius");
        listItems.add("Pisces");

        // Update the listView control with the added star signs using the adapter
        adapter.notifyDataSetChanged();
    }

    public void onFragmentInteraction(Uri uri) {
        Toast toast = Toast.makeText(this, "Yo!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
