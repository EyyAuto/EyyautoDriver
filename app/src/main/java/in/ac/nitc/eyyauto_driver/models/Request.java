package in.ac.nitc.eyyauto_driver.models;

import com.google.android.gms.maps.model.LatLng;

public class Request {
    private String uid;
    private String did;
    private LatLng pickup;
    private LatLng dropoff;

    public Request(){
    }

    public String getDid() {
        return did;
    }

    public String getUid() {
        return uid;
    }

    public LatLng getDropoff() {
        return dropoff;
    }

    public LatLng getPickup() {
        return pickup;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public void setDropoff(LatLng dropoff) {
        this.dropoff = dropoff;
    }

    public void setPickup(LatLng pickup) {
        this.pickup = pickup;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
