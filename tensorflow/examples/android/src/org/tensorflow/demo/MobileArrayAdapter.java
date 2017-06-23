package org.tensorflow.demo;

/**
 * Created by Namrata on 20/06/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MobileArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_items_list, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;

        if (position == 0) {
            rowView = inflater.inflate(R.layout.list_header, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.textSeparator);
            textView.setText(values[position]);

        }
        else {

            rowView = inflater.inflate(R.layout.activity_items_list, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.bottle);
            textView.setText(values[position]);

            // Change icon based on name
            String s = values[position];

            System.out.println(s);

            if (s.equals("Bottle")) {
                imageView.setImageResource(R.drawable.bottle);
            } else if (s.equals("Cup")) {
                imageView.setImageResource(R.drawable.cup);
            } else if (s.equals("Tile")) {
                imageView.setImageResource(R.drawable.tile);
            } else if (s.equals("Shoe")) {
                imageView.setImageResource(R.drawable.shoe);
            } else if (s.equals("Bag")) {
                imageView.setImageResource(R.drawable.bag);
            } else {
                imageView.setImageResource(R.drawable.customize);
            }
        }

        return rowView;
    }
}