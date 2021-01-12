package abvgiet.college.Libzy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class SendOtpActivity extends AppCompatActivity {

    private String receiveorder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);

        final EditText inputMobile = findViewById(R.id.mobile_number);
        final Button getotp = findViewById(R.id.btn_send_otp);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        receiveorder = getIntent().getExtras().get("visit_user_id").toString();
        Toast.makeText(this,"id" +receiveorder,Toast.LENGTH_LONG).show();



        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(abvgiet.college.Libzy.SendOtpActivity.this,"Enter Mobile Number",Toast.LENGTH_SHORT).show();

                }
                progressBar.setVisibility(View.VISIBLE);
                getotp.setVisibility(View.INVISIBLE);


                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+ inputMobile.getText().toString(),60, TimeUnit.SECONDS, abvgiet.college.Libzy.SendOtpActivity.this,new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                getotp.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                getotp.setVisibility(View.VISIBLE);
                                Toast.makeText(abvgiet.college.Libzy.SendOtpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                              progressBar.setVisibility(View.GONE);
                              getotp.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(),VerifyOtpActivity.class);
                                intent.putExtra("mobile",inputMobile.getText().toString());
                                intent.putExtra("verificationId",verificationId);
                                startActivity(intent);
                            }
                        }
                );

            }
        });


    }
}