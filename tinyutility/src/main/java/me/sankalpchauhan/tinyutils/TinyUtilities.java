package me.sankalpchauhan.tinyutils;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUtilities {
    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm@$#";

    //GENERIC DISPLAY DIALOG
    public void DisplayDialog(Context context, String title, String message, String posText) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title).setMessage(message).setPositiveButton(posText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }

    //GENERIC TOAST
    public void StandardToast(Context context, String Message) {
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

    //Custom Toast with Image
    public void ImageInToast(Context context, String Message, int ImageId) {
        Toast toast = Toast.makeText(context, Message, Toast.LENGTH_SHORT);
        LinearLayout toastContentView = (LinearLayout) toast.getView();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(ImageId);
        toastContentView.addView(imageView, 0);
        toast.show();

    }

    //CHECK NETWORK STATE----------------------------------------------------------------------------------------------------------------------
    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();
        Log.i("NetworkState", "isConnected checking network state.......");
        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }

    //Notification Builder
    public void addNotification(Context mContext, String title, String subject, int Imageid, int ID) {
        Notification noti = new Notification.Builder(mContext)
                .setContentTitle(title)
                .setContentText(subject)
                .setSmallIcon(Imageid)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setCategory(Notification.CATEGORY_REMINDER)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(ID, noti);
    }

    public ProgressDialog mProgressDialog;

    public void showProgressDialog(Context context, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(message);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }


    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    //Shared Preferences
    public void saveDataToSharedPrefs(Context context, String nameOfSharedPreference, HashMap<String, String> userDetails) {
        SharedPreferences sharedPref = context.getSharedPreferences(nameOfSharedPreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor shareEdit = sharedPref.edit();
        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            shareEdit.putString(entry.getKey(), entry.getValue());
            Log.e("SHAREPREF", entry.getKey() + " " + entry.getValue());
        }
        Log.e("SHAREPREF", "Save Successful");
        shareEdit.apply();
    }

    public HashMap<String, String> getDataFromSharePrefs(Context context, String nameOfSharedPreference) {
        SharedPreferences sharedPref = context.getSharedPreferences(nameOfSharedPreference, Context.MODE_PRIVATE);
        Map<String, ?> s1 = sharedPref.getAll();

        return (HashMap<String, String>) s1;
    }

    public void validPhoneNumbercheck(final EditText editText) {
        editText.setText("+91");
        Selection.setSelection(editText.getText(), editText.getText().length());


        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().startsWith("+91")) {
                    editText.setText("+91");
                    Selection.setSelection(editText.getText(), editText.getText().length());

                }

            }
        });
    }


    private static String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }


    public static Spanned fromHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }


}
