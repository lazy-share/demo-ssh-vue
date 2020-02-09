package com.lazy.demo.sshvue.server.api.utils;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public class UuidUtils {

    public UuidUtils() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUuid());
    }

}
