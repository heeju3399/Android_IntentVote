package com.example.ch10_activityandintentandvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setTitle("Result");
        Intent intent = getIntent();
        int [] voteResult = intent.getIntArrayExtra("voteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");



        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvId[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,
                R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarId[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,
                R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};



        for(int i = 0; i<voteResult.length;i++){
            tv[i] = findViewById(tvId[i]);
            rbar[i] = findViewById(rbarId[i]);
        }
        for(int i =0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            tv[i].setTextSize(10);
            rbar[i].setRating((float)voteResult[i]);


        }

        //가장많은 좋아요받은 이미지 출력
        ImageView img = findViewById(R.id.imageView);
        int max = 0;
        int indexk = 0;
        for (int i=0; i<voteResult.length; i++){

            if (max < voteResult[i]) {
                max = voteResult[i];
                indexk = i;
            }
        }


        for(int i =0; i<10; i++){

            for(int j =0; j<10; j++){
                String aa = "R.drawable.pic1";
            }

        }
        img.setImageResource(R.drawable.pic1);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}