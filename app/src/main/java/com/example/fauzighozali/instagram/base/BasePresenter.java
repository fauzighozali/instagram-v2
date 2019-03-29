package com.example.fauzighozali.instagram.base;

import android.support.annotation.NonNull;

public interface BasePresenter<T extends BaseView> {
    void attachView(@NonNull T view);
}
