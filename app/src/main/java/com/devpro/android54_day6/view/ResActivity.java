package com.devpro.android54_day6.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devpro.android54_day6.MyApplication;
import com.devpro.android54_day6.R;
import com.devpro.android54_day6.interfaces.IAuthenticationPresenter;
import com.devpro.android54_day6.interfaces.IAuthenticationView;
import com.devpro.android54_day6.model.UserModel;
import com.devpro.android54_day6.presenter.Res;

public class ResActivity extends MyApplication  {

        private EditText edtUsername,edtPassword,edtEmail,edtPhone;
        private TextView tvLogin;
        private Button btnSignUp;
        private  ResActivity;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getContentResolver(R.layout.res_activity);

            initView();
            registerPresenter = new Res(this);

        }


    private void initView() {
            edtUsername = findViewById(R.id.edtUserName);
            edtPassword = findViewById(R.id.edtPassword);
            edtEmail = findViewById(R.id.edtEmail);
            edtPhone = findViewById(R.id.edtPhone);
            tvLogin = findViewById(R.id.tvLogin);
            btnSignUp = findViewById(R.id.btSignUp);

            tvLogin.setOnClickListener(v -> {
                finish();
            });
            btnSignUp.setOnClickListener(v -> {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();

                UserModel newUser = new UserModel();

                newUser.setUsername(username);
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setPhone(phone);

                register(newUser);


                finish();
            });
        }



    @Override
        public void register(UserModel model) {
        IAuthenticationPresenter registerPresenter;
        registerPresenter.addUser(model);
        }

        @Override
        public void onRegisError(String error) {
            Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRegisSuccess(UserModel model) {
            Toast.makeText(this,"Đăng kí thành công", Toast.LENGTH_SHORT).show();

        }

    }
