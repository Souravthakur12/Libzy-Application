package abvgiet.college.Libzy.model;

public class UserInfo {

    String user_name;
    String stream;
    String phone_no;
    String roll_no;
    String id;

    public UserInfo() {
    }

    public UserInfo(String user_name, String stream, String phone_no, String roll_no,String id) {
        this.user_name = user_name;
        this.stream = stream;
        this.phone_no = phone_no;
        this.roll_no = roll_no;
        this.id = id;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}