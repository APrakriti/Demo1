package com.prakriti.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prakriti.demo.DbHelper;


public class LoginPage extends AppCompatActivity {
     EditText email1, password1;
    Button login ;
    DbHelper dbHelper;
    TextView createuser;
    String login_email,login_password;
    CheckBox checkBox;

    TextInputLayout inputLayoutemail, inputLayoutpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        email1 = (EditText)findViewById(R.id.loginemail);
        password1= (EditText) findViewById(R.id.loginPass);
        login = (Button) findViewById(R.id.btnlogin);
        checkBox= (CheckBox) findViewById(R.id.cbvisible);
        createuser = (TextView) findViewById(R.id.CreateUser);
        inputLayoutemail =(TextInputLayout)findViewById(R.id.inputlayout_login_email);
        inputLayoutpassword=(TextInputLayout)findViewById(R.id.inputlayout_login_password);


        dbHelper = new DbHelper(LoginPage.this);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    password1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    password1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
});


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_email = email1.getText().toString();
                login_password = password1.getText().toString();



                if (login_email.equals("") || login_password.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();

                }



                else if(dbHelper.isValidUser(login_email,login_password)){
                    Intent intent=new Intent(LoginPage.this,MainActivity.class);
                    intent.putExtra("key",login_email);
                    startActivity(intent);

            } else{
                    Toast.makeText(LoginPage.this, "Invalid Credentials"+login_email+login_password, Toast.LENGTH_SHORT).show();
                }

               SharedPreferences sharedPreferences = getSharedPreferences("Reg", MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("Email", login_email);
                editor.putString("Password",login_password);
                editor.commit();


            }
        });



        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, SignUpPage.class);
                startActivity(intent);
            }
        });



    }
}

