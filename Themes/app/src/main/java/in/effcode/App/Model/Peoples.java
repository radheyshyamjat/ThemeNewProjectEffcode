package in.effcode.App.Model;

/**
 * Created by Radhey on 31/5/18.
 * Author Radhey
 */

public class Peoples {
    private int imageId;
    private String name;
    private boolean followStatus;

    public Peoples() {
    }

    public Peoples(int imageID, String name, boolean followStatus) {
        this.imageId = imageID;
        this.name = name;
        this.followStatus = followStatus;
    }

    public int getProfilePhoto() {
        return imageId;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.imageId= profilePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(boolean followStatus) {
        this.followStatus = followStatus;
    }

    @Override
    public String toString() {
        return "Peoples{" +
                "profilePhoto='" + imageId + '\'' +
                ", name='" + name + '\'' +
                ", followStatus=" + followStatus +
                '}';
    }
}
