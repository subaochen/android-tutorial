package android.softlab.sdut.edu.cn.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int SUB_ONE_ACTIVITY = 1;
    private static final int SUB_TWO_ACTIVITY = 2;

    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubOneActivity.class);
                startActivityForResult(intent, SUB_ONE_ACTIVITY);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubTwoActivity.class);
                startActivityForResult(intent, SUB_TWO_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String msg = data.getStringExtra("msg");
        switch(requestCode) {
            case SUB_ONE_ACTIVITY:
                if(resultCode == RESULT_OK)
                    Toast.makeText(this,msg,Toast.LENGTH_SHORT);
                break;
            case SUB_TWO_ACTIVITY:
                if(resultCode == RESULT_OK)
                    Log.d("MyTag", msg);
                break;
            default:
        }
    }

}
