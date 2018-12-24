package com.idea.cms.utils;

import java.util.List;

/**
 * ListUtil
 */
public class ListUtil {
    public static boolean isBlank(List ls) {
        return ls == null || ls.isEmpty();
    }

    public static boolean isNotBlank(List ls) {
        return !isBlank(ls);
    }

    public static String join(List ls, String split) {
        if (isNotBlank(ls)) {
            StringBuffer sb = new StringBuffer();
            for (Object item : ls) {
                sb.append(item).append(split);
            }
            return StringUtil.deleteLastChar(sb.toString());
        }
        return null;
    }
}
