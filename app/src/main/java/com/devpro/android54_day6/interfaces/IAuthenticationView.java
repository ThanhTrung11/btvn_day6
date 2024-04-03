package com.devpro.android54_day6.interfaces;

import com.devpro.android54_day6.model.UserModel;

public interface IAuthenticationView {
    void register(UserModel model);

    void login(String userName, String password);

    void onLoginSuccess(UserModel model);

    void onLoginError(String error);

    void onRegisterSuccess(UserModel model);

    void onRegisterError(String error);
}
