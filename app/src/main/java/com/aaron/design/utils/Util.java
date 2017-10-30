package com.aaron.design.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {


    public static final String PACKAGE_OTA = "com.sunmi.ota";
    public static final String PACKAGE_MARKET = "woyou.market";
    public static final String PACKAGE_HARD_WARE_KEEPER = "com.woyou.hardwarekeeper";
    public static final String PACKAGE_UDH = "com.woyou.udh";
    public static final String PACKAGE_SETTING = "com.android.settings";


    private static ProgressDialog mProgressDialog;
    private static String MWAppId;
    private static String MWChannel;

    public static long getCurrentTimeSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static String getCurrentTimeSecondStr() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getMWAppId(Context context) {

        if (Preconditions.isBlank(MWAppId)) {
            MWAppId = getMetaDataFromApplication(context, Constant.MW_APPID);
        }

        return MWAppId;
    }

    public static String getMWChannel(Context context, String tag) {

        if (Preconditions.isBlank(MWChannel)) {
            MWChannel = getMetaDataFromApplication(context, tag);
        }

        return MWChannel;
    }

    /**
     * 读取application 节点  meta-data 信息
     */
    public static String getMetaDataFromApplication(Context context, String tag) {
        String metaData = "";
        if (Preconditions.isBlank(tag)) {
            return "";
        }

        try {
            ApplicationInfo appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                metaData = appInfo.metaData.getString(tag);
                if (Preconditions.isNotBlank(metaData)) {
                    metaData = metaData.trim();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return metaData;
    }

    /**
     * 显示ProgressDialog
     */
    public static void showProgressDialog(final Activity act, String message, final boolean isFinishActivity) {
        dismissDialog();
        mProgressDialog = new ProgressDialog(act);
        // 设置进度条风格，风格为圆形，旋转的
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // 设置ProgressDialog 提示信息
        mProgressDialog.setMessage(message);
        // 设置ProgressDialog 的进度条是否不明确
        mProgressDialog.setIndeterminate(false);
        // 设置ProgressDialog 是否可以按退回按键取消
        mProgressDialog.setCancelable(true);
        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                if (isFinishActivity) {
                    act.finish();
                }
            }
        });
        mProgressDialog.show();
    }

    /**
     * dismiss ProgressDialog
     */
    public static void dismissDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    /**
     * 检查权限是否开启
     *
     * @param permission
     * @return true or false
     */
    public static boolean checkPermissions(Context context, String permission) {

        PackageManager localPackageManager = context.getApplicationContext().getPackageManager();
        return localPackageManager.checkPermission(permission, context.getApplicationContext().getPackageName()) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * dp to px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px to dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static boolean isTimeStamp(String str) {
        if (Preconditions.isBlank(str)) {
            return false;
        }

        Pattern validate = Pattern.compile("([0-9]{10}|[0-9]{13})", Pattern.CASE_INSENSITIVE);
        Matcher m = validate.matcher(str);

        return m.matches();
    }

    public static String getTextWithLanguage(String zh, String en) {
        if ("zh".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return zh;
        } else {
            return en;
        }
    }

    /**
     * 过滤自定义的App和已下载的App
     *
     * @param context
     * @return
     */
   /* public static List<AppInfo> getInstallApp(Context context) {

        List<AppInfo> myAppInfos = new ArrayList<AppInfo>();
        List<AppInfo> mFilterApps = new ArrayList<AppInfo>();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if(packageManager ==null){
            return myAppInfos;
        }

        try {
            List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
            for (int i = 0; i < packageInfos.size(); i++) {
                PackageInfo packageInfo = packageInfos.get(i);
                //过滤指定的app
                String tempPackageName=packageInfo.packageName;
                if(tempPackageName.equals(PACKAGE_OTA)||tempPackageName.equals(PACKAGE_MARKET)||tempPackageName.equals(PACKAGE_HARD_WARE_KEEPER)
                        ||tempPackageName.equals(PACKAGE_UDH)||tempPackageName.equals(PACKAGE_SETTING)){
                    AppInfo appInfo = new AppInfo();
                    appInfo.setAppName((String) packageInfo.applicationInfo.loadLabel(packageManager));
                    if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
                        continue;
                    }
                    appInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
                    mFilterApps.add(appInfo);
                    continue;
                }

                //过滤掉系统app
                if ((ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != 0) {
                    continue;
                }

                AppInfo appInfo = new AppInfo();
                appInfo.setAppName((String) packageInfo.applicationInfo.loadLabel(packageManager));
                if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
                    continue;
                }
                appInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
                myAppInfos.add(appInfo);
            }
            myAppInfos.addAll(mFilterApps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myAppInfos;
    }*/
    public static List<String> getInstallApp(Context context) {

        List<String> myAppInfos = new ArrayList<String>();
        List<String> mFilterApps = new ArrayList<String>();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (packageManager == null) {
            return myAppInfos;
        }

        try {
            List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
            for (int i = 0; i < packageInfos.size(); i++) {
                PackageInfo packageInfo = packageInfos.get(i);
                //过滤指定的app
                String tempPackageName = packageInfo.packageName;
                if (tempPackageName.equals(PACKAGE_OTA) || tempPackageName.equals(PACKAGE_MARKET) || tempPackageName.equals(PACKAGE_HARD_WARE_KEEPER)
                        || tempPackageName.equals(PACKAGE_UDH) || tempPackageName.equals(PACKAGE_SETTING)) {
//                    AppInfo appInfo = new AppInfo();
//                    appInfo.setAppName((String) packageInfo.applicationInfo.loadLabel(packageManager));
//                    if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
//                        continue;
//                    }
//                    appInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
                    mFilterApps.add((String) packageInfo.applicationInfo.loadLabel(packageManager));
                    continue;
                }

                //过滤掉系统app
                if ((ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != 0) {
                    continue;
                }

//                AppInfo appInfo = new AppInfo();
//                appInfo.setAppName((String) packageInfo.applicationInfo.loadLabel(packageManager));
//                if (packageInfo.applicationInfo.loadIcon(packageManager) == null) {
//                    continue;
//                }
//                appInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
                myAppInfos.add((String) packageInfo.applicationInfo.loadLabel(packageManager));
            }
            myAppInfos.addAll(mFilterApps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myAppInfos;
    }

    public static List<String> getAppList(Context context) {
        PackageManager pm = context.getPackageManager();
        List<String> myAppInfos = new ArrayList<String>();

        // Return a List of all packages that are installed on the device.
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo packageInfo : packages) {
            // 判断系统/非系统应用
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) // 非系统应用
            {
//                AppInfo info = new AppInfo();
//                info.appName = packageInfo.applicationInfo.loadLabel(pm)
//                        .toString();
//                info.pkgName = packageInfo.packageName;
//                info.appIcon = packageInfo.applicationInfo.loadIcon(pm);
                // 获取该应用安装包的Intent，用于启动该应用
//                info.appIntent = pm.getLaunchIntentForPackage(packageInfo.packageName);
                myAppInfos.add(packageInfo.applicationInfo.packageName);
                Log.e("SplashActivity", "applist:" + packageInfo.applicationInfo.packageName);
            } else {
                // 系统应用　　　　　　　　
            }

        }
        return myAppInfos;
    }

    /**
     * 防止内部Handler类引起内存泄露
     *
     * @author Tony Shen
     */
    public static class MyHandler extends Handler {
        private final WeakReference<Context> mContext;

        public MyHandler(Context context) {
            mContext = new WeakReference<Context>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mContext.get() == null) {
                return;
            }
        }
    }
}
