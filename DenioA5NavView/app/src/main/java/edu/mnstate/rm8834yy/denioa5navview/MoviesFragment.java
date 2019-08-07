package edu.mnstate.rm8834yy.denioa5navview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    public ListView movieListV;

    Integer[] imageIDs = {
            R.drawable.antman,
            R.drawable.beauty,
            R.drawable.blackpanther,
            R.drawable.bladerunner,
            R.drawable.gotg,
            R.drawable.starwars,
            R.drawable.xmen,
            R.drawable.boats,
            R.drawable.canada
    };

    String [ ] movieTitles = {
            "AntMan",
            "Beauty And The Beast",
            "Black Panther",
            "Bladerunner",
            "Guardians Of The Galaxy",
            "StarWars",
            "X-Men"
    };

    String [ ] itemDesc = {
            "Antman steals a shrinking suit from a scientist and \n"
            +"ends up using the suit to become a super hero in spite of his \n"
            +"criminal past.",
            "A girl falls in love with a monster and brings out his good side.",
            "A superhero from an isolated supernation copes with the death of his \n"
            +"father and taking up the mantle as his nations next protector.",
            "A futuristic world where androids are sent to hunt down escaped company assets.",
            "An awesome comedy about a group of misfits teaming up to save the galaxy.",
            "An expansion on the starwars universe.",
            "The x-men team up to stop the first mutant from taking over the world"
    };


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        movieListV = (ListView) view.findViewById(R.id.movieListV);

        CustomListAdapter adapter = new CustomListAdapter(view.getContext(),
                movieTitles, imageIDs, itemDesc);
        movieListV.setAdapter(adapter);

        movieListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedItem = movieTitles[+position];
                Toast.makeText(view.getContext(),
                        "You picked "+ selectedItem,
                        Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}
