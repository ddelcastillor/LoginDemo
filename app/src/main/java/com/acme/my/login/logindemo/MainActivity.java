package com.acme.my.login.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button login;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.btnLogin);
        login.setNextFocusDownId(R.id.etName);
        info = (TextView)findViewById(R.id.tvInfo);

        name = (EditText)findViewById(R.id.etName);
        name.setNextFocusDownId(R.id.etPassword);
        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if  (keyCode == KeyEvent.KEYCODE_ENTER) {
                    valida(name.getText().toString(),password.getText().toString());
                    return true;
                }
                return false;
            }
        });

        password = (EditText)findViewById(R.id.etPassword);
        password.setNextFocusDownId(R.id.btnLogin);
        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if  (keyCode == KeyEvent.KEYCODE_ENTER) {
                    valida(name.getText().toString(),password.getText().toString());
                    return true;
                }
                return false;
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valida(name.getText().toString(),password.getText().toString());
            }
        });

    }

    @Override
    public void onRestart() {
        super.onRestart();
        name = (EditText)findViewById(R.id.etName);
        name.setText("");
        name.requestFocus();
        password = (EditText)findViewById(R.id.etPassword);
        password.setText("");
        info = (TextView)findViewById(R.id.tvInfo);
        info.setVisibility(View.INVISIBLE);
        info.setText("");
    }

    private void valida (String user, String password){
        if (("Admin".equals(user)) && ("1234".equals(password))){
           Intent intent = new Intent(MainActivity.this,SecondActivity.class);
           startActivity(intent);
        }else{
            info.setVisibility(View.VISIBLE);
            info.setText("Login Incorrecto !!!");
        }
    }
}
