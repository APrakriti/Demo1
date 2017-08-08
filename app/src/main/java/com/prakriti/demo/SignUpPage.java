package com.prakriti.demo;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prakriti.demo.DbHelper;

import static android.R.attr.name;


public class SignUpPage extends AppCompatActivity {
    EditText first_name,middle_name,last_name,address,contact, email, username, password,confirmpassword;
    Button register;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    DbHelper dbHelper;
    String sfirstname, smiddlename, slastname,saddress, susername,  spassword, sconfirmpassword, semail, scontact;
   // String aname, ausername,  apassword, aconfirmpassword, aemail, acontact;
    TextInputLayout inputLayoutname, inputLayoutusername, inputLayoutpassword,
            inputLayoutemail, inputLayoutcontact,inputLayoutaddress;
    TextInputLayout inputLayoutconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        first_name = (EditText) findViewById(R.id.signupfirstname);
        middle_name = (EditText) findViewById(R.id.signupmiddlename);
        last_name = (EditText) findViewById(R.id.signuplastname);
        address = (EditText) findViewById(R.id.signupAddress);
        contact = (EditText) findViewById(R.id.signupContact);
        email = (EditText) findViewById(R.id.signupemail);
        username = (EditText) findViewById(R.id.signupUsername);
        password = (EditText) findViewById(R.id.singupPassword);
        dbHelper = new DbHelper(SignUpPage.this);
        username = (EditText) findViewById(R.id.signupUsername);
        password = (EditText) findViewById(R.id.singupPassword);
        confirmpassword = (EditText) findViewById(R.id.singupconfirmPassword);
        contact = (EditText) findViewById(R.id.signupContact);
        email = (EditText) findViewById(R.id.signupemail);
        register = (Button) findViewById(R.id.btnRegister);
        inputLayoutusername = (TextInputLayout) findViewById(R.id.inputlayout_username);
        inputLayoutpassword = (TextInputLayout) findViewById(R.id.inputlayout_password);
        inputLayoutcontact = (TextInputLayout) findViewById(R.id.inputlayout_Contact);
        inputLayoutaddress = (TextInputLayout) findViewById(R.id.inputlayout_address);
        inputLayoutconfirm = (TextInputLayout) findViewById(R.id.inputlayout_confirmpassword);
        inputLayoutemail = (TextInputLayout) findViewById(R.id.inputlayout_email);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    sfirstname = first_name.getText().toString();
                    smiddlename = middle_name.getText().toString();
                    slastname = last_name.getText().toString();
                    saddress = address.getText().toString();
                    scontact = contact.getText().toString();
                    semail = email.getText().toString();
                    susername = username.getText().toString();
                    spassword = password.getText().toString();




                    if (sfirstname.equals("") ||smiddlename.equals("") ||slastname.equals("") ||sfirstname.equals("")
                            || saddress.equals("")
                            || spassword.equals("")|| semail.equals("")|| scontact.equals("")) {

                        Toast.makeText(getApplicationContext(), "Field Vaccant",
                                Toast.LENGTH_LONG).show();

                    }
                    else if(!semail.matches(emailPattern)){
                        Toast.makeText(SignUpPage.this, "Invalid Password", Toast.LENGTH_SHORT).show();

                    }
                   else if(scontact.length() != 10){
                        Toast.makeText(SignUpPage.this, "Invalid Contact", Toast.LENGTH_SHORT).show();
                    }
                        
                    else if(sfirstname.length()<=4 && username.length() <=4){
                        Toast.makeText(SignUpPage.this, "Username and Name most contain more than " +
                                "4 letter ", Toast.LENGTH_SHORT).show();
                     }
                    else {


                        ContentValues cv = new ContentValues();
                        cv.put("first_name", sfirstname);
                        cv.put("middle_name", smiddlename);
                        cv.put("last_name", slastname);
                        cv.put("address", saddress);
                        cv.put("username", susername);
                        cv.put("password", spassword);
                        cv.put("email", semail);
                        cv.put("contact", scontact);

                        dbHelper.insertuserinfo(cv);

                      //  Toast.makeText(SignUpPage.this, "sname", Toast.LENGTH_SHORT).show();

                        Toast.makeText(getApplicationContext(),
                                "Account Successfully Created ", Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(SignUpPage.this,
                                LoginPage.class);
                        startActivity(i);
                        finish();
                    }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        dbHelper.close();
    }
}






             /*   aname = name.getText().toString();
                ausername = username.getText().toString();
                apassword = password.getText().toString();
                aemail = email.getText().toString();
                acontact = contact.getText().toString();
                aconfirmpassword = confirm.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("name", aname);
                cv.put("username", ausername);
                cv.put("password", apassword);
                cv.put("confirmp", aconfirmpassword);
                cv.put("email", aemail);
                cv.put("contact", acontact);

                dbHelper.insertuserinfo(cv);



                if (aname.equals("") || ausername.equals("")
                        || apassword.equals("") || aconfirmpassword.equals("") || aemail.equals("") || acontact.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                } else if (aemail.matches(emailPattern) && aemail.length() > 0 && apassword.length() >= 4
                        && apassword.equals(aconfirmpassword) && aname.length() >= 4 && acontact.length() == 10
                        && ausername.length() >= 4) {

                    Toast.makeText(SignUpPage.this, "Sucessfully registerd", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SignUpPage.this, "Invalid ", Toast.LENGTH_SHORT).show();



                }} ;});}}*/





               /* ContentValues cv = new ContentValues();
                cv.put("name", sname);
                cv.put( "username", susername);
                cv.put("password",spassword);
                cv.put("email",semail );
                cv.put("contact", scontact );*/

               // dbHelper.insertuserinfo(cv);{

            /*    if(name.getText().toString().trim().length()==0){
                    name.setError("Name is not entered");
                    name.requestFocus();
                }
                if(username.getText().toString().trim().length()==0){
                    username.setError("Username is not entered");
                    username.requestFocus();
                }
                if(password.getText().toString().trim().length()==0){
                    password.setError("Password is not  entered");
                    password.requestFocus();
                }
                if(contact.getText().toString().trim().length()==0){
                    contact.setError("Contact Number is not entered");
                    contact.requestFocus();
                }
                if(email.getText().toString().trim().length()==0){
                    email.setError("Email Address is not entered");
                    email.requestFocus();
                }
                else {

                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    Toast.makeText(SignUpPage.this, "Saved in database", Toast.LENGTH_SHORT).show();
                    startActivity(it);
                }
            }}
        });*/


