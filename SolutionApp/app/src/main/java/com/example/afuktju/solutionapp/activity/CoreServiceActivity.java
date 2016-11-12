package com.example.afuktju.solutionapp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.afuktju.solutionapp.R;
import com.example.afuktju.solutionapp.rest.ApiConstant;
import com.example.afuktju.solutionapp.rest.ApiInterface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AfukTju on 12/11/2016.
 */

public class CoreServiceActivity extends AppCompatActivity {
    public Retrofit retrofit;
    public ApiInterface apiInterface;
    public OkHttpClient httpClient;
    public ProgressDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initServiceWithDialog() {
        initService();
        initDialog();
    }


    public void initService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();


        apiInterface = retrofit.create(ApiInterface.class);
    }

    public void initDialog() {
        alertDialog = new ProgressDialog(this);
        alertDialog.setMessage(getResources().getString(R.string.label_loading));
        alertDialog.setCancelable(false);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(alertDialog!=null&&alertDialog.isShowing())
            alertDialog.dismiss();
    }
}
