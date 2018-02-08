package pol.prashant.sample.physicsanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by prashant.pol on 2/8/2018.
 */

public class EnlargeAsGoDownSpringAnimation extends AppCompatActivity {

    int normalScaleMargin = 300;

    ImageView imgObject;
    float xDiff, yDiff;

    SpringAnimation xAnimation, yAnimation;

    public static Intent newInstance(Context context) {
        return new Intent(context, EnlargeAsGoDownSpringAnimation.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge_as_go_down);

        imgObject = (ImageView) findViewById(R.id.img_object);
        // touch listener to drag item
        imgObject.setOnTouchListener(new EnlargeAsGoDownSpringAnimation.MyTouchListener());

        xAnimation = new SpringAnimation(imgObject, DynamicAnimation.SCALE_X); // animation for x coordinate
        yAnimation = new SpringAnimation(imgObject, DynamicAnimation.SCALE_Y); // animation for y coordinate

    }

    // to drag item
    private class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN :
                    // when object will be tapped, this will be executed only once
                    // we will record difference between tapped location and object's top left coordinates
                    xDiff = event.getRawX() - v.getX();
                    yDiff = event.getRawY() - v.getY();
                    break;

                case MotionEvent.ACTION_MOVE :
                    // this will keep on execute as we drag finger across the screen
                    // use the initial difference that we noted down to calculate new position of object from finger's position
                    float newX = event.getRawX() - xDiff;
                    float newY = event.getRawY() - yDiff;
                    imgObject.setX(newX);
                    imgObject.setY(newY);

                    int scaleFactor = (int) (event.getRawY() / normalScaleMargin);

                    scaleFactor = scaleFactor < 1 ? 1 : scaleFactor;

                    // animate when we are dragging
                    xAnimation.animateToFinalPosition(scaleFactor);
                    yAnimation.animateToFinalPosition(scaleFactor);
                    break;

            }

            return true;
        }
    }
}
