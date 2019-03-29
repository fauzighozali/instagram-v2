package com.example.fauzighozali.instagram.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.logging.Handler;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginContract.Interactor interactor;

    public LoginPresenter(LoginContract.View view, LoginContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void attachView(@NonNull LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (view != null){
            view.showProgress();
        }
        new android.os.Handler().postDelayed(() -> {
            if (username.equals("admin") && password.equals("admin")){
                view.hideProgress();
                onSuccess();
            }else {
                view.hideProgress();
                onError();
            }
        },1000);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.navigateToHome();
        }
    }

    @Override
    public void onError() {
        if (view != null) {
            view.showError();
        }
    }
}
