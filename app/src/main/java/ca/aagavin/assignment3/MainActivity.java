package ca.aagavin.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListView)findViewById(R.id.mainlist)).setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), id+"",
                Toast.LENGTH_SHORT).show();

        switch ((int) id){
            case 0:
                startActivity(new Intent(this, Ex1.class));
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }


}
