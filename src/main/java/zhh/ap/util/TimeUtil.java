package zhh.ap.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static String getYYYYMMDDFromStr(String yyyyMMddHHmmss) {
        String yyyyMMdd = "";
        if (StringUtils.isNotBlank(yyyyMMddHHmmss)) {
            yyyyMMdd = yyyyMMddHHmmss.substring(0, 4) + "-" + yyyyMMddHHmmss.substring(4, 6) + "-" + yyyyMMddHHmmss.substring(6, 8);
        }
        return yyyyMMdd;
    }

    public static String getYYYYMMDDHHMMSS(Date date) {
        return new SimpleDateFormat(yyyyMMddHHmmss).format(date);
    }
}
