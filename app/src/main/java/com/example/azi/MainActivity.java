package com.example.azi;

import android.animation.Animator;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int[] imageNumber = {0, 0, 0, 0, 0};


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchResources();
        startFunctions();
        loadPictures();
        networking();
        loading();
    }

    private void loading() {
        if (interval != null) {
            interval.cancel();
        }
        interval = new Timer();
        terminateNetwork = new TerminateNetwork();
        interval.schedule(terminateNetwork, 5000);


    }

    void startFunctions() {
        spinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (springRoll == false) {
                    currencyProcessing();
                    chickenRoll = new Random().nextInt(20) + 1;
                    for (int i = imageNumber.length - 1; i >= 0; i--) {
                        imageNumber[i] = new Random().nextInt(11) + 1;
                    }
                    loadPictures();
                }
            }
        });
        for (int i = 4; i >= 0; i--) {
            int randomNumber = 1 + new Random().nextInt(11);
            imageNumber[i] = randomNumber;
        }

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pay < 1000) {
                    pay = pay * 2;
                    if (pay == 400) {
                        pay = 500;
                    }
                    payment.setText("" + pay);
                }
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pay > 25) {
                    pay = pay / 2;
                    if (pay == 250) {
                        pay = 200;
                    }
                    payment.setText("" + pay);
                }
            }
        });

        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay = 1000;
                payment.setText("" + pay);
            }
        });

        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;
                network.setVisibility(View.VISIBLE);
            }
        });
    }

    void currencyProcessing() {
        cur = cur - pay;
        if (cur < 100) {
            Toast.makeText(this, "!!! BONUS 1500 !!!", Toast.LENGTH_SHORT).show();
            cur = cur + 1500;
        }
        currency.setText("" + cur);
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
                    .duration(190)
                    .repeat(0)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            springRoll = true;
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
                            } else {
                                springRoll = false;
                                if (imageNumber[0] == imageNumber[1] && imageNumber[1] == imageNumber[2]) {
                                    priz1 = true;
                                    prz.setImageResource(R.drawable.w_grand_win);
                                    prz.setVisibility(View.VISIBLE);
                                }
                                if (imageNumber[1] == imageNumber[2] && imageNumber[2] == imageNumber[3]) {
                                    priz2 = true;
                                    prz.setImageResource(R.drawable.w_grand_win);
                                    prz.setVisibility(View.VISIBLE);
                                }
                                if (imageNumber[2] == imageNumber[3] && imageNumber[3] == imageNumber[4]) {
                                    priz3 = true;
                                    prz.setImageResource(R.drawable.w_grand_win);
                                    prz.setVisibility(View.VISIBLE);
                                }
                                if (priz1 == priz2 || priz2 == priz3) {
                                    prz.setImageResource(R.drawable.w_total_win);
                                }

                                if (priz1 == priz2 && priz2 == priz3) {
                                    prz.setImageResource(R.drawable.w_legendary_win);
                                }




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
                    .duration(190)
                    .repeat(0)
                    .playOn(listOfImagesCenter[i]);
            YoYo.with(Techniques.SlideInDown)
                    .duration(190)
                    .repeat(0)
                    .playOn(listOfImagesBottom[i]);
        }


    }

    void networking() {
        network.setWebViewClient(new WebViewClient());
        WebSettings settings = network.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        network.loadUrl(connector);
    }

    void fetchResources() {
        max = findViewById(R.id.max);
        i1a = findViewById(R.id.i1a);
        i2a = findViewById(R.id.i2a);
        i3a = findViewById(R.id.i3a);
        i4a = findViewById(R.id.i4a);
        network = findViewById(R.id.network);
        i5a = findViewById(R.id.i5a);
        i1b = findViewById(R.id.i1b);
        i2b = findViewById(R.id.i2b);
        inf = findViewById(R.id.inf);
        i3b = findViewById(R.id.i3b);
        i4b = findViewById(R.id.i4b);
        i5b = findViewById(R.id.i5b);
        i1c = findViewById(R.id.i1c);
        loading = findViewById(R.id.loading);
        i2c = findViewById(R.id.i2c);
        i3c = findViewById(R.id.i3c);
        i4c = findViewById(R.id.i4c);
        i5c = findViewById(R.id.i5c);
        spinger = findViewById(R.id.spinger);
        dec = findViewById(R.id.dec);
        prz = findViewById(R.id.prz);
        inc = findViewById(R.id.inc);
        payment = findViewById(R.id.payment);
        currency = findViewById(R.id.currency);
        turbo_spinger = findViewById(R.id.turbo_spinger);
        con = this;
        connector = "https://panthesivi.ru/Yb4zJcy3";
    }


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
    ImageView prz;
    int chickenRoll = 0;
    int cur = 10000;
    int pay = 25;
    boolean springRoll;
    boolean game;
    TextView payment;
    TextView currency;
    ImageView dec;
    ImageView inc;
    ImageView max;
    ImageView loading;
    ImageView turbo_spinger;
    ImageView inf;
    Context con;
    WebView network;
    String connector;
    Timer interval;
    boolean priz1;
    boolean priz2;
    boolean priz3;
    TerminateNetwork terminateNetwork;

    class TerminateNetwork extends TimerTask {

        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
            final String strDate = simpleDateFormat.format(calendar.getTime());

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    if (network.getUrl().equals(network.getOriginalUrl())) {
                        network.setVisibility(View.GONE);
                        connector = "https://sites.google.com/view/1231-privacy-policy-y";
                        network.loadUrl(connector);
                        game = true;
                    } else {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
                    }
                    loading.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if (game) {
            network.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}


