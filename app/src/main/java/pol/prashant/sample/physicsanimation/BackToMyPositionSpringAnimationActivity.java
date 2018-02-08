package pol.prashant.sample.physicsanimation;

import android.content.Context;
import android.content.Intent;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class BackToMyPositionSpringAnimationActivity extends AppCompatActivity {

    ImageView imgObject;
    float xDiff, yDiff;

    SpringAnimation xAnimation, yAnimation;
    SpringForce springForce;

    public static Intent newInstance(Context context) {
        return new Intent(context, BackToMyPositionSpringAnimationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_to_my_position);

        imgObject = (ImageView) findViewById(R.id.img_object);

        // touch listener to drag item
        imgObject.setOnTouchListener(new MyTouchListener());

        // force to specify how fast and how bouncy object should come back
        springForce = new SpringForce(0)  // object should come back to original position
                .setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_MEDIUM);

        xAnimation = new SpringAnimation(imgObject, DynamicAnimation.TRANSLATION_X); // animation for x coordinate
        yAnimation = new SpringAnimation(imgObject, DynamicAnimation.TRANSLATION_Y); // animation for y coordinate

        xAnimation.setSpring(springForce);
        yAnimation.setSpring(springForce);
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
                    break;

                case MotionEvent.ACTION_UP :
                    // this will execute when we leave object (when we move finger up)
                    xAnimation.start();
                    yAnimation.start();
                    break;
            }

            return true;
        }
    }
}
