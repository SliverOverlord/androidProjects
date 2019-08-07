package com.example.turtle.denioa6;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherArrayAdapter2 extends ArrayAdapter<Weather> {
    private static class ViewHolder2 {
        ImageView conditionImageView2;
        TextView dayTextView2;
        TextView lowTextView2;
        TextView hiTextView2;
        TextView humidityTextView2;
    }

    // stores already downloaded Bitmaps for reuse
    private Map<String, Bitmap> bitmaps2 = new HashMap<>();

    // constructor to initialize superclass inherited members
    public WeatherArrayAdapter2(Context context, List<Weather> forecast) {
        super(context, -1, forecast);
    }

    // creates the custom views for the ListView's items
    @Override
    public View getView(int position, View convertView2, ViewGroup parent) {
        // get Weather object for this specified ListView position
        Weather day = getItem(position);

        WeatherArrayAdapter2.ViewHolder2 viewHolder2; // object that reference's list item's views

        // check for reusable ViewHolder from a ListView item that scrolled
        // offscreen; otherwise, create a new ViewHolder
        if (convertView2 == null) { // no reusable ViewHolder, so create one
            viewHolder2 = new WeatherArrayAdapter2.ViewHolder2();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView2 =
                    inflater.inflate(R.layout.list_item2, parent, false);
            viewHolder2.conditionImageView2 =
                    (ImageView) convertView2.findViewById(R.id.conditionImageView2);
            viewHolder2.dayTextView2 =
                    (TextView) convertView2.findViewById(R.id.dayTextView2);
            viewHolder2.lowTextView2 =
                    (TextView) convertView2.findViewById(R.id.lowTextView2);
            viewHolder2.hiTextView2 =
                    (TextView) convertView2.findViewById(R.id.hiTextView2);
            viewHolder2.humidityTextView2 =
                    (TextView) convertView2.findViewById(R.id.humidityTextView2);
            convertView2.setTag(viewHolder2);
        }
        else { // reuse existing ViewHolder stored as the list item's tag
            viewHolder2 = (WeatherArrayAdapter2.ViewHolder2) convertView2.getTag();
        }

        // if weather condition icon already downloaded, use it;
        // otherwise, download icon in a separate thread
        if (bitmaps2.containsKey(day.iconURL)) {
            viewHolder2.conditionImageView2.setImageBitmap(
                    bitmaps2.get(day.iconURL));
        }
        else {
            // download and display weather condition image
            new WeatherArrayAdapter2.LoadImageTask(viewHolder2.conditionImageView2).execute(
                    day.iconURL);
        }

        // get other data from Weather object and place into views
        Context context = getContext(); // for loading String resources
        viewHolder2.dayTextView2.setText(context.getString(
                R.string.day_description, day.dayOfWeek, day.description));
        viewHolder2.lowTextView2.setText(
                context.getString(R.string.low_temp, day.minTemp));
        viewHolder2.hiTextView2.setText(
                context.getString(R.string.high_temp, day.maxTemp));
        viewHolder2.humidityTextView2.setText(
                context.getString(R.string.humidity, day.humidity));

        return convertView2; // return completed list item to display
    }

    // AsyncTask to load weather condition icons in a separate thread
    private class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView imageView; // displays the thumbnail

        // store ImageView on which to set the downloaded Bitmap
        public LoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        // load image; params[0] is the String URL representing the image
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            HttpURLConnection connection = null;

            try {
                URL url = new URL(params[0]); // create URL for image

                // open an HttpURLConnection, get its InputStream
                // and download the image
                connection = (HttpURLConnection) url.openConnection();

                try (InputStream inputStream = connection.getInputStream()) {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmaps2.put(params[0], bitmap); // cache for later use
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                connection.disconnect(); // close the HttpURLConnection
            }

            return bitmap;
        }

        // set weather condition image in list item
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
