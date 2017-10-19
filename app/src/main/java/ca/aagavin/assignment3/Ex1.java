package ca.aagavin.assignment3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Ex1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private ImageView _drawimage;

    //
    int _startx = 10;
    int _starty = 10;
    int _endx =10;
    int _endy =10;

    private Paint _paint;
    private Canvas _canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        this._paint = new Paint();
        this._paint.setColor(Color.RED);
        this._paint.setStrokeWidth(10);

        Bitmap _bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth() + 500, (int) getWindowManager()
                .getDefaultDisplay().getHeight() + 500, Bitmap.Config.ARGB_8888);
        this._canvas = new Canvas(_bitmap);

        this._drawimage =(ImageView)findViewById(R.id.drawimage);
        //setting a bitmap as content view for the image
        this._drawimage.setImageBitmap(_bitmap);

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(this);
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this._paint.setStrokeWidth(Integer.parseInt(adapterView.getItemAtPosition(i).toString()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        RadioButton radioButton = (RadioButton) findViewById(i);

        switch (radioButton.getText().toString()){
            case "Red":
                _paint.setColor(Color.RED);
                break;
            case "yellow":
                _paint.setColor(Color.YELLOW);
                break;
            case "Cyan":
                _paint.setColor(Color.CYAN);
                break;
            default:
                break;
        }

    }

    private void _buttonClick(int valueX, int valueY){
        _endx +=valueX;
        _endy +=valueY;
        _drawLine();
        this._drawimage.invalidate();
    }

    private void _drawLine()    {
        this._canvas.drawLine(_startx, _starty, _endx, _endy, this._paint);
        _startx = _endx;
        _starty = _endy;
    }


    public void buttonDownClick(View view) {
        this._buttonClick(0,10);
    }

    public void buttonUpClick(View view) {
        this._buttonClick(0,-10);
    }

    public void buttonRightClick(View view) {
        this._buttonClick(10,0);
    }

    public void buttonLeftClick(View view) {
        this._buttonClick(-10,0);
    }

    public void clearBtnClick(View view) {
        this._drawimage.invalidate();
        this._canvas.drawColor(Color.BLACK);
    }

    public void resetBtnClick(View view) {
        this.clearBtnClick(view);
        this._startx = 10;
        this._starty = 10;
        this._endx =10;
        this._endy =10;
    }

    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                this.buttonDownClick(null);
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                this.buttonUpClick(null);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                this.buttonRightClick(null);
                return true;
            case  KeyEvent.KEYCODE_DPAD_LEFT:
                this.buttonLeftClick(null);
                return true;
        }
        return false;
    }
}
