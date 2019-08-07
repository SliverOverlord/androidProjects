package edu.mnstate.rm8834yy.denioa5navview;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import edu.mnstate.rm8834yy.denioa5navview.MoviesFragment;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Context context2;
    private final  String[] movieTitles;
    private final Integer[] imageIDs;
    private String[] itemDescriptions;
    

    public CustomListAdapter(Context context, String[] movieTitles, Integer[] imageIDs, String[] itemDesc) {
        super(context, R.layout.movie_element,movieTitles);
        this.context2=context;
        this.movieTitles=movieTitles;
        this.imageIDs=imageIDs;
        this.itemDescriptions=itemDesc;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.movie_element, null, true);


        TextView titleTxt = (TextView)
                rowView.findViewById(R.id.titleTxt);

        ImageView imageView = (ImageView)
                rowView.findViewById(R.id.icon);

        TextView descriptionTxt = (TextView)
                rowView.findViewById(R.id.descriptionTxt);

        titleTxt.setText(movieTitles[position]);
        imageView.setImageResource(imageIDs[position]);
        descriptionTxt.setText(itemDescriptions[position]);

        return rowView;
    };

}
