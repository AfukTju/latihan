package com.example.afuktju.solutionapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.afuktju.solutionapp.R;
import com.example.afuktju.solutionapp.adapter.PostListAdapter;
import com.example.afuktju.solutionapp.greendao.model.DtbPost;
import com.example.afuktju.solutionapp.utils.UtilDatas;

import java.util.List;

/**
 * Created by AfukTju on 12/11/2016.
 */

public class PostListActivity extends AppCompatActivity {

    private RecyclerView rvPostList;

    private LinearLayout llActionBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        rvPostList = (RecyclerView) findViewById(R.id.rvPostList);
        rvPostList.setLayoutManager(new LinearLayoutManager(this));
        setAdapterPosts(UtilDatas.getPosts(getApplicationContext()));

        llActionBack = (LinearLayout) findViewById(R.id.llActionBack);
        llActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setAdapterPosts(List<DtbPost> postList) {
        rvPostList.setAdapter(new PostListAdapter(postList));
    }
}
