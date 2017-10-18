package ca.aagavin.assignment3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Ex1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView _drawimage;

    //
    int startx = 10;
    int starty = 10;
    int endx=10;
    int endy=10;

    private Paint _paint;
    private Bitmap _bitmap;
    private Canvas _canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        this._paint = new Paint();
        this._paint.setColor(Color.RED);
        this._paint.setStrokeWidth(10);

        this._bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth()+50, (int) getWindowManager()
                .getDefaultDisplay().getHeight()+50, Bitmap.Config.ARGB_8888);
        this._canvas = new Canvas(this._bitmap);

        this._drawimage =(ImageView)findViewById(R.id.drawimage);
        //setting a bitmap as content view for the image
        this._drawimage.setImageBitmap(this._bitmap);

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(_checkedChanged());
        ((Spinner) findViewById(R.id.spinner)).setOnItemSelectedListener(this);

    }

    public void drawLine()
    {
        //canvas.drawLine(100,100,1000,1000,paint);
        this._canvas.drawLine(startx, starty, endx, endy, this._paint);
        startx=endx;
        starty=endy;

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

    private RadioGroup.OnCheckedChangeListener _checkedChanged(){
        return new RadioGroup.OnCheckedChangeListener() {
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
                //System.out.println(radioButton.getText().toString());
            }
        };
    }

    private void _buttonClick(int valueX, int valueY){
        endx+=valueX;
        endy+=valueY;
        drawLine();
        this._drawimage.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this._paint.setStrokeWidth(Integer.parseInt(adapterView.getItemAtPosition(i).toString()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
