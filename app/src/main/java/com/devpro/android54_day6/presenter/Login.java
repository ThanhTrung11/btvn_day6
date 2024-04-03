package com.devpro.android54_day6.presenter;

import com.devpro.android54_day6.interfaces.IAuthenticationPresenter;
import com.devpro.android54_day6.interfaces.IAuthenticationView;
import com.devpro.android54_day6.model.DataUser;
import com.devpro.android54_day6.model.UserModel;

public class Login implements IAuthenticationPresenter {
    private final IAuthenticationView iAuthenticationView;
    private final DataUser userDatabase;

    public Login(IAuthenticationView iAuthenticationView) {
        this.iAuthenticationView = iAuthenticationView;
        userDatabase = DataUser.getInstances();
        userDatabase.setIAuthenticationPresenter(this);
    }

    public void login(String userName, String password) {
        userDatabase.checkAuthentication(userName, password);
    }

    @Override
    public void addUser(UserModel model) {
        userDatabase.register(model);
    }

    @Override
    public boolean checkAuthentication(String userName, String password) {
        return false;
    }

    @Override
    public void onLoginSuccess(UserModel model) {
        iAuthenticationView.onLoginSuccess(model);
    }

    @Override
    public void onLoginError(String error) {
        iAuthenticationView.onLoginError(error);
    }

    @Override
    public void onRegisterSuccess(UserModel model) {
        iAuthenticationView.onRegisterSuccess(model);
    }

    @Override
    public void onRegisterError(String error) {
        iAuthenticationView.onRegisterError(error);
    }
}
