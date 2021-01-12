package abvgiet.college.Libzy.books;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import abvgiet.college.Libzy.ItemClickListener;
import abvgiet.college.Libzy.adapter.BookAdapter;
import abvgiet.college.Libzy.model.Messages;
import abvgiet.college.Libzy.model.PDFModel;
import abvgiet.college.Libzy.R;


public class Ece_Sem1 extends AppCompatActivity {

    RecyclerView recyclerView;



    //Variables
    private BookAdapter adapter;

    public static List<PDFModel> list;
    ItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece_sem1);

        recyclerView = findViewById(R.id.recycler_view);

        FirebaseRecyclerOptions<Messages> options =
                new FirebaseRecyclerOptions.Builder<Messages>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ece_Sem1"), Messages.class)
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
       /* final ProgressDialog mDialog = new ProgressDialog(Ece_sem1.this);
        mDialog.dismiss();*/
        super.onStop();
        adapter.stopListening();
    }



}