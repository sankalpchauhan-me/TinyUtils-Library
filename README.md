![Android](https://img.shields.io/badge/platform-Android-green.svg)
![Build](https://img.shields.io/badge/build-passing-green.svg)
![Dependencies](https://img.shields.io/hackage-deps/v/lens.svg)
![Version](https://img.shields.io/badge/version-0.1-green)
![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)
![Issues](https://img.shields.io/github/issues/sankalpchauhan-me/TinyUtils-Library)

# TinyUtils-Library
A tiny library with tiny utilities

## How to use
https://jitpack.io/#sankalpchauhan-me/TinyUtils-Library/Tag

## Methods
#### GENERIC DISPLAY DIALOG
- TinyUtilities.DisplayDialog(Context context, String title, String message, String posText)
#### GENERIC TOAST
- TinyUtilities.StandardToast(Context context, String Message)
#### Custom Toast with Image
- TinyUtilities.ImageInToast(Context context, String Message, int ImageId)
#### CHECK NETWORK STATE
- TinyUtilities.isConnected(Context context)
#### Notification Builder
- TinyUtilities.addNotification(Context mContext, String title, String subject, int Imageid, int ID)
#### ProgressDialog
- TinyUtilities.showProgressDialog(Context context, String message)
- TinyUtilities.hideProgressDialog()
#### Shared Preferences
- TinyUtilities.saveDataToSharedPrefs(Context context, String nameOfSharedPreference, HashMap<String, String> mapDetails)
- TinyUtilities.getDataFromSharePrefs(Context context, String nameOfSharedPreference)
#### Valid Phone Text Watcher (only "+91" supported will extend support in future if required)
- TinyUtilities.validPhoneNumbercheck(final EditText editText)
#### Random String Generator
- TinyUtilities.getRandomString(final int sizeOfRandomString)
#### HTML Text Setter
- TinyUtilities.fromHtml(String html)

## License
This library is released under Apache 2.0 you can use and modify this library at your own will. Consider contributing and raising a issue if you find one. Cheers!
