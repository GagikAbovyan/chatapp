package vtc.room.a101.mychatapplication.models;


import java.util.ArrayList;
import java.util.List;

public class User {
    private final int imageId;
    private final String name;
    private final String status;
    private String tel;
    private String email;
    private boolean useApple;
    private List<Message> list = new ArrayList<>();

    public User(final int imageId, final String name,
                final String status) {
        this.imageId = imageId;
        this.name = name;
        this.status = status;

    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setUseApple(final boolean useApple) {
        this.useApple = useApple;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUseApple() {
        return useApple;
    }

    public void addMessage(final Message message){
        list.add(message);
    }

    public Message getMessage(final int position){
        return list.get(position);
    }

    public int myMessageSize(){
        return list.size();
    }

    public List<Message> getList() {
        return list;
    }
}
