package com.devpro.android54_day6.model;

import com.devpro.android54_day6.interfaces.IAuthenticationPresenter;

import java.util.ArrayList;

public class DataUser {

    private ArrayList<UserModel> mListUser = new ArrayList<>();
    private static DataUser instances;

    public void setIAuthenticationPresenter(IAuthenticationPresenter iAuthenticationPresenter) {
        this.iAuthenticationPresenter = iAuthenticationPresenter;
    }

    private IAuthenticationPresenter iAuthenticationPresenter;

    public static DataUser getInstances() {
        if (instances == null) {
            instances = new DataUser();
        }

        return instances;
    }

    public boolean isUserExisted(String userName) {
        for (UserModel model : mListUser) {
            if (model.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public void checkAuthentication(String userName, String password) {
        if (isUserExisted(userName)) {
            for (UserModel model : mListUser) {
                if (model.getUsername().equals(userName) && model.getPassword().equals(password)) {
                    iAuthenticationPresenter.onLoginSuccess(model);
                    return;
                }
            }
            iAuthenticationPresenter.onLoginError("Sai ten dang nhap hoac mat khau");
        } else {
            iAuthenticationPresenter.onLoginError("Khong tim thay nguoi dung nay");
        }
    }

    public void register(UserModel model) {
        if (isUserExisted(model.getUsername())) {
            iAuthenticationPresenter.onRegisterError("Nguoi dung nay da dang ki, vui long dang nhap");
        } else {
            mListUser.add(model);
            iAuthenticationPresenter.onRegisterSuccess(model);
        }
    }
}