package abvgiet.college.Libzy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_Order_Sucess extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__order__sucess);

        mediaPlayer = MediaPlayer.create(abvgiet.college.Libzy.User_Order_Sucess.this,R.raw.music3);
        mediaPlayer.start();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(abvgiet.college.Libzy.User_Order_Sucess.this, abvgiet.college.Libzy.OrderSuccessMusic.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }


    @Override
    protected void onPause() {
        mediaPlayer.release();
        super.onPause();
    }
}