package vtc.room.a101.mychatapplication.models;

/**
 * Created by HP on 7/16/2018.
 */

public class Message {

    private int imageId;
    private final String message;
    private final boolean isMy;

    public Message(final String message, final boolean isMy) {
        this.message = message;
        this.isMy = isMy;

    }

    public String getMessage() {
        return message;
    }

    public boolean isMy() {
        return isMy;
    }

    public void setImageId(final int imageId) {
        this.imageId = imageId;
    }

    public int getImageId(){
        return imageId;
    }

}
