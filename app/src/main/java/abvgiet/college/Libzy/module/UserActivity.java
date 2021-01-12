package abvgiet.college.Libzy.module;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import abvgiet.college.Libzy.AboutUs;
import abvgiet.college.Libzy.DevelopedBy;
import abvgiet.college.Libzy.LoginActivity;
import abvgiet.college.Libzy.R;
import abvgiet.college.Libzy.ScanBooks;
import abvgiet.college.Libzy.adapter.MainAdapter;
import abvgiet.college.Libzy.books.Cse_Sem1;
import abvgiet.college.Libzy.books.Cse_Sem2;
import abvgiet.college.Libzy.books.Cse_Sem3;
import abvgiet.college.Libzy.books.Cse_Sem4;
import abvgiet.college.Libzy.books.Cse_Sem5;
import abvgiet.college.Libzy.books.Cse_Sem6;
import abvgiet.college.Libzy.books.Cse_Sem7;
import abvgiet.college.Libzy.books.Cse_Sem8;
import abvgiet.college.Libzy.books.Ece_Sem1;
import abvgiet.college.Libzy.books.Ece_Sem2;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ImageSlider slider;

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;


    FirebaseAuth mAuth;
    FirebaseUser currentUser;


    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
       updateNavHeader();

        drawerLayout = findViewById(R.id.drawer_user);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        slider = findViewById(R.id.Slider);

        List<SlideModel>sliderModels = new ArrayList<>();
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/libzy-b50d2.appspot.com/o/library.jpeg?alt=media&token=a3077eb9-4157-45e2-95e6-9ed168e9055f"));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/libzy-b50d2.appspot.com/o/WhatsApp%20Image%202020-10-20%20at%2016.26.38.jpeg?alt=media&token=424def13-f91f-4a94-9b9b-31f89136406e"));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/libzy-b50d2.appspot.com/o/college_view.jpeg?alt=media&token=a8e9eabe-c94f-4ccd-b56e-522ea291f467"));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/libzy-b50d2.appspot.com/o/college_admin_block.jpg?alt=media&token=3f8272e9-ef56-4fce-b925-4d01566dc995"));
        slider.setImageList(sliderModels,true);


        expandableListView = findViewById(R.id.expandable_listview);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition ==0){

                        if (childPosition ==0 ){
                            Intent i = new Intent(UserActivity.this, Cse_Sem1.class);
                            startActivity(i);


                        }
                    if (childPosition ==1 ){

                        Intent i = new Intent(UserActivity.this, Ece_Sem1.class);
                        startActivity(i);

                    }

                }

                if (groupPosition ==1){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem2.class);
                        startActivity(i);


                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }
                if (groupPosition ==2){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem3.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }
                if (groupPosition ==3){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem4.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }

                if (groupPosition ==4){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem5.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }
                if (groupPosition ==5){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem6.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }

                if (groupPosition ==6){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem7.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }
                if (groupPosition ==7){
                    if (childPosition ==0 ){
                        Intent i = new Intent(UserActivity.this, Cse_Sem8.class);
                        startActivity(i);

                    }
                    if (childPosition ==1 ){
                        Intent i = new Intent(UserActivity.this, Ece_Sem2.class);
                        startActivity(i);

                    }

                }

                return false;
            }
        });
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData();

       /* setSupportActionBar(toolbar);*/


/*
      Timer timer =new Timer();
       timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

            btnLogout = findViewById(R.id.logout_user);

        btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
               Intent intToMain = new Intent(UserActivity.this,MainActivity.class);
                startActivity(intToMain);
            }
       });*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        // Handle navigation view item clicks here.




        switch (item.getItemId()){


            case R.id.about_us:
                Intent intent = new Intent(UserActivity.this, AboutUs.class);
                startActivity(intent);
                return true;

            case R.id.devloped_by:
                Intent intent1 = new Intent(UserActivity.this, DevelopedBy.class);
                startActivity(intent1);


                return true;



        }
        return super.onOptionsItemSelected(item);
    }

    private void initListData() {



        listGroup.add(getString(R.string.group1));
        listGroup.add(getString(R.string.group2));
        listGroup.add(getString(R.string.group3));
        listGroup.add(getString(R.string.group4));
        listGroup.add(getString(R.string.group5));
        listGroup.add(getString(R.string.group6));
        listGroup.add(getString(R.string.group7));
        listGroup.add(getString(R.string.group8));

        String[] array;


        array = getResources().getStringArray(R.array.group1);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));

        array = getResources().getStringArray(R.array.group2);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));

        array = getResources().getStringArray(R.array.group3);
        List<String> list3 = new ArrayList<>(Arrays.asList(array));

        array = getResources().getStringArray(R.array.group4);
        List<String> list4 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.group5);
        List<String> list5 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.group6);
        List<String> list6 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.group7);
        List<String> list7 = new ArrayList<>(Arrays.asList(array));
        array = getResources().getStringArray(R.array.group8);
        List<String> list8 = new ArrayList<>(Arrays.asList(array));

        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        listItem.put(listGroup.get(5),list6);
        listItem.put(listGroup.get(6),list7);
        listItem.put(listGroup.get(7),list8);

        adapter.notifyDataSetChanged();


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.about_us) {

            Intent intent = new Intent(UserActivity.this,AboutUs.class);
            startActivity(intent);
        }
        else if (id ==R.id.log_out){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Sacchi me?")
                    .setCancelable(false)
                    .setMessage("Tussi Jaa Re Ho!!")
                    .setPositiveButton("Hanji", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseAuth.getInstance().signOut();
                            Intent intToMain = new Intent(UserActivity.this, LoginActivity.class);
                            startActivity(intToMain);
                            finish();
                        }
                    })
                    .setNegativeButton("Nahi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

           /**/

        }
        else if (id ==R.id.scan_books){
            Intent intent = new Intent(UserActivity.this, ScanBooks.class);
            startActivity(intent);

        }
        else if (id ==R.id.share){
          Intent intent = new Intent(Intent.ACTION_SEND);
          intent.setType("text/plain");
          String sharbody ="Link of the Application will be here!!";
          intent.putExtra(Intent.EXTRA_TEXT,sharbody);
          startActivity(Intent.createChooser(intent,"Share Using"));

        }
        else if (id ==R.id.site){

            Url("http://www.abvgiet.org/");

        }
        drawerLayout.closeDrawer(GravityCompat.START);
      return true;

    }

    private void Url(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }


    public void updateNavHeader() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_header_user_name);
        TextView navUserMail = headerView.findViewById(R.id.nav_header_user_email);
        ImageView navUserPhoto = headerView.findViewById(R.id.nav_header_user_profile);

        navUserMail.setText(currentUser.getEmail());
        navUsername.setText(currentUser.getDisplayName());

        // now we will use Glide to load user image
        // first we need to import the library


        if (currentUser.getPhotoUrl() !=null){
            Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);
        }
        else
        {
            Glide.with(this).load(R.drawable.userphoto).into(navUserPhoto);
        }






    }


    /*FinishAffinity removes the connection of the existing activity to its stack.
     And then finish helps you exit that activity. Which will eventually exit the application.*/
    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }
}