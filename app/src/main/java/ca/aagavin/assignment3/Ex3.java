package ca.aagavin.assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Ex3 extends AppCompatActivity {

    private ImageView _moonImageView;
    private Animation _animation;
    private Animation _animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);


    }

    public void startBtnClick(View view) {

        this._moonImageView = (ImageView) findViewById(R.id.moonImageView);

        this._animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        this._animation.setRepeatMode(Animation.INFINITE);
        this._animation2 = AnimationUtils.loadAnimation(this, R.anim.anim2);

        this._moonImageView.startAnimation(this._animation);


    }
}
