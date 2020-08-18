package com.intellibitz.muthuselvam.androidapplication.content.task;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.intellibitz.muthuselvam.androidapplication.IntellibitzAsyncTask;
import com.intellibitz.muthuselvam.androidapplication.content.MsgsGrpPeopleChatsContentProvider;
import com.intellibitz.muthuselvam.androidapplication.data.MessageItem;
import com.intellibitz.muthuselvam.androidapplication.db.MessageItemColumns;

import java.util.ArrayList;

/**
 */
public class FetchMsgsGrpPeopleChatsTask extends
        IntellibitzAsyncTask {

    private static final String TAG = "MsgsGrpPeopleChatTask";

    private FetchMsgsGrpPeopleTaskListener fetchMsgsGrpPeopleTaskListener;
    private String filter;
    private ArrayList<MessageItem> messageItems;

    public FetchMsgsGrpPeopleChatsTask(String filter, Context context) {
        super(context);
        this.filter = filter;
    }

    public void setFetchMsgsGrpPeopleTaskListener(
            FetchMsgsGrpPeopleTaskListener fetchMsgsGrpPeopleTaskListener) {
        this.fetchMsgsGrpPeopleTaskListener = fetchMsgsGrpPeopleTaskListener;
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        String selection = " ( " +
//                    "mt." +
                MessageItemColumns.KEY_SUBJECT +
                " IS NULL OR " +
//                    "mt." +
                MessageItemColumns.KEY_SUBJECT +
                " like ? ) ";
        String[] selArgs;
        if (filter != null && !filter.isEmpty()) {
            selArgs = new String[]{"%" + filter + "%"};
        } else {
            selArgs = new String[]{"%%"};
        }
        Context context = this.context.get();
        if (null == context) {
            Log.e(TAG, "Context is null - stopping task");
            return false;
        }
//            Log.d(TAG, "FILTER: " + filter + " " + selArgs + " " + selection);
        Cursor cursor = context.getContentResolver().query(
//                    MsgsGrpPeopleContentProvider.JOIN_CONTENT_URI,
                MsgsGrpPeopleChatsContentProvider.CONTENT_URI,
                null,
                selection, selArgs,
//                    "mt." + MessageItemColumns.KEY_TIMESTAMP +
                MessageItemColumns.KEY_TIMESTAMP +
                        " DESC"
//                            " DESC LIMIT 10"
/*
// applies if message is joined.. NA in this case, since its only a shal group join.. no messages joined
                            +
                            "," +
                            "m." + DatabaseHelper.MessagesMessageJoinColumns.KEY_TIMESTAMP +
                            " ASC"
*/
        );
        if (cursor != null && cursor.getCount() > 0) {
            messageItems = MsgsGrpPeopleChatsContentProvider.fillMessageThreadItemsFromCursor(cursor);
//            messageItems.addAll(messageItem.getMessages());
        }
        if (cursor != null) cursor.close();
        return messageItems != null && !messageItems.isEmpty();
    }

    @Override
    protected void onPostExecute(final Object result) {
        super.onPostExecute(result);
        if (success) {
            fetchMsgsGrpPeopleTaskListener.onFetchMsgsGrpPeopleTaskExecute(messageItems);
        } else {
            fetchMsgsGrpPeopleTaskListener.onFetchMsgsGrpPeopleTaskExecuteFail(messageItems);
        }
        releaseContext();
    }

    @Override
    protected void onCancelled() {
        fetchMsgsGrpPeopleTaskListener.onFetchMsgsGrpPeopleTaskExecuteFail(messageItems);
        releaseContext();
    }

    public interface FetchMsgsGrpPeopleTaskListener {
        void onFetchMsgsGrpPeopleTaskExecute(ArrayList<MessageItem> messageItem);

        void onFetchMsgsGrpPeopleTaskExecuteFail(ArrayList<MessageItem> messageItem);
    }
}
