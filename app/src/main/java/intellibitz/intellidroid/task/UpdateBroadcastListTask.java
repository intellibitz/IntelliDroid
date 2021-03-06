package intellibitz.intellidroid.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import intellibitz.intellidroid.util.HttpUrlConnectionParser;
import intellibitz.intellidroid.util.MainApplicationSingleton;
import intellibitz.intellidroid.data.ContactItem;
import intellibitz.intellidroid.util.HttpUrlConnectionParser;
import intellibitz.intellidroid.util.MainApplicationSingleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 */
public class UpdateBroadcastListTask extends AsyncTask<Void, Void, Boolean> {
    private static final String TAG = "UpdateBroadcastListTask";
    private UpdateBroadcastListTaskListener groupsAddUsersTaskListener;
    private ContactItem contactItem;
    private String uid;
    private String token;
    private String device = "android";
    private String deviceRef;
    private String url;
    private JSONObject response;

    public UpdateBroadcastListTask(ContactItem contactItem,
                                   String uid, String token, String device,
                                   String deviceRef, String url) {
        this.contactItem = contactItem;
        this.uid = uid;
        this.token = token;
        this.device = device;
        this.url = url;
        this.deviceRef = deviceRef;
    }

    public void setUpdateBroadcastListTaskListener(UpdateBroadcastListTaskListener groupsAddUsersTaskListener) {
        this.groupsAddUsersTaskListener = groupsAddUsersTaskListener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        if (null == contactItem) return false;
        if (TextUtils.isEmpty(contactItem.getDataId())) return false;
        if (TextUtils.isEmpty(contactItem.getName())) return false;
        JSONArray jsonArray = contactItem.getContactsAsJsonObjectArray();
        if (null == jsonArray || 0 == jsonArray.length()) return false;

        // TODO: attempt authentication against a network service.
        HashMap<String, String> data = new HashMap<>();
        data.put(MainApplicationSingleton.DEVICE_PARAM, device);
        data.put(MainApplicationSingleton.DEVICE_REF_PARAM, deviceRef);
        data.put(MainApplicationSingleton.UID_PARAM, uid);
        data.put(MainApplicationSingleton.TOKEN_PARAM, token);

        data.put(MainApplicationSingleton.NAME_PARAM, contactItem.getName());
        data.put("broadcast_id", contactItem.getDataId());
        data.put("users", jsonArray.toString());
        // params comes from the execute() call: params[0] is the url.
        response = HttpUrlConnectionParser.postHTTP(url, data);
        return null != response;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
//        groupsAddUsersTask = null;
        groupsAddUsersTaskListener.setUpdateBroadcastListTaskToNull();
        if (success) {
            groupsAddUsersTaskListener.onPostUpdateBroadcastListExecute(response, contactItem);
        } else {
            groupsAddUsersTaskListener.onPostUpdateBroadcastListExecuteFail(response, contactItem);
        }
    }

    @Override
    protected void onCancelled() {
//        groupsAddUsersTask = null;
        groupsAddUsersTaskListener.setUpdateBroadcastListTaskToNull();
    }

    public interface UpdateBroadcastListTaskListener {
        void onPostUpdateBroadcastListExecute(JSONObject response,
                                              ContactItem contactItem);

        void onPostUpdateBroadcastListExecuteFail(JSONObject response,
                                                  ContactItem contactItem);

        void setUpdateBroadcastListTaskToNull();
    }

}
