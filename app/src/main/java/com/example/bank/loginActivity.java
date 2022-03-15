package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private static final String id_sure="123456";
    private static final String password_sure="111111";
    private EditText id_edit,password_edit;
    private CheckBox policy;
    private ImageButton login;
    private String id,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();
        OnClick();
    }

    private void initview()//初始化
    {
        id_edit=findViewById(R.id.login_id);
        password_edit=findViewById(R.id.login_password);
        policy=findViewById(R.id.login_policy);
        login=findViewById(R.id.login_btn);
        Log.d("1","1");
    }

    private void OnClick()
    {
        OnClickLister onClickLister=new OnClickLister();
        login.setOnClickListener(onClickLister);
        Log.d("2","1");
    }

    class OnClickLister implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.login_btn:
                    logincheck();
                    Log.d("3","1");
                    break;
                default:
                    break;
            }
        }
    }

    private void logincheck()
    {
        id=id_edit.getText().toString();
        password=password_edit.getText().toString();
        Log.d("5",id+password);
        Intent intent;
        if (id.isEmpty()) {Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            Log.d("5","1212");
        }
        else if (password.isEmpty()) Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
        else if (!policy.isChecked())Toast.makeText(this,"请您阅读并同意《湖南三湘银行隐私政策》",Toast.LENGTH_SHORT).show();
        else if (id.equals(id_sure)&&password.equals(password_sure))
        {
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            intent=new Intent(loginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
        Log.d("4","1");
    }
}