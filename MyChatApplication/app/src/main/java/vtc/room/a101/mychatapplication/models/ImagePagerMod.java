package vtc.room.a101.mychatapplication.models;

public class ImagePagerMod {

    private final int imageId;
    private final String name;

    public ImagePagerMod(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

}
