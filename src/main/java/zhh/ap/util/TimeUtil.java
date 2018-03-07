package zhh.ap.util;

import org.apache.commons.lang3.StringUtils;

public class TimeUtil {

    public static String getYYYYMMDDFromStr(String yyyyMMddHHmmss) {
        String yyyyMMdd = "";
        if (StringUtils.isNotBlank(yyyyMMddHHmmss)) {
            yyyyMMdd = yyyyMMddHHmmss.substring(0, 4) + "-" + yyyyMMddHHmmss.substring(4, 6) + "-" + yyyyMMddHHmmss.substring(6, 8);
        }
        return yyyyMMdd;
    }

}
