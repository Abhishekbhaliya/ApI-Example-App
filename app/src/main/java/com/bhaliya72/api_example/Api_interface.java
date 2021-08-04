package com.bhaliya72.api_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_interface {

    @GET("photos")
    Call<List<post_pojo>> getpost();
}
