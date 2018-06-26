
package brendatests.com.mobiletest.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RandomUser implements Parcelable {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    public final static Parcelable.Creator<RandomUser> CREATOR = new Creator<RandomUser>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RandomUser createFromParcel(Parcel in) {
            return new RandomUser(in);
        }

        public RandomUser[] newArray(int size) {
            return (new RandomUser[size]);
        }

    };
    private final static long serialVersionUID = -5938861517753585496L;

    protected RandomUser(Parcel in) {
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((Name) in.readValue((Name.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.picture = ((Picture) in.readValue((Picture.class.getClassLoader())));
    }

    public RandomUser() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gender);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(picture);
    }

    public int describeContents() {
        return 0;
    }

}
