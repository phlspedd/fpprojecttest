package br.com.fpprojecttest.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.fpprojecttest.R;
import br.com.fpprojecttest.ui.fragments.LoginFragment;

/**
 * Created by Felipe on 22/06/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void startIntent(Context context, int flags) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        init();
    }

    private void bindViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init() {

        setSupportActionBar(mToolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_login,
                LoginFragment.newInstance(),
                LoginFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
