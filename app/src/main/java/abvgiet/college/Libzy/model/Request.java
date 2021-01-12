package abvgiet.college.Libzy.model;

public class Request {
        private String name;
        private String stream;
        private String phone_no;
        private String roll_no;

    public Request() {
    }


    public Request(String name, String stream, String phone_no, String roll_no) {
        this.name = name;
        this.stream = stream;
        this.phone_no = phone_no;
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
