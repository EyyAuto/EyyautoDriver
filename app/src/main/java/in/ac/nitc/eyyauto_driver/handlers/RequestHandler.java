package in.ac.nitc.eyyauto_driver.handlers;

import android.support.annotation.NonNull;

import com.google.firebase.database.Transaction;

import java.util.Map;

import in.ac.nitc.eyyauto_driver.models.Request;

import static in.ac.nitc.eyyauto_driver.Constants.REQUEST_ROOT_PATH;

public final class RequestHandler extends DatabaseHandler<Map<String, Request>> {
    public String[] getKeys(Map<String,Request> data) {
        return (String[]) data.keySet().toArray();
    }

    public void doTransaction(String key, Transaction.Handler handler) {
        String path = REQUEST_ROOT_PATH + key;
        putDataAsTransaction(path,handler);
    }

    @Override
    public void readOnce(@NonNull String uid, @NonNull Event<Map<String, Request>> event) {
        String path = REQUEST_ROOT_PATH + uid;
        getDataOnce(path,event);
    }

    @Override
    public void putValue(@NonNull String uid, @NonNull Map<String, Request> data) {

    }
}
