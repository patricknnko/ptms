package com.example.ptms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //variable for loading the next activity
    private static int SPLASH_SCREEN =5000;
    //variables for annimations
    Animation topAnim,buttomAnim;
    ImageView image;
    TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        buttomAnim=AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

        //hooks
        image=findViewById(R.id.imageView);
        slogan=findViewById(R.id.textView);

        image.setAnimation(topAnim);
        slogan.setAnimation(buttomAnim);

        //to call our next activity using delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
