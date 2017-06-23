package org.tensorflow.demo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;


public class Splash extends Activity  implements Animation.AnimationListener {

    protected Animation fadeIn;
    protected ImageView img1;
    protected ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        img1 = (ImageView) findViewById(R.id.imageView);
        img1.setVisibility(View.VISIBLE);
        img1.startAnimation(fadeIn);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep (8000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Splash.this,ItemsList.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onAnimationStart(Animation animation) {


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getBaseContext(), "Animation Stopped!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
