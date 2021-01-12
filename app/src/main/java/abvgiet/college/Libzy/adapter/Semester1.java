package abvgiet.college.Libzy.adapter;

import android.widget.ImageView;

public class Semester1 {
    private String name;
    private String email;
    private ImageView imageView;

    public Semester1() {
    }


    public Semester1(String name, String email, ImageView imageView) {
        this.name = name;
        this.email = email;
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
