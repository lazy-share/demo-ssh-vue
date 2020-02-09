package com.lazy.demo.sshvue.server.api.utils;

import java.security.MessageDigest;
import java.security.SignatureException;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public class MD5Utils {

    private static final String PUBLIC_SALT = "HCL20180413";
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public MD5Utils() {
    }

    public static String md5Signature(String str, String salt) throws SignatureException {
        return encodeByMD5("HCL20180413" + str + salt);
    }

    public static String md5Signature(String str) throws SignatureException {
        return encodeByMD5(str);
    }

    private static String encodeByMD5(String clientString) throws SignatureException {
        if (clientString != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(clientString.getBytes());
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception var4) {
                throw new SignatureException("MD5错误!", var4);
            }
        } else {
            return null;
        }
    }

    private static String byteArrayToHexString(byte[] b) throws Exception {
        StringBuffer resultSb = new StringBuffer();

        for (int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) throws Exception {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        try {
            System.out.println(md5Signature("7e165ba51703472fa0dc03e5dde76d41", "TCL@O2O#L2017Z09Y26ARGF"));
        } catch (SignatureException var2) {
            var2.printStackTrace();
        }

    }
}
