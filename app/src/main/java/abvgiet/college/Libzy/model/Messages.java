package abvgiet.college.Libzy.model;

public class Messages {



    String name;
    String image;
    String author;
    String pages;

    //Constructor

    public Messages() {

    }


    public Messages(String name, String image, String author,String pages) {
        this.name = name;
        this.image = image;
        this.author = author;
        this.pages = pages;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
