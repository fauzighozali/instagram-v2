package com.example.fauzighozali.instagram.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fauzighozali.instagram.R;
import com.example.fauzighozali.instagram.facebook.FacebookActivity;
import com.example.fauzighozali.instagram.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private Button buttonLogin;
    private TextView register;
    private TextView facebook;
    private TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.edit_text_username);
        password = findViewById(R.id.edit_text_password);
        buttonLogin = findViewById(R.id.button_login);
        register = findViewById(R.id.text_view_register);
        facebook = findViewById(R.id.text_view_facebook);
        forgot = findViewById(R.id.text_view_forgot_password);

        buttonLogin.setOnClickListener(v -> validateCredentials());
        register.setOnClickListener(v -> validateRegister());
        facebook.setOnClickListener(v -> validateFacebook());
        forgot.setOnClickListener(v -> validateForgot());

        presenter = new LoginPresenter(this, new LoginInteractor());

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
                    buttonLogin.setTextColor(Color.parseColor("#ffffff"));
                    buttonLogin.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login));
                    buttonLogin.setEnabled(true);
                }
                else {
                    buttonLogin.setTextColor(Color.parseColor("#eaf3f2"));
                    buttonLogin.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login_disable));
                    buttonLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
                    buttonLogin.setTextColor(Color.parseColor("#ffffff"));
                    buttonLogin.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login));
                    buttonLogin.setEnabled(true);
                }
                else {
                    buttonLogin.setTextColor(Color.parseColor("#eaf3f2"));
                    buttonLogin.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_button_login_disable));
                    buttonLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initializePresenter() {
        presenter.attachView(this);
    }

    private void validateCredentials() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }

    private void validateRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void validateFacebook() {
        Intent intent = new Intent(LoginActivity.this, FacebookActivity.class);
        startActivity(intent);
    }

    private void validateForgot() {
        Toast.makeText(getApplicationContext(), "Forgot Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
    }
}
