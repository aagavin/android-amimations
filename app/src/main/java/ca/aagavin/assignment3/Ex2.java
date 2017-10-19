package ca.aagavin.assignment3;

import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

@SuppressWarnings("ResourceType") // for the typed array error
public class Ex2 extends AppCompatActivity {

    private AnimationDrawable _mframeAnimation = null;

    /**
     * OnCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
    }

    /**
     * Create frames from a typed array and sets
     * it as an animation using and imageView
     * @param view
     */
    public void onStartClick(View view) {
        ImageView img = (ImageView)findViewById(R.id.keyImageView);

        int reasonableDuration = 250;
        this._mframeAnimation = new AnimationDrawable();
        this._mframeAnimation.setOneShot(false);	// loop continuously

        TypedArray imgs = getResources().obtainTypedArray(R.array.gif_imgs);

        BitmapDrawable frame;
        for(int i =0; i < 50; i++){
            frame = (BitmapDrawable)getResources().getDrawable(imgs.getResourceId(i,0));
            this._mframeAnimation.addFrame(frame, reasonableDuration);
        }

        img.setBackgroundDrawable(this._mframeAnimation);
        this._mframeAnimation.setVisible(true,true);
        this._mframeAnimation.start();

        imgs.recycle();
    }

    /**
     * Stops any annimation
     * @param view
     */
    public void onStopClick(View view) {
        this._mframeAnimation.stop();
        this._mframeAnimation.setVisible(false,false);
    }
}
