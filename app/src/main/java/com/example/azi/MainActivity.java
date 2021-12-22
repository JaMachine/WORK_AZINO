package com.example.azi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;
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

            }
        });
    }

    void loadPictures() {
        ImageView[] listOfImages = {i1a, i2a, i3a, i4a, i5a, i1b, i2b, i3b, i4b, i5b, i1c, i2c, i3c, i4c, i5c};
        for (int i = listOfImages.length-1; i > 0; i--) {
            int randomNumber = 1 + new Random().nextInt(11);
            switch (randomNumber) {
                case 1:
                    listOfImages[i].setImageResource(R.drawable.s_1);
                    break;
                case 2:
                    listOfImages[i].setImageResource(R.drawable.s_2);
                    break;
                case 3:
                    listOfImages[i].setImageResource(R.drawable.s_3);
                    break;
                case 4:
                    listOfImages[i].setImageResource(R.drawable.s_4);
                    break;
                case 5:
                    listOfImages[i].setImageResource(R.drawable.s_5);
                    break;
                case 6:
                    listOfImages[i].setImageResource(R.drawable.s_6);
                    break;
                case 7:
                    listOfImages[i].setImageResource(R.drawable.s_7);
                    break;
                case 8:
                    listOfImages[i].setImageResource(R.drawable.s_8);
                    break;
                case 9:
                    listOfImages[i].setImageResource(R.drawable.s_9);
                    break;
                case 10:
                    listOfImages[i].setImageResource(R.drawable.s_10);
                    break;
                case 11:
                    listOfImages[i].setImageResource(R.drawable.s_11);
                    break;
            }
        }
    }


}