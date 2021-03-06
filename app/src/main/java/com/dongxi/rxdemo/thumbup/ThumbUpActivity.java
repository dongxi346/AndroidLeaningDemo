package com.dongxi.rxdemo.thumbup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.dongxi.rxdemo.R;

import java.util.ArrayList;

public class ThumbUpActivity extends AppCompatActivity {

    private static final String TAG = "ThumbUpActivity";


    private ArrayList<ThumbUp> mThumbUpList = new ArrayList<>() ;
    private ThumbUpAdapter mThumbUpAdapter;
    private Button mSingleSelect;
    private Button mAllSelect;
    private Button mRevertSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumb_up);


        ListView listView = (ListView) findViewById(R.id.listView);
        mSingleSelect = (Button) findViewById(R.id.single_select);
        mAllSelect = (Button) findViewById(R.id.all_select);
        mRevertSelect = (Button) findViewById(R.id.revert_select);


        mThumbUpAdapter = new ThumbUpAdapter(this ,initData());
        listView.setAdapter(mThumbUpAdapter);

        mThumbUpAdapter.setThumbUpListener(new ThumbUpAdapter.OnThumbUpClickListener() {
            @Override
            public void onItemClick(int position) {
                ThumbUp thumbUp = mThumbUpAdapter.getItem(position);
                thumbUp.setThumbUpCount(thumbUp.getThumbUpCount()+1);
                thumbUp.setSelect(true);
                mThumbUpAdapter.notifyDataSetChanged();
            }
        });
        mSingleSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mThumbUpAdapter.singleSelect();
            }
        });
        mAllSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mThumbUpAdapter.allSelect();
            }
        });
        mRevertSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mThumbUpAdapter.revertSelect();
            }
        });
    }

    public ArrayList<ThumbUp> initData(){
        for (int i = 0; i < 100; i++){
            ThumbUp thumbUp = new ThumbUp();
            thumbUp.setThumbUpCount(i);
            mThumbUpList.add(thumbUp) ;
        }

        return mThumbUpList ;
    }

}
