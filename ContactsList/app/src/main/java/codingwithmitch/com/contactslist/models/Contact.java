package codingwithmitch.com.contactslist.models;

/**
 * Created by User on 6/12/2017.
 */

public class Contact {

    private String name;
    private String phonenumber;
    private String device;
    private String email;
    private String profileImage;

    public Contact(String name, String phonenumber, String device, String email, String profileImage) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.device = device;
        this.email = email;
        this.profileImage = profileImage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", device='" + device + '\'' +
                ", email='" + email + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
