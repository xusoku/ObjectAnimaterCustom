package com.davis.objectanimatercustom;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private PathEvaluator evaluator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv);


        final float startX=textView.getX();
        evaluator=new PathEvaluator();
        AnimatorPath path=new AnimatorPath();
        path.moveTo(0,0);
        path.curveTo(200,200,400,100,600,50);


        ObjectAnimator objectAnimator=ObjectAnimator.ofObject(this,"path",evaluator,path.getmPoints().toArray());
        objectAnimator.setDuration(2000);
        objectAnimator.start();

        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if(Math.abs(startX-textView.getX())>200){
                   textView.animate().scaleXBy(13f).scaleYBy(13f).setDuration(2000).setListener(new Animator.AnimatorListener() {
                       @Override
                       public void onAnimationStart(Animator animation) {

                       }

                       @Override
                       public void onAnimationEnd(Animator animation) {

                       }

                       @Override
                       public void onAnimationCancel(Animator animation) {

                       }

                       @Override
                       public void onAnimationRepeat(Animator animation) {

                       }
                   });
                }
            }
        });
    }

    public void setPath(PathPoint p){
        textView.setTranslationX(p.mX);
        textView.setTranslationY(p.mY);
    }
}
