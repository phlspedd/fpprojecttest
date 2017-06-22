package br.com.fpprojecttest.ui.activities;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import br.com.fpprojecttest.R;

public class MainActivity extends AppCompatActivity {
    private static final int MAIN_TIME_MS = 2000;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {

                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    UserListingActivity.startActivity(MainActivity.this);
                } else {
                    LoginActivity.startIntent(MainActivity.this);
                }
                finish();
            }
        };

        mHandler.postDelayed(mRunnable, MAIN_TIME_MS);
    }
}
