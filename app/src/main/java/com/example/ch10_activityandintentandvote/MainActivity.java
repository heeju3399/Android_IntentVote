package com.example.ch10_activityandintentandvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Vote");
        final  int voteCount[] = new int[9];

        for(int i =0; i<+9; i++){
            voteCount[i] =0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {
                R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9    };
        final String imgName[] = {
                "독서하는소뇨","꽃장식모자소녀","부채를든 소녀","이레느깡단베르앙",
                "감자소년","테라스의두자매","피아노레슨","피아노앞의소녀드","해변에서"
        };
         for(int i = 0; i<imageId.length; i++){
             final int index = i;
             image[index] = findViewById(imageId[index]);

             image[index].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     voteCount[index]++;
                     Toast.makeText(getApplicationContext(), imgName[index]+":총"
                     + voteCount[index]+"표", Toast.LENGTH_SHORT).show();
                 }
             });
         }

         Button btnFinish = findViewById(R.id.btnResult1);
         btnFinish.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), subActivity.class);
                 intent.putExtra("voteCount",voteCount);
                 intent.putExtra("ImageName",imgName);
                 startActivity(intent);
             }
         });


    }
}