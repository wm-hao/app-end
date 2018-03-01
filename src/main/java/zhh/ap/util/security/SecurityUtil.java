package zhh.ap.util.security;


import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    /**
     * 利用Apache的工具类实现SHA-256加密
     * @param str
     * @return
     */
    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        if(StringUtils.isNotBlank(str)){
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
                encdeStr = Hex.encodeHexString(hash);
            } catch (NoSuchAlgorithmException |UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return encdeStr;
    }

}
