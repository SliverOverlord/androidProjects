package com.example.turtle.myriadmobilechallenge.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turtle.myriadmobilechallenge.R;
import com.example.turtle.myriadmobilechallenge.model.Event;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder>{

    private ArrayList<Event> eventList;
    private Context context;

    public ImageView eventImage;
    public TextView eventTitle;
    public TextView eventDate;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //public ImageView eventImage;
       // public TextView eventTitle;
        //public TextView eventDate;

        public MyViewHolder(View view) {
            super(view);
            eventImage = (ImageView) view.findViewById(R.id.eventImage);
            eventTitle = (TextView) view.findViewById(R.id.eventTitle);
            eventDate = (TextView) view.findViewById(R.id.eventDateView);
        }
    }

    public EventAdapter(Context context, ArrayList<Event> eventList){

        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.event_list_row, parent,false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        try{
            Event event = eventList.get(position);

            DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yy hh a");
            DateFormat dateFormat2 = new SimpleDateFormat(" hh:mm a");

            String tmpStr1 = dateFormat1.format(event.getStartDateTime());
            String tmpStr2 = dateFormat2.format(event.getEndDateTime());


            //Picasso.get().load(eventList.get(position).getImageUrl()).into(holder.eventImage);
            //holder.eventTitle.setText(event.getTitle());
            //holder.eventDate.setText(event.getDateStr());


            Picasso.get().load(eventList.get(position).getImageUrl()).resize(100, 100)
                    .centerCrop().into(eventImage);
            eventTitle.setText(event.getTitle());
            eventDate.setText(tmpStr1+" -"+tmpStr2);


            //eventDate.setText(event.getDateStr());


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount(){

        return eventList.size();
    }

}
