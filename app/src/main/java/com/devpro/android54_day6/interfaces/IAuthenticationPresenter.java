package com.devpro.android54_day6.interfaces;

import com.devpro.android54_day6.model.UserModel;

public interface IAuthenticationPresenter {
    void addUser(UserModel model);

    boolean checkAuthentication(String userName, String password);

    void onLoginSuccess(UserModel model);

    void onLoginError(String error);

    void onRegisterSuccess(UserModel model);

    void onRegisterError(String error);
}
