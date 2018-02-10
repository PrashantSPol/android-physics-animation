package pol.prashant.sample.physicsanimation;

import android.content.Context;
import android.support.animation.DynamicAnimation;
import android.support.animation.FloatPropertyCompat;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by polprashant on 10/02/18.
 */

public class SelectableImageView extends AppCompatImageView implements View.OnClickListener {
    SpringAnimation selectAnimation;
    SpringForce springForce;
    boolean isSelected = false;

    private final float MINIMUM_SCALE = 0.8f;
    private final float EXTRA_MINIMUM_SCALE = 0.6f;
    private final float MAXIMUM_SCALE = 1f;

    public SelectableImageView(Context context) {
        super(context);
        init();
    }

    public SelectableImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SelectableImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        // create animation
        selectAnimation = new SpringAnimation(this, new FloatPropertyCompat<SelectableImageView>("scaleX") {
            @Override
            public float getValue(SelectableImageView image) {
                return image.getScaleX();
            }

            @Override
            public void setValue(SelectableImageView image, float value) {
                image.setScaleX(value);
                image.setScaleY(value);
            }
        });

        // to create bouncy effect
        selectAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                if(value < 0.7f) {
                    selectAnimation.animateToFinalPosition(0.8f);
                }
            }
        });

        // spring force for bouncy effect
        springForce = new SpringForce(0)
                .setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
                .setStiffness(SpringForce.STIFFNESS_VERY_LOW);

        selectAnimation.setSpring(springForce);

        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view != this) {
            return;
        }

        if(isSelected()) {
            selectAnimation.animateToFinalPosition(1f);
        } else {
            selectAnimation.animateToFinalPosition(0.6f);
        }
        isSelected = !isSelected;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
