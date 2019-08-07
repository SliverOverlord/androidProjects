package edu.mnstate.rest;

import edu.mnstate.model.Film;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private FilmService filmService;

    public ApiService() {
        filmService = retrofit.create(FilmService.class);
    }
    public void getFilm(Callback<Film> callback, String filmId){
        filmService.getFilm(filmId).enqueue(callback);
    }

}
