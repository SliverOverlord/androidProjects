package edu.mnstate.rm8834yy.denioa4recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Puppies> puppyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PuppiesAdapter pAdapter;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        pAdapter = new PuppiesAdapter(puppyList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        recyclerView.addOnItemTouchListener(
                new PClickListener(this, recyclerView ,new PClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(),"Correct input needed",Toast.LENGTH_SHORT);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                })
        );

        preparedPuppyData();

        /*
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedItem = name[+position];
                Toast.makeText(getApplicationContext(),
                        "You picked "+ selectedItem,
                        Toast.LENGTH_SHORT).show();

            }
        });
        */
    }


    public void onClick(final View view) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);
        //String item = mList.get(itemPosition);
        //Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
    }

    private void preparedPuppyData(){
        Puppies puppy = new Puppies("Pug","Small","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Wolf","Large","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Malamute","Large","Long haired");
        puppyList.add(puppy);


        puppy = new Puppies("Australian Shepherd","Large","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("American Water Spaniel","Small","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Collie","Medium","long haired");
        puppyList.add(puppy);

        puppy = new Puppies("Cocker Spaniel","Small","Long haired");
        puppyList.add(puppy);

        puppy = new Puppies("Dachshund","Small","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Doberman","Large","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("German Shepherd","Large","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Golden Retriever","Large","Long haired");
        puppyList.add(puppy);

        puppy = new Puppies("Maltese Shih Tzu","Small","Short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Papillon","Small","Long haired");
        puppyList.add(puppy);

        puppy = new Puppies("Welsh Corgi","Small","Long haired");
        puppyList.add(puppy);

        puppy = new Puppies("Chihuahua","Small","short haired");
        puppyList.add(puppy);

        puppy = new Puppies("Pomeranian","Small","Long haired");
        puppyList.add(puppy);

        pAdapter.notifyDataSetChanged();
    }
}
