package abvgiet.college.Libzy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import abvgiet.college.Libzy.module.UserActivity;

public class OrderSuccessMusic extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;
    Animation downtotop,toptodown;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success_music);


        button = findViewById(R.id.go_to_main);
        imageView = findViewById(R.id.animation);
        textView = findViewById(R.id.bkc_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(abvgiet.college.Libzy.OrderSuccessMusic.this, UserActivity.class);
                startActivity(intent);
            }
        });

        downtotop = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_to_top);
        imageView.startAnimation(downtotop);
        toptodown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_to_down);
        textView.startAnimation(toptodown);



        mediaPlayer = MediaPlayer.create(abvgiet.college.Libzy.OrderSuccessMusic.this,R.raw.animals_martingarrix);
        mediaPlayer.start();



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}