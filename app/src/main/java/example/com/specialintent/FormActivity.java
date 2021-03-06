package example.com.specialintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    public static final String REQUEST_TEXT_FIELD_USERNAME = "REQUEST_USERNAME";
    public static final String REQUEST_TEXT_FIELD_PASSWORD = "REQUEST_PASSWORD";
    public static final String REQUEST_TEXT_FIELD_EMAIL = "REQUEST_EMAIL";

    EditText username;
    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent (FormActivity.this, MainActivity.class);
                Intent data = new Intent();
                data.putExtra(REQUEST_TEXT_FIELD_USERNAME, username.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_PASSWORD, password.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_EMAIL, email.getText().toString());
                setResult(RESULT_OK, data);
                finish(); // determinate this activity and turn back to mainActivity
            }
        });


    }

}
