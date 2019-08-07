package edu.mnstate.rm8834yy.denioa4recyclerview;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import java.util.Collections;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class PuppiesAdapter extends RecyclerView.Adapter<PuppiesAdapter.MyViewHolder> {
    private List<Puppies> puppiesList;
    LinearLayout parentLayout;
    private Context pContext;


    Integer[] imageIDs = {
            R.drawable.pug,
            R.drawable.wolf,
            R.drawable.malamute,
            R.drawable.australian_shepherd,
            R.drawable.water_spaniel,
            R.drawable.collie,
            R.drawable.cocker_spaniel,
            R.drawable.dachshund,
            R.drawable.doberman,
            R.drawable.german_shepherd,
            R.drawable.golden_retriever,
            R.drawable.shihtzu,
            R.drawable.papillon,
            R.drawable.corgi,
            R.drawable.chihuahua,
            R.drawable.pomeranian

    };



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, size, hairType;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.icon);
            name = (TextView) view.findViewById(R.id.name);
            size = (TextView) view.findViewById(R.id.size);
            hairType = (TextView) view.findViewById(R.id.hairType);
            parentLayout =(LinearLayout) view.findViewById(R.id.parent_layout);

        }
    }


    public PuppiesAdapter(List<Puppies> puppiesList) {
        this.puppiesList = puppiesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.puppy_list_view, parent, false);
        //itemView.setOnClickListener(mOnClickListener);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Puppies puppy = puppiesList.get(position);
        holder.icon.setImageResource((imageIDs[position]));
        holder.name.setText(puppy.getName());
        holder.size.setText(puppy.getSize());
        holder.hairType.setText(puppy.getHairType());

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent puppyIntent = new Intent(v.getContext(), Main2Activity.class);
                    int tmpInt = holder.getAdapterPosition();
                    String pInfo = Integer.toString(tmpInt);
                    puppyIntent.putExtra("PuppyIndex", pInfo);
                    v.getContext().startActivity(puppyIntent);
                }
                catch (Exception e){
                    Toast.makeText(v.getContext(),"onclick Failed",Toast.LENGTH_SHORT);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return puppiesList.size();
    }


}
