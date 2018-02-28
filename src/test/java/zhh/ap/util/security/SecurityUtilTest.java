package zhh.ap.util.security;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityUtilTest {

    @Test
    public void getSHA256Str() {
        String str = "zhh";
        String encodedStr = SecurityUtil.getSHA256Str(str);
        System.out.println("Get SHA256 Str : " + encodedStr);
        System.out.println(SecurityUtil.getSHA256Str("Hello ZHH").equals(encodedStr));
        System.out.println("17d94ea7e431e8b6a618e81a63cb1f37b7d74f92c833c3cb1db26b4831bc2038".equals(encodedStr));
        System.out.println(encodedStr.length());
        System.out.println(SecurityUtil.getSHA256Str("asdasdasdsadasdsa").length());
    }
}