package pol.prashant.sample.physicsanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by polprashant on 2/9/2018.
 */

public class FollowMeSpringAnimation extends AppCompatActivity {
    ImageView img1, img2, img3;
    SpringAnimation xAnimFollow1, xAnimFollow2;
    SpringAnimation yAnimFollow1, yAnimFollow2;

    public static Intent newInstance(Context context) {
        return new Intent(context, FollowMeSpringAnimation.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_me);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnTouchListener(new MyTouchListener());

        animationForFirstObject();
    }

    void animationForFirstObject() {
        xAnimFollow1 = new SpringAnimation(img2, DynamicAnimation.TRANSLATION_X);
        yAnimFollow1 = new SpringAnimation(img2, DynamicAnimation.TRANSLATION_Y);

        xAnimFollow2 = new SpringAnimation(img3, DynamicAnimation.TRANSLATION_X);
        yAnimFollow2 = new SpringAnimation(img3, DynamicAnimation.TRANSLATION_Y);

        xAnimFollow1.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                xAnimFollow2.animateToFinalPosition(value);
            }
        });

        yAnimFollow1.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                yAnimFollow2.animateToFinalPosition(value);
            }
        });
    }


    private class MyTouchListener implements View.OnTouchListener {
        float xDiff, yDiff;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    xDiff = event.getRawX() - v.getX();
                    yDiff = event.getRawY() - v.getY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    float newX = event.getRawX() - xDiff;
                    float newY = event.getRawY() - yDiff;

                    img1.setX(newX);
                    img1.setY(newY);

                    xAnimFollow1.animateToFinalPosition(img1.getTranslationX());
                    yAnimFollow1.animateToFinalPosition(img1.getTranslationY());

                    break;
            }

            return true;
        }
    }
}
