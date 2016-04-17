package kashmor.cashme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.*;
import com.firebase.*;

import java.util.Map;

public class RegisterPage extends AppCompatActivity {

    EditText full_name;
    EditText user_name;
    EditText email_field;
    EditText password_field;
    EditText re_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_page);
        Button register_button;
        register_button = (Button)findViewById(R.id.register);

        Firebase.setAndroidContext(this);

        register_button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Firebase ref = new Firebase("https://qTFlbVQdyslPh7uElsCnkJPlp6fU9Zqq9zOIyRAP.firebaseio.com/");
                        email_field = (EditText) findViewById(R.id.email);
                        password_field = (EditText) findViewById(R.id.password);

                        ref.createUser("bobtony@firebase.com", "correcthorsebatterystaple", new Firebase.ValueResultHandler<Map<String, Object>>() {
                            @Override
                            public void onSuccess(Map<String, Object> result) {
                                System.out.println("Successfully created user account with uid: " + result.get("uid"));
                            }
                            @Override
                            public void onError(FirebaseError firebaseError) {
                                // there was an error
                            }
                        });

//                        Intent myIntent;
//                        myIntent = new Intent(LoginPage.this, HomePage.class);
//                        LoginPage.this.startActivity(myIntent);
                    }
                }
        );

    }
}

class User {
    private int birthYear;
    private String fullName;
    public User() {}
    public User(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }
    public long getBirthYear() {
        return birthYear;
    }
    public String getFullName() {
        return fullName;
    }
}