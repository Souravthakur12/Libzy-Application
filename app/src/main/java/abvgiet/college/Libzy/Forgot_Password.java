package abvgiet.college.Libzy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password extends AppCompatActivity {

    EditText email;
    Button button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        email = findViewById(R.id.FP_EmailAddress);
        button = findViewById(R.id.FP_Send_Button);


        auth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fpemail = email.getText().toString().trim();

                if (TextUtils.isEmpty(fpemail)){
                    Toast.makeText(abvgiet.college.Libzy.Forgot_Password.this,"Please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(fpemail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(abvgiet.college.Libzy.Forgot_Password.this,"Reset Link Sent To Your Email",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(abvgiet.college.Libzy.Forgot_Password.this,LoginActivity.class);
                        startActivity(intent);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(abvgiet.college.Libzy.Forgot_Password.this,"Error! Reset Link is Not Sent" +e.getMessage(),Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });


    }
}