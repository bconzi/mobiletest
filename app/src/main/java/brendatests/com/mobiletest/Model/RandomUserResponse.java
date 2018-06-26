
package brendatests.com.mobiletest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomUserResponse implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<RandomUser> randomUsers = new ArrayList<RandomUser>();
    public final static Parcelable.Creator<RandomUserResponse> CREATOR = new Creator<RandomUserResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomUserResponse createFromParcel(Parcel in) {
            return new RandomUserResponse(in);
        }

        public RandomUserResponse[] newArray(int size) {
            return (new RandomUserResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1936552642081387758L;

    protected RandomUserResponse(Parcel in) {
        in.readList(this.randomUsers, (randomUsers.getClass().getClassLoader()));
    }

    public RandomUserResponse() {
    }

    public List<RandomUser> getRandomUsers() {
        return randomUsers;
    }

    public void setRandomUsers(List<RandomUser> randomUsers) {
        this.randomUsers = randomUsers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(randomUsers);
    }

    public int describeContents() {
        return  0;
    }

}
