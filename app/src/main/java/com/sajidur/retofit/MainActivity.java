package com.sajidur.retofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitClient retrofitClient=new RetrofitClient();
        Retrofit retrofit=retrofitClient.getClient();

        MyAPI myAPI=retrofit.create(MyAPI.class);

        Call<List<Post>> listCall=myAPI.getPost(3);

        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                    return;
                }else {
                    List<Post> posts=response.body();
                    System.out.println(posts.size()+"-"+posts.get(0).getText());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });


        Post post  =new Post(1,"Test Title","Test Body");
        Call<Post> postCall=myAPI.createPost(post);

        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                System.out.println(response.body().getText());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}