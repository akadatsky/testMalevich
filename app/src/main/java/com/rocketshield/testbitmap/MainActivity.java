package com.rocketshield.testbitmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String img1 = "https://scontent.xx.fbcdn.net/v/t1.0-1/c59.0.200.200/p200x200/10354686_10150004552801856_220367501106153455_n.jpg?oh=375deaca2474f9fe948e7bfe9c313bc2&oe=590D5D25";
    public static String img2 = "https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-1/c20.2.48.48/p80x80/16298911_1566013176761489_8003448915909177744_n.jpg?oh=e62eba5315cc20dd91d9903447c2002f&oe=593BD47A";

    private MyAdapter mAdapter;
    private List<String> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        mAdapter = new MyAdapter(this);
        listView.setAdapter(mAdapter);

        mItems = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mItems.add(img1);
            mItems.add(img1);
            mItems.add(img2);
        }

    }

    public void btnGoClick(View view) {
        mAdapter.clear();
        mAdapter.addAll(mItems);

    }
}
