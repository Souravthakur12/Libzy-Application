package abvgiet.college.Libzy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

import abvgiet.college.Libzy.model.UserInfo;
import abvgiet.college.Libzy.module.UserActivity;

public class VerifyOtpActivity extends AppCompatActivity {
    private EditText inputcode1;
    private EditText inputcode2;
    private EditText inputcode3;
    private EditText inputcode4;
    private EditText inputcode5;
    private EditText inputcode6;
    private String verificationId;

    private TextView code,Phone_no;

    FirebaseDatabase rootnode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        TextView textmobile = findViewById(R.id.txtmobile);
        textmobile.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));

        inputcode1 = findViewById(R.id.inputcode1);
        inputcode2 = findViewById(R.id.inputcode2);
        inputcode3 = findViewById(R.id.inputcode3);
        inputcode4 = findViewById(R.id.inputcode4);
        inputcode5 = findViewById(R.id.inputcode5);
        inputcode6 = findViewById(R.id.inputcode6);

        code = findViewById(R.id.resend_code);

        Phone_no = findViewById(R.id.txtmobile);


        setupOTPInputs();


        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final Button buttonverify = findViewById(R.id.verifybutton);

        verificationId = getIntent().getStringExtra("verificationId");

        buttonverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputcode1.getText().toString().trim().isEmpty()
                    || inputcode2.getText().toString().trim().isEmpty()
                        || inputcode3.getText().toString().trim().isEmpty()
                        || inputcode4.getText().toString().trim().isEmpty()
                        || inputcode5.getText().toString().trim().isEmpty()
                        || inputcode6.getText().toString().trim().isEmpty()){
                    Toast.makeText(abvgiet.college.Libzy.VerifyOtpActivity.this,"Please Enter Otp",Toast.LENGTH_SHORT).show();

                }
                String code =
                        inputcode1.getText().toString() +
                                inputcode2.getText().toString() +
                                inputcode3.getText().toString() +
                                inputcode4.getText().toString() +
                                inputcode5.getText().toString() +
                                inputcode6.getText().toString() ;

                if (verificationId !=null){
                    progressBar.setVisibility(View.VISIBLE);
                    buttonverify.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            verificationId,code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);
                                    buttonverify.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()){
                                        rootnode = FirebaseDatabase.getInstance();
                                        reference = rootnode.getReference().child("Orders");

                                        UserInfo userInfo = new UserInfo();

                                        userInfo.setPhone_no(Phone_no.getText().toString());


                                        Intent intent = new Intent(getApplicationContext(), User_Order_Sucess.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(abvgiet.college.Libzy.VerifyOtpActivity.this,"The Verfication Code is Invalid",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+ getIntent().getStringExtra("mobile"),60, TimeUnit.SECONDS, abvgiet.college.Libzy.VerifyOtpActivity.this,new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(abvgiet.college.Libzy.VerifyOtpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newverificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                              verificationId = newverificationId;
                              Toast.makeText(abvgiet.college.Libzy.VerifyOtpActivity.this,"OTP Send",Toast.LENGTH_SHORT).show();

                            }
                        }
                );

            }
        });
    }


    private void setupOTPInputs(){
        inputcode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputcode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputcode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputcode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputcode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputcode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputcode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputcode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputcode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()){
                    inputcode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}