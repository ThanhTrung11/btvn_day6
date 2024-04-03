package com.devpro.android54_day6.presenter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day6.R;
import com.devpro.android54_day6.interfaces.IAuthenticationView;
import com.devpro.android54_day6.model.UserModel;

public class Res  extends AppCompatActivity  {

        private EditText edtUsername, edtPassword, edtEmail, edtPhone;
        private TextView tvLogin;
        private Button btnSignUp;
        private Res registerPresenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.res_activity);

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
            registerPresenter.addUser(model);
        }

    private void addUser(UserModel model) {
    }

    @Override
        public void onRegisError(String error) {
            Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRegisSuccess(UserModel model) {
            Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

        }

    }
}
