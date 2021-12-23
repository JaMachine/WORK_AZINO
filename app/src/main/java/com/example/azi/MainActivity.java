package com.example.azi;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView i1a;
    ImageView i2a;
    ImageView i3a;
    ImageView i4a;
    ImageView i5a;
    ImageView i1b;
    ImageView i2b;
    ImageView i3b;
    ImageView i4b;
    ImageView i5b;
    ImageView i1c;
    ImageView i2c;
    ImageView i3c;
    ImageView i4c;
    ImageView i5c;
    ImageView spinger;
    int[] imageNumber = {0, 0, 0, 0, 0};
    int chickenRoll = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchResources();
        startFunctions();
        loadPictures();
    }

    void fetchResources() {
        i1a = findViewById(R.id.i1a);
        i2a = findViewById(R.id.i2a);
        i3a = findViewById(R.id.i3a);
        i4a = findViewById(R.id.i4a);
        i5a = findViewById(R.id.i5a);
        i1b = findViewById(R.id.i1b);
        i2b = findViewById(R.id.i2b);
        i3b = findViewById(R.id.i3b);
        i4b = findViewById(R.id.i4b);
        i5b = findViewById(R.id.i5b);
        i1c = findViewById(R.id.i1c);
        i2c = findViewById(R.id.i2c);
        i3c = findViewById(R.id.i3c);
        i4c = findViewById(R.id.i4c);
        i5c = findViewById(R.id.i5c);
        spinger = findViewById(R.id.spinger);
    }

    void startFunctions() {
        spinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chickenRoll = new Random().nextInt(20) + 1;
                for (int i = imageNumber.length - 1; i >= 0; i--) {
                    imageNumber[i] = new Random().nextInt(11) + 1;
                }
                loadPictures();
            }
        });
        for (int i = 4; i >= 0; i--) {
            int randomNumber = 1 + new Random().nextInt(11);
            imageNumber[i] = randomNumber;
        }
    }

    void loadPictures() {
        ImageView[] listOfImagesTop = {i1a, i2a, i3a, i4a, i5a};
        ImageView[] listOfImagesCenter = {i1b, i2b, i3b, i4b, i5b};
        ImageView[] listOfImagesBottom = {i1c, i2c, i3c, i4c, i5c};
        for (int i = 4; i >= 0; i--) {
            switch (imageNumber[i]) {
                case 1:
                    listOfImagesTop[i].setImageResource(R.drawable.s_1);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_2);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_3);
                    break;
                case 2:
                    listOfImagesTop[i].setImageResource(R.drawable.s_2);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_3);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_4);
                    break;
                case 3:
                    listOfImagesTop[i].setImageResource(R.drawable.s_3);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_4);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_5);
                    break;
                case 4:
                    listOfImagesTop[i].setImageResource(R.drawable.s_4);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_5);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_6);
                    break;
                case 5:
                    listOfImagesTop[i].setImageResource(R.drawable.s_5);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_6);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_7);
                    break;
                case 6:
                    listOfImagesTop[i].setImageResource(R.drawable.s_6);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_7);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_8);
                    break;
                case 7:
                    listOfImagesTop[i].setImageResource(R.drawable.s_7);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_8);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_9);
                    break;
                case 8:
                    listOfImagesTop[i].setImageResource(R.drawable.s_8);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_9);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_10);
                    break;
                case 9:
                    listOfImagesTop[i].setImageResource(R.drawable.s_9);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_10);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_11);
                    break;
                case 10:
                    listOfImagesTop[i].setImageResource(R.drawable.s_10);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_11);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_1);
                    break;
                case 11:
                    listOfImagesTop[i].setImageResource(R.drawable.s_11);
                    listOfImagesCenter[i].setImageResource(R.drawable.s_1);
                    listOfImagesBottom[i].setImageResource(R.drawable.s_2);
                    break;
            }

            int finalI = i;
            YoYo.with(Techniques.SlideInDown)
                    .duration(160)
                    .repeat(0)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            for (int i = imageNumber.length - 1; i >= 0; i--) {
                                imageNumber[i] += 1;
                                {
                                    if (imageNumber[i] > 11) imageNumber[i] = 1;
                                }
                            }
                            if (chickenRoll > 0) {
                                chickenRoll--;
                                loadPictures();
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    })
                    .playOn(listOfImagesTop[i]);
            YoYo.with(Techniques.SlideInDown)
                    .duration(150)
                    .repeat(0)
                    .playOn(listOfImagesCenter[i]);
            YoYo.with(Techniques.SlideInDown)
                    .duration(150)
                    .repeat(0)
                    .playOn(listOfImagesBottom[i]);
        }


    }
}


