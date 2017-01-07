package example.com.specialintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MOVE = 1000; // must define unique code for intent

    TextView username;
    TextView password;
    TextView email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (TextView) findViewById(R.id.textView);
        password = (TextView) findViewById(R.id.textView2);
        email = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClickMethod", "Working");

                Intent intent = new Intent (MainActivity.this, FormActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MOVE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQUEST_CODE_MOVE == requestCode && RESULT_OK == resultCode) {
            String dataName = data.getStringExtra(FormActivity.REQUEST_TEXT_FIELD_USERNAME);
            String dataPassword = data.getStringExtra(FormActivity.REQUEST_TEXT_FIELD_PASSWORD);
            String dataEmail = data.getStringExtra(FormActivity.REQUEST_TEXT_FIELD_EMAIL);

            username.setText(dataName);
            password.setText(dataPassword);
            email.setText(dataEmail);

        }


    }
}
