package com.example.afuktju.solutionapp.rest;

import com.example.afuktju.solutionapp.greendao.model.DtbPost;
import com.example.afuktju.solutionapp.rest.result.ResultPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AfukTju on 12/11/2016.
 */

public interface ApiInterface {
    //http://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<DtbPost>> getPost();
}
