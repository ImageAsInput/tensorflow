package org.tensorflow.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class ItemsList extends ListActivity {

    static final String[] ItemsList = new String[] {"LIST OF PRODUCTS WE DETECT", "Bottle", "Cup","Tile","Shoe","Bag","Train our model" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new MobileArrayAdapter(this, ItemsList));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        Intent intent = new Intent(ItemsList.this,DetectorActivity.class);
        startActivity(intent);

    }

}

