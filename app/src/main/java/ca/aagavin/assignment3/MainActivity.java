package ca.aagavin.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListView)findViewById(R.id.mainlist)).setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        switch ((int) id){
            case 0:
                startActivity(new Intent(this, Ex1.class));
                break;
            case 1:
                startActivity(new Intent(this, Ex2.class));
                break;
            case 2:
                startActivity(new Intent(this, Ex3.class));
                break;
            default:
                break;
        }
    }


}
