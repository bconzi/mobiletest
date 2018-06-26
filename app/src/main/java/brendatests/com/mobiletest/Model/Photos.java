package brendatests.com.mobiletest.Model;

public class Photos {
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getImageUrl(){

        return "https://randomuser.me/api/portraits/women/"+this.picture;
    }
}
