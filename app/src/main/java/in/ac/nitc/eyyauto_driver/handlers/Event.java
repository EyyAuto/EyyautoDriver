package in.ac.nitc.eyyauto_driver.handlers;

import com.google.firebase.database.DatabaseError;

public interface Event<T> {
    void onReceive(T data);
    void onFailed(DatabaseError databaseError);
}
