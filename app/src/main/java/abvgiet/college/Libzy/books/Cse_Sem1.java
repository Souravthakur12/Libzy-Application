package abvgiet.college.Libzy.books;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import abvgiet.college.Libzy.R;
import abvgiet.college.Libzy.adapter.Semester1;


public class Cse_Sem1 extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_sem1);

        listView = findViewById(R.id.listView);

         final ArrayList<String> list = new ArrayList<>();
         final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.lists_items,list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Information");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Semester1 info = snapshot.getValue(Semester1.class);
                    String txt = info.getName() +" : " + info.getEmail();
                   list.add(txt);

                 /*   Semester1 info = snapshot.getValue(Semester1.class);
                    String txt = info.getName();
                    list.add(txt);
                 snapshot.child("Cse_Sem1").getValue(Semester1.class);
                   ;*/

                }
                adapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}