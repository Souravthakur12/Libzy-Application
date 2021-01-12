package abvgiet.college.Libzy.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Random;

import abvgiet.college.Libzy.ItemClickListener;
import abvgiet.college.Libzy.ProgressDialog;
import abvgiet.college.Libzy.R;
import abvgiet.college.Libzy.SendOtpActivity;
import abvgiet.college.Libzy.User_Order_Sucess;
import abvgiet.college.Libzy.model.Messages;
import abvgiet.college.Libzy.model.PDFModel;
import abvgiet.college.Libzy.model.UserInfo;


public class BookAdapter extends FirebaseRecyclerAdapter<Messages, BookAdapter.BookViewHolder> {


    FirebaseDatabase rootnode;
    DatabaseReference reference;
    Context mContext ;

    LottieAnimationView progressbar;
    ProgressDialog progressBar;

    private String lastClickedItemPosition;

    private List<PDFModel> list;
    ItemClickListener itemClickListener;



    public BookAdapter(@NonNull FirebaseRecyclerOptions<Messages> options, Context mContext, List<PDFModel> list, ItemClickListener itemClickListener) {
        super(options);
        this.mContext = mContext;
        this.itemClickListener = itemClickListener;
        this.list = list;


    }

    @Override
    protected void onBindViewHolder(@NonNull BookViewHolder holder, final int position, @NonNull Messages model) {

        //TextView



        holder.textView.setText(model.getName());
        holder.textView1.setText(model.getAuthor());
        holder.textView2.setText(model.getPages());




        Glide.with(holder.imageView.getContext()).load(model.getImage()).fitCenter().into(holder.imageView);





        //ImageView
       /* Glide.with(holder.imageView.getContext())
                .load(model.getImageUrl())
                .into(holder.imageView);*/
/*

        holder.itemView.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {



                Context context = v.getContext();
                Intent intent = new Intent(context, BookDetailsActivity.class);
                context.startActivity(intent);








            }
        });
*/

    }

    // Use this method to get lastClickedItemPosition
    public String getLastClickedItemPosition() {
        return lastClickedItemPosition;
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);

    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        //widgets
        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;
        Button Order_button,Submit_button,dialogButton;
        private Context context;
        ProgressBar progressBar;

        TextView User_name,Stream,Phone_no,Roll_no;




        public BookViewHolder(@NonNull final View itemView) {

            super(itemView);
            Submit_button = itemView.findViewById(R.id.submit_button);
            Order_button = itemView.findViewById(R.id.order_button);
            imageView = itemView.findViewById(R.id.item_book_img);
            textView = itemView.findViewById(R.id.item_book_title);
            textView1 = itemView.findViewById(R.id.item_book_author);
            textView2 = itemView.findViewById(R.id.item_book_pagesrev);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemClickListener.onClick(v,getAdapterPosition(),false);
                }
            });






            Order_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                    context = itemView.getContext();

                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.order_user_info);
                    dialog.setCancelable(false);

                    User_name = dialog.findViewById(R.id.name_user);
                    Stream = dialog.findViewById(R.id.stream);
                    Roll_no = dialog.findViewById(R.id.roll_no);


                    textView = itemView.findViewById(R.id.item_book_title);
                    Phone_no = itemView.findViewById(R.id.mobile_number);


                    Button dialogButton = (Button) dialog.findViewById(R.id.submit_button);
                    ImageView imageView2 = (ImageView) dialog.findViewById(R.id.close_window);
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialogButton.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            rootnode = FirebaseDatabase.getInstance();
                            reference = rootnode.getReference().child("Orders");

                            EditText emailId;

                            emailId = dialog.findViewById(R.id.email);


                            if (TextUtils.isEmpty(User_name.getText().toString()) ||TextUtils.isEmpty(Stream.getText().toString()) || TextUtils.isEmpty(Roll_no.getText().toString()) ){

                                Toast.makeText(context,"Please! Fill the Missing Details ",Toast.LENGTH_SHORT).show();

                            }else {
                                UserInfo userInfo = new UserInfo();

                                Random rand = new Random();
                                int n = rand.nextInt(5);
                                String w = "USER";

                      //          Phone_no.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});

                          //      if (isValidPhone(Phone_no.getText().toString())){

                                    userInfo.setUser_name(User_name.getText().toString());
                                    userInfo.setStream(Stream.getText().toString());
                               //     userInfo.setPhone_no(Phone_no.getText().toString());
                                    userInfo.setRoll_no(Roll_no.getText().toString());
                                    userInfo.setId(textView.getText().toString());


                                    reference.child("abc").child(String.valueOf(n + w)).setValue(userInfo);

                                    String visit_user_id = getRef(getAdapterPosition()).getKey();
                                    Context context = v.getContext();
                                    Intent intent = new Intent(context, SendOtpActivity.class);
                                    intent.putExtra("visit_user_id",visit_user_id);
                                    context.startActivity(intent);

                            //    }
                            /*    else {
                                    Toast.makeText(context,"wrong phone number",Toast.LENGTH_SHORT).show();

                                }*/



                            }



                        }
                    });
                    dialog.show();


                   /* Context context = v.getContext();
                    Intent intent = new Intent(context, User_Order_Details.class);
                    context.startActivity(intent);*/


                }
            });




        }







    }

    private boolean isValidPhone(String toString) {
      boolean check = false;

          if (toString.length() != 10){
              check = false;
          }
          else {
              check = true;
          }


       return check;
    }

}
