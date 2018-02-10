package pol.prashant.sample.physicsanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by polprashant on 10/02/18.
 */

public class SelectableImageDemo extends AppCompatActivity {
    public static Intent newInstance(Context context) {
        return new Intent(context, SelectableImageDemo.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectable_image_demo);
    }
}
