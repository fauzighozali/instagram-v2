package com.example.fauzighozali.instagram.login;

import com.example.fauzighozali.instagram.base.BasePresenter;
import com.example.fauzighozali.instagram.base.BaseView;

public class LoginContract {
    public interface View extends BaseView {
        // Interface with View
        void showProgress();
        void hideProgress();
        void showError();
        void navigateToHome();
    }

    public interface Presenter extends BasePresenter<View> {
        // Actions with View
        void onDestroy();
        void onSuccess();
        void onError();
        void validateCredentials(String username, String password);
    }

    public interface Interactor {
        // Interaction with API
    }
}
