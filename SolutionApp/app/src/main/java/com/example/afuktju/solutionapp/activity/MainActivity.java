package com.example.afuktju.solutionapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.afuktju.solutionapp.R;
import com.example.afuktju.solutionapp.greendao.model.DtbPost;
import com.example.afuktju.solutionapp.utils.UtilDatas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends CoreServiceActivity {

    private Button btnShowTiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initServiceWithDialog();
        btnShowTiles = (Button) findViewById(R.id.btnShowTiles);
        btnShowTiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goPostList = new Intent(MainActivity.this, PostListActivity.class);
                startActivity(goPostList);
            }
        });
        getPost();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilDatas.truncateDB(getApplicationContext());
    }

    public void getPost() {
        alertDialog.show();
        Call<List<DtbPost>> request = apiInterface.getPost();
        request.enqueue(new Callback<List<DtbPost>>() {
            @Override
            public void onResponse(Call<List<DtbPost>> call, Response<List<DtbPost>> response) {
                alertDialog.dismiss();
                UtilDatas.insertOrReplaceDtbPost(getApplicationContext(), response.body());
                Toast.makeText(MainActivity.this, "request success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<DtbPost>> call, Throwable t) {
                alertDialog.dismiss();
                Toast.makeText(MainActivity.this, "request failed...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
