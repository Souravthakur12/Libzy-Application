package abvgiet.college.Libzy;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import abvgiet.college.Libzy.module.UserActivity;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanBooks extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView xingScannerView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_books);

    xingScannerView = findViewById(R.id.zxscan);
    textView = findViewById(R.id.txt_result);


    // Request permission
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        xingScannerView.setResultHandler(abvgiet.college.Libzy.ScanBooks.this);
                        xingScannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                        Toast.makeText(abvgiet.college.Libzy.ScanBooks.this,"You myst accept this permission ",Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                })
                .check();


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(abvgiet.college.Libzy.ScanBooks.this, UserActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        xingScannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        //Here we can receive raw results
        textView.setText(rawResult.getText());
        xingScannerView.resumeCameraPreview(abvgiet.college.Libzy.ScanBooks.this);

    }
}