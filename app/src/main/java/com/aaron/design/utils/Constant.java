/**
 *
 */
package com.aaron.design.utils;


/**
 * app所用到的常量
 *
 * @author Aaron.Liu
 */
public final class Constant {

    public static final String VERSION = "3.9.170302";    //magic window sdk version

    /**
     * http请求响应 *
     */
    public static final String RESULT_SUCCESS = "SUCCESS";
    public static final String RESULT_ERROR = "RESULT_ERROR";

    //    WebViewActivity传值
    public static final String WEB_VIEW_WINDOWKEY = "mw_key";
    public static final String WEB_VIEW_URL = "mw_url";

    //
//    d:           download,在appstore上下载某个app
//    i:            install,开始安装
//    st:          start 统计app时间
//    pv:        view 访问页面
//    c:           click 点击页面上某个BUTTON，图片等
//    ac:	      activity view:访问某个活动
//    sh:	      share,发起一个分享，包括失败的分享，fail写入 tagsSummary字段
//    e:        crash,崩溃信息

    public final static String ACTION_PAGE_TRACKING = "pv";
    public final static String ACTION_APP_LAUNCH = "st";
    public final static String ACTION_AD_IMPRESSION = "i";
    public final static String ACTION_ERROR = "e";//exception
    //c,ac,sh,i
    public final static String ACTION_SOCIAL = "sh";
    public final static String ACTION_CLICK = "c";
    public final static String ACTION_ACTION_VIEW = "ac";
    //    public final static String ACTION_DOWNLOAD = "d";
    public final static String ACTION_CUSTOM = "u";

    public final static String ACTION_MLINK_CLICK = "mc";
    public final static String ACTION_MLINK_INSTALL = "mi";
    public final static String ACTION_MLINK_VIEW = "mv";
    public final static String ACTION_MWB = "mwb";//magic window key used

    public final static String ACTION_ABAB = "abab";//aba back
    public final static String ACTION_ABAC = "abac";//aba cancel
    public final static String ACTION_ABAS = "abas";//aba sucess

    public final static String CUSTOM_KEY = "_k";

    public final static String CHINA_CARRIER_UNKNOWN = "0";
    public final static String CHINA_MOBILE = "1";
    public final static String CHINA_UNICOM = "2";
    public final static String CHINA_TELECOM = "3";
    public final static String CHINA_TIETONG = "4";

    public final static String NETWORK_WIFI = "0";
    public final static String NETWORK_2G = "1";
    public final static String NETWORK_3G = "2";
    public final static String NETWORK_4G = "3";
    public final static String NO_NETWORK = "-1";

    /**
     * ******key    start***********
     */
    //SharedPreferences Key
    public final static String MW_APPID = "MW_APPID";
    public final static String MW_DUMP_KEY = "mw_dump_key"; // 傀儡key，如果没有真正的key时，用此代替

    /**
     * ***********value  end**************
     */
    public final static String MLINK_K = "mw_mlink_k";    //发送方 window id
    public final static String MLINK_AK = "mw_mlink_ak";//发送方 activity key
    public final static String MLINK_APPID = "mw_mlink_appid";    //发送方 App id
    public final static String MW_APP_NAME = "mw_app_name";    //发送方 App name

    public final static String MLINK_KEY = "mw_mk";//tracking p
    public final static String MLINK_SLK = "mw_slk";//tracking p
    public final static String MLINK_CK = "mw_ck"; //channel key tracking p
    public final static String MLINK_TAGS = "mw_tags"; //tracking tags
    public final static String MW_TK = "mw_tk";
    public final static String MW_ULP = "mw_ulp";

    public final static String MLINK_CB = "mw_mlink_cb";
    public final static String MLINK_CP_PREFIX = "mw_cp_";
    public final static String MLINK_DYNP_PREFIX = "mw_dynp_";
    //remove
    public final static String MW_REMOVED = "mw_";

    public final static String MW_CHANNEL = "mw_channel";
    public final static String MW_CRASH = "mw_crash";
    public final static String MW_CUSTOM_WEB_TITLE_BAR = "mw_custom_web_title_bar";
    public final static String MW_WEB_BROADCAST = "mw_web_broadcast";
    public static final String TRACKING_FINGER_PRINTER = "fp";         //finger printer
    public static final String TRACKING_DEVICE_ID = "device_id";         //device_id
    public static final String TRACKING_LBS = "lbs";       //用户终端设备的经纬度地理坐标
    public static final String TRACKING_LATITUDE = "latitude";       //用户终端设备的经纬度地理坐标
    public static final String TRACKING_LONGITUDE = "longitude";       //用户终端设备的经纬度地理坐标
    public static final String TRACKING_FIRST_TIME_ACCESS = "fa";//该设备首次使用sdk时间
    public static final String TRACKING_FIRST_TIME_TAG = "first_time_tag";//该设备首次使用sdk标志位

    public final static String PAGE_TRACKING_START_TIME = "pageTrackingStartTime";
    public final static String APP_LAUNCH_START_TIME = "app_launch_start_time";
    public final static String ACTION_VIEW_TIME_START = "action_view_time_start";
    public final static String CUSTOM_START_TIME = "actionCustomStartTime";
    public final static String CUSTOM_ID = "mw_customId";

    public final static String SP_FIRST_LAUNCH = "sp_first_launch";
    public final static String SP_USER_ID = "sp_user_id";
    public final static String SP_USER_PHONE = "sp_user_phone";
    public final static String SP_USER_EMAIL = "sp_user_email";
    public final static String SP_USER_MD5 = "sp_user_md5";
    public final static String SP_USER_PROFILE = "sp_profile";

    public final static String SP_SESSION_ID = "sp_session_id";
    public final static String SP_SESSION_TIME = "sp_session_time";


    public final static int BACK_GROUND_TIME = 600;//魅族mx5准确值是370,三星s7是550.
    public final static int SESSION_TIME = 1000 * 60 * 5;
    public static String CACHE_DIR = "/mw/images";
    /*********key************/



}
