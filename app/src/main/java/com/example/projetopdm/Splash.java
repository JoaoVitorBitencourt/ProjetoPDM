package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private ImageView imgSplash;
    private Animation animacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        imgSplash = findViewById(R.id.imgSplash);

        animacao = AnimationUtils.loadAnimation(Splash.this, R.anim.splash);
        animacao.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash.this, Login.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgSplash.startAnimation(animacao);

    }
}
