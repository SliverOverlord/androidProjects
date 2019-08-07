package edu.mnstate.rest;
import edu.mnstate.model.Film;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmService {
    @GET("films/{filmID}/")
    Call<Film> getFilm(@Path("filmId") String filmId);
}
