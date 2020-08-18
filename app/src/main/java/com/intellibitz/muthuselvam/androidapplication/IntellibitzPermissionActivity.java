package com.intellibitz.muthuselvam.androidapplication;

import android.content.pm.PackageManager;
import android.view.View;

import com.intellibitz.muthuselvam.androidapplication.util.MainApplicationSingleton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class IntellibitzPermissionActivity extends
        AppCompatActivity {

    private static final String TAG = "IntellibitzPermission";


    public boolean mayRequestReadContacts(View view) {
        if (IntellibitzActivityFragment.isReadContactsPermissionGranted(getApplicationContext())) {
            return true;
        }
        if (IntellibitzActivityFragment.shouldShowContactsRationale(this)) {
            if (null == view) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                IntellibitzActivityFragment.requestReadContactsPermissions(this);
            } else {
                IntellibitzActivityFragment.showReadContactsSnack(view, this);
            }
        } else {
            // No explanation needed, we can request the permission.
            IntellibitzActivityFragment.requestReadContactsPermissions(this);
        }
        return false;
    }

    public boolean mayRequestReadPhoneState(View view) {
        if (IntellibitzActivityFragment.isReadPhoneStatePermissionGranted(getApplicationContext())) {
            return true;
        }
        if (IntellibitzActivityFragment.shouldShowReadPhoneStateRationale(this)) {
            if (null == view) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                IntellibitzActivityFragment.requestReadPhoneStatePermissions(this);
            } else {
                IntellibitzActivityFragment.showReadPhoneStateSnack(view, this);
            }
        } else {
            // No explanation needed, we can request the permission.
            IntellibitzActivityFragment.requestReadPhoneStatePermissions(this);
        }
        return false;
    }

    public boolean mayRequestCamera(View view) {
        if (IntellibitzActivityFragment.isCameraPermissionGranted(getApplicationContext())) {
            return true;
        }
        if (IntellibitzActivityFragment.shouldShowCameraRationale(this)) {
            if (null == view) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                IntellibitzActivityFragment.requestCameraPermissions(this);
            } else {
                IntellibitzActivityFragment.showCameraSnack(view, this);
            }
        } else {
            // No explanation needed, we can request the permission.
            IntellibitzActivityFragment.requestCameraPermissions(this);
        }
        return false;
    }

    public boolean mayRequestReadExternalStorage(View view) {
        if (IntellibitzActivityFragment.isReadExternalStoragePermissionGranted(getApplicationContext())) {
            return true;
        }
        if (IntellibitzActivityFragment.shouldShowReadStorageRationale(this)) {
            if (null == view) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                IntellibitzActivityFragment.requestReadExternalStoragePermissions(this);
            } else {
                IntellibitzActivityFragment.showReadExternalStorageSnack(view, this);
            }
        } else {
            // No explanation needed, we can request the permission.
            IntellibitzActivityFragment.requestReadExternalStoragePermissions(this);
        }
        return false;
    }

    public boolean mayRequestWriteExternalStorage(View view) {
        if (IntellibitzActivityFragment.isWriteExternalStoragePermissionGranted(getApplicationContext())) {
            return true;
        }
        if (IntellibitzActivityFragment.shouldShowWriteStorageRationale(this)) {
            if (null == view) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                IntellibitzActivityFragment.requestWriteExternalStoragePermissions(this);
            } else {
                IntellibitzActivityFragment.showWriteExternalStorageSnack(view, this);
            }
        } else {
            // No explanation needed, we can request the permission.
            IntellibitzActivityFragment.requestWriteExternalStoragePermissions(this);
        }
        return false;
    }


    protected void onReadExternalStoragePermissionsGranted() {
    }

    protected void onWriteExternalStoragePermissionsGranted() {
    }

    protected void onContactsPermissionsGranted() {
    }

    protected void onPhoneStatePermissionsGranted() {
    }

    protected void onCameraPermissionsGranted() {
    }

    protected void onReadExternalStoragePermissionsDenied() {
    }

    protected void onWriteExternalStoragePermissionsDenied() {
    }

    protected void onContactsPermissionsDenied() {
    }

    protected void onPhoneStatePermissionsDenied() {
    }

    protected void onCameraPermissionsDenied() {
    }


    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == MainApplicationSingleton.PERM_READ_PHONE_STATE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                onPhoneStatePermissionsGranted();
            } else {
                // permission denied, boo! Disable the
                onPhoneStatePermissionsDenied();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        } else if (requestCode == MainApplicationSingleton.PERM_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                onContactsPermissionsGranted();
            } else {
                // permission denied, boo! Disable the
                onContactsPermissionsDenied();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        } else if (requestCode == MainApplicationSingleton.PERM_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                onCameraPermissionsGranted();
            } else {
                // permission denied, boo! Disable the
                onCameraPermissionsDenied();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        } else if (requestCode == MainApplicationSingleton.PERM_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                onReadExternalStoragePermissionsGranted();
            } else {
                // permission denied, boo! Disable the
                onReadExternalStoragePermissionsDenied();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        } else if (requestCode == MainApplicationSingleton.PERM_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                onWriteExternalStoragePermissionsGranted();
            } else {
                // permission denied, boo! Disable the
                onWriteExternalStoragePermissionsDenied();
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
