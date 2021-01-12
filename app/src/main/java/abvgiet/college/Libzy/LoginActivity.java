package abvgiet.college.Libzy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

import java.util.HashMap;

import abvgiet.college.Libzy.module.AdminActivity;
import abvgiet.college.Libzy.module.UserActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText emailId, pass;
    private TextView forgetpass;
   private Button btn;
    private FirebaseAuth mAuth;

    View daysky,nightsky,boyday,boynight;
    ImageView day,night;
    DayNightSwitch dayNightSwitch;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        day = findViewById(R.id.day_landscape);
        night = findViewById(R.id.night_landscape);
        daysky = findViewById(R.id.day_bg);
        nightsky = findViewById(R.id.night_bg);
        boyday = findViewById(R.id.boy_day);
        boynight = findViewById(R.id.boy_night);
        dayNightSwitch = findViewById(R.id.day_night_button);


        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_day) {
                if (is_day){
                    day.animate().alpha(0).setDuration(1300);
                    boyday.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);

                }
                else {
                    day.animate().alpha(1).setDuration(1300);
                    boyday.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);

                }
            }
        });


        mAuth = FirebaseAuth.getInstance();


        emailId = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        forgetpass = findViewById(R.id.Fp_pass);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(abvgiet.college.Libzy.LoginActivity.this, abvgiet.college.Libzy.Forgot_Password.class);
                startActivity(i);
            }
        });



        btn =  findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailId.getText().toString().trim();
                String pwd = pass.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(abvgiet.college.Libzy.LoginActivity.this,"Please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(abvgiet.college.Libzy.LoginActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(abvgiet.college.Libzy.LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
                                    if (currentFirebaseUser.getUid().equals("ByoNtJI1PCQOlPrUK8yXvurY4Z02")){
                                           Intent intToAdmin = new Intent(abvgiet.college.Libzy.LoginActivity.this, AdminActivity.class);
                                         startActivity(intToAdmin);

                                    }else {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        String email = user.getEmail();
                                        String uid = user.getUid();

                                        HashMap<Object,String>hashMap = new HashMap<>();
                                        hashMap.put("email",email);
                                        hashMap.put("name","");
                                        hashMap.put("phone","");
                                        hashMap.put("rollno","");
                                        hashMap.put("stream","");

                                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                                        DatabaseReference reference = database.getReference("Users");
                                        reference.child(uid).setValue(hashMap);
                                        Intent intToAdmin = new Intent(abvgiet.college.Libzy.LoginActivity.this, abvgiet.college.Libzy.Edit_User_Details.class);
                                        startActivity(intToAdmin);
                                        finish();


                                    }


                                } else {
                                  Toast.makeText(abvgiet.college.Libzy.LoginActivity.this,"it is invalid",Toast.LENGTH_SHORT).show();

                               }

                            }
                        });







            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,

                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
       getWindow().setStatusBarColor(Color.TRANSPARENT);




    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null ){

            Intent intent = new Intent(abvgiet.college.Libzy.LoginActivity.this, UserActivity.class);
            startActivity(intent);
            finish();
        }
    }
}