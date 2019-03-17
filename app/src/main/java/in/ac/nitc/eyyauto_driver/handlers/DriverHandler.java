package in.ac.nitc.eyyauto_driver.handlers;

import android.support.annotation.NonNull;

import in.ac.nitc.eyyauto_driver.models.Driver;

import static in.ac.nitc.eyyauto_driver.Constants.DRIVER_INFO_ROOT_PATH;

public final class DriverHandler extends DatabaseHandler<Driver> {

    @Override
    public void readOnce(@NonNull String uid, @NonNull Event<Driver> event) {
        String path = DRIVER_INFO_ROOT_PATH + uid;
        getDataOnce(path, event);
    }

    @Override
    public void putValue(@NonNull String uid, @NonNull Driver data) {
        String path = DRIVER_INFO_ROOT_PATH + uid;
        putData(path, data);
    }
}
