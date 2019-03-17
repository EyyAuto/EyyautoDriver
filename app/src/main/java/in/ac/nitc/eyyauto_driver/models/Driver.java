package in.ac.nitc.eyyauto_driver.models;

import java.io.Serializable;

public class Driver implements Serializable {
    private String Name;
    private String Contact;

    // Required according to firebase documentation https://firebase.google.com/docs/database/android/read-and-write
    public Driver() {
    }

    public Driver(String name, String contact) {
        Name = name;
        Contact = contact;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }
}
