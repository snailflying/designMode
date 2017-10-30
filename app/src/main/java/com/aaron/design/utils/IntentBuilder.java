package com.aaron.design.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Map;

public class IntentBuilder {

    public static void buildIntent(Context context, Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void buildIntent(Context context, Class clazz) {
        buildIntent(null, context, clazz);
    }

    /**
     * 跳转辅助方法
     *
     * @param routeParameters 对应execute回调内的 paramMap
     * @param context         对应execute回调内的 context
     * @param clazz           需要跳转到的类以初始化Intent
     */
    public static void buildIntent(Map<String, String> routeParameters, Context context, Class
            clazz) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }

        if (context.getClass().equals(clazz)) {
            return;
        }

        Intent intent = new Intent(context, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (Preconditions.isNotBlank(routeParameters)) {
            for (Map.Entry<String, String> param : routeParameters.entrySet()) {
                intent.putExtra(param.getKey(), param.getValue());
            }
        }
        context.startActivity(intent);
    }
}