package com.aaron.design.utils;


import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author Tony Shen
 * @date 15/11/12
 */
public class Preconditions {

    /**
     * 可以判断任何一个对象是否为空,包括List Map String 复杂对象等等,
     * 即使对象是null也是安全的
     *
     * @param t 泛型参数
     * @param <T> 泛型参数
     * @return 如果对象为Null或者对象长度为0则为空
     */
    public static <T> boolean isBlank(T t) {

        if (t == null) {
            return true;
        }

        if (t instanceof List) {
            if (((List) t).size() == 0) {
                return true;
            }
        } else if (t instanceof Map) {
            if (((Map) t).size() == 0) {
                return true;
            }
        } else if (t instanceof JSONObject) {
            if (((JSONObject) t).length() == 0) {
                return true;
            }
        } else if (t instanceof Object[]) {
            if (((Object[]) t).length == 0) {
                return true;
            }
        } else if (t instanceof String) {
//            int strLen;
            return ((String) t).length() == 0;
//
//            strLen = ((String) t).length();
//            if (strLen == 0) {
//                return true;
//            }
//
//            for (int i = 0; i < strLen; i++) {
//                if ((!Character.isWhitespace(((String) t).charAt(i)))) {
//                    return false;
//                }
//            }
//
//            return true;
        }

        return false;
    }

    public static <T> boolean isNotBlank(T t) {
        return !isBlank(t);
    }
}
