package com.richluick.foode.api;

import com.richluick.foode.elements.elements.joke.dto.Joke;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by rluic on 2/28/2017.
 */

public interface ElementApi {

    @Headers("Content-Type: application/json")
    @GET("food/jokes/random")
    Observable<Joke> getJokeElement();
}
