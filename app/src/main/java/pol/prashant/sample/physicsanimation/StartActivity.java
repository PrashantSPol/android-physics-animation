package pol.prashant.sample.physicsanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by prashant.pol on 2/8/2018.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBackToMyPosition;
    Button btnEnlargeAsGoDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnBackToMyPosition = (Button) findViewById(R.id.btn_back_to_my_position);
        btnBackToMyPosition.setOnClickListener(this);

        btnEnlargeAsGoDown = (Button) findViewById(R.id.btn_enlarge_as_go_down);
        btnEnlargeAsGoDown.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_to_my_position :
                startActivity(BackToMyPositionSpringAnimationActivity.newInstance(this));
                break;
            case R.id.btn_enlarge_as_go_down :
                startActivity(EnlargeAsGoDownSpringAnimation.newInstance(this));
                break;
        }
    }
}
