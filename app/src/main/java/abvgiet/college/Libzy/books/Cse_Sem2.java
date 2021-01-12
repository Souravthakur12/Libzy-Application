package abvgiet.college.Libzy.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import abvgiet.college.Libzy.ItemClickListener;
import abvgiet.college.Libzy.PDFActivity;
import abvgiet.college.Libzy.ProgressDialog;
import abvgiet.college.Libzy.R;
import abvgiet.college.Libzy.adapter.BookAdapter;
import abvgiet.college.Libzy.model.Messages;
import abvgiet.college.Libzy.model.PDFModel;

public class Cse_Sem2 extends AppCompatActivity {


    RecyclerView recyclerView;
    LottieAnimationView progressBar;




    //Variables
    private BookAdapter adapter;

    private ProgressDialog progressDialog;
    public static List<PDFModel> list;
    ItemClickListener itemClickListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sem2);

        //;

        progressDialog= new ProgressDialog(this);



        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);



        list = new ArrayList<>();
        list.add(new PDFModel("PDF One","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));
        list.add(new PDFModel("PDF Two", "https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));
        list.add(new PDFModel("PDF Three","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        list.add(new PDFModel("PDF Four","http://www.africau.edu/images/default/sample.pdf"));
        list.add(new PDFModel("PDF Five",""));
        list.add(new PDFModel("PDF Six",""));
        list.add(new PDFModel("PDF Seven","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));


        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Cse_Sem2.this, PDFActivity.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        FirebaseRecyclerOptions<Messages> options =
                new FirebaseRecyclerOptions.Builder<Messages>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Cse_Sem1"), Messages.class)
                        .build();
        adapter = new BookAdapter(options,this,list,itemClickListener);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);




    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}