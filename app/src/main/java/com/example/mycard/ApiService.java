package com.example.mycard;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("random?n=1")
    Single<CardImage> loadCardImage();
}
