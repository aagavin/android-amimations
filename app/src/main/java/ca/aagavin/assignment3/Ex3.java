package ca.aagavin.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Ex3 extends AppCompatActivity {

    private ImageView _moonImageView;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);


    }

    /**
     * Sets up the animations and starts it
     * @param view
     */
    public void startBtnClick(View view) {

        this._moonImageView = (ImageView) findViewById(R.id.moonImageView);

        Animation _animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        _animation.setRepeatMode(Animation.INFINITE);

        this._moonImageView.startAnimation(_animation);


    }

    /**
     * Resets any running animation
     * @param view
     */
    public void stopBtnClick(View view) {
        this._moonImageView.clearAnimation();
    }
}
