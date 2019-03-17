package in.ac.nitc.eyyauto_driver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;

import in.ac.nitc.eyyauto_driver.handlers.Event;
import in.ac.nitc.eyyauto_driver.handlers.DriverHandler;
import in.ac.nitc.eyyauto_driver.models.Driver;

import static in.ac.nitc.eyyauto_driver.Constants.INTENT_HAS_PHONE_NUMBER;
import static in.ac.nitc.eyyauto_driver.Constants.INTENT_USER;

public class SplashActivity extends AppCompatActivity {

    private FirebaseUser mUser;
    String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove the Title Bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        redirectUser();
    }

    private void redirectUser() {
        if (mUser == null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            mUserId = mUser.getUid();
            new DriverHandler().readOnce(mUserId, new Event<Driver>() {
                @Override
                public void onReceive(Driver data) {
                    if (data != null) {
                        // redirect to map activity with user profile setup
                        Intent i = new Intent(SplashActivity.this,MapActivity.class);
                        i.putExtra(INTENT_USER,data);
                        startActivity(i);
                        Toast.makeText(SplashActivity.this, "Registration was already done", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        intent.putExtra(INTENT_HAS_PHONE_NUMBER, true);
                        startActivity(intent);
                        finish();
                    }
                }

                @Override
                public void onFailed(DatabaseError databaseError) {

                }
            });
        }
    }
}
