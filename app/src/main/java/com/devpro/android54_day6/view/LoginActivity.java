package com.devpro.android54_day6.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day6.R;
import com.devpro.android54_day6.constant.Constant;
import com.devpro.android54_day6.interfaces.IAuthenticationView;
import com.devpro.android54_day6.model.UserModel;
import com.devpro.android54_day6.presenter.Login;
import com.devpro.android54_day6.utils.PrefManage;

public class LoginActivity extends AppCompatActivity {

    public class LoginActivity extends AppCompatActivity implements IAuthenticationView {
        private EditText edtUsername, edtPassword;
        private TextView tvRegister;
        private Button btnLogin;
        private Login loginPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_activity);

            getData();
            initView();
            loginPresenter =new Login(this);
        }

        private void initView() {
            edtUsername = findViewById(R.id.edtUserName);
            edtPassword = findViewById(R.id.edtPassword);
            tvRegister = findViewById(R.id.tvRegis);
            btnLogin = findViewById(R.id.btLogin);

            btnLogin.setOnClickListener(v -> {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                login(username,password);
            });
            tvRegister.setOnClickListener(v -> {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            });
        }


        @Override
        public void login(String username, String password) {
            loginPresenter.login(username,password);
        }

        @Override
        public void onLoginSucces(UserModel model) {
            Toast.makeText(this, "Xin chao "+model.toString(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();

        }

        @Override
        public void onLoginError(String error) {
            Toast.makeText(this, "Login Fail "+error, Toast.LENGTH_SHORT).show();
        }
        private void getData(){
            PrefManage.getString(Constant.USER_NAME_KEY);
            Log.d("oncreat:",PrefManage.getString(Constant.USER_NAME_KEY).toString());
        }
    }
}