package e.apple.cue;

import android.graphics.Bitmap;

public class DataModel {

    String name;
    String version;
    int id_;
    String image;

    public DataModel(String name, String version, int id_, String  image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}
