package cn.edu.sdut.softlab.broadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        msgText = (EditText)findViewById(R.id.msgText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String CHANNEL = "cn.edu.sdut.softlab";
                Intent intent = new Intent(CHANNEL);
                intent.putExtra("msg", msgText.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}
