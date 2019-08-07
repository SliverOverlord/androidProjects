package edu.mnstate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.mnstate.rm8834yy.lab16webdata.R;
import edu.mnstate.rest.ApiService;
import edu.mnstate.model.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView filmInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ApiService apiService;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmInfo = (TextView) findViewById(R.id.film_info);

        apiService = new ApiService();
        apiService.getFilm(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film film = response.body();
                if(film != null){
                    filmInfo.setText(film.getTitle()+ "\n" + film.getDirector()
                    + "\n" + film.getDescription());
                }

            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                filmInfo.setText("A problem happened! :( \n" + t.getMessage());

            }
        }, "2baf70d1-42bb-4437-b551-e5fed5a87abe");
    }
}
