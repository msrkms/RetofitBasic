package com.sajidur.retofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyAPI {

    @GET("posts")
    Call<List<Post>> getPost(@Query("userId")int userId);

    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int id);

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
