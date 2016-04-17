package kashmor.cashme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Button sign_in_button;
        Button register_button;
        sign_in_button = (Button)findViewById(R.id.sign_in);
        register_button = (Button)findViewById(R.id.register);

        sign_in_button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent;
                        myIntent = new Intent(LoginPage.this, HomePage.class);
                        LoginPage.this.startActivity(myIntent);
                    }
                }
        );

        register_button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent;
                        myIntent = new Intent(LoginPage.this, RegisterPage.class);
                        LoginPage.this.startActivity(myIntent);
                    }
                }
        );
    }
}
