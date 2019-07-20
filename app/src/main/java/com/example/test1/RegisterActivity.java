package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

   private EditText mName, mEmail, mPassword, mConfirmPassword;
    private Button mRegister;
    CircleImageView mImage;
    private TextView mHaveAnAccount;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        initializeVariables();

        mRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput())
                    doRegister();
            }
        });


        mHaveAnAccount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void doRegister() {


        mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(),mPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(RegisterActivity.this, "succesful",Toast.LENGTH_SHORT).show();
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);




                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, task.getException().toString(),Toast.LENGTH_SHORT).show();
                            Log.d("davy",task.getException().toString());


                        }

                        // ...
                    }
                });

    }

    private void initializeVariables() {
        mName = findViewById(R.id.reg_name);
        mEmail = findViewById(R.id.reg_email);
        mPassword = findViewById(R.id.reg_password);
        mConfirmPassword = findViewById(R.id.confirm_password);
        mRegister = findViewById(R.id.btn_register);
        mImage = findViewById(R.id.reg_account);
        mHaveAnAccount = findViewById(R.id.txt_already_have_an_account);


    }


    private boolean validateInput() {
        boolean isInputValid = false;

        String name = mName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String cpassword = mConfirmPassword.getText().toString().trim();

        if (!name.isEmpty()) {
            if (!email.isEmpty()) {
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!password.isEmpty()) {
                        if (!cpassword.isEmpty()) {
                            if (password.equals(cpassword)) {
                                if (password.length() >= 6) {
                                    isInputValid = true;
                                } else {
                                    mPassword.setError("Password is too Short. Must be at Least 6 Characters");
                                    mPassword.requestFocus();
                                }
                            } else {
                                Toast.makeText(this, "PassWord Mismatch", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            mPassword.setError("Password Confirmation Required!");
                            mPassword.requestFocus();
                        }
                    } else {
                        mPassword.setError("Password Cannot be Empty!");
                        mPassword.requestFocus();
                    }
                } else {
                    mEmail.setError("Invalid Email input!");
                    mEmail.requestFocus();
                }
            } else {
                mEmail.setError("Email Cannot be Empty!");
                mEmail.requestFocus();
            }
        } else {

            mName.setError("Username cannot be Empty!");
            mName.requestFocus();
        }


        return isInputValid;
    }


}
