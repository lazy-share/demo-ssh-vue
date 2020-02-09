package com.lazy.demo.sshvue.server.api.constants;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>App 常量定义</p>
 *
 * @author laizhiyuan
 * @since 2018/4/12.
 */
public class Constant {

    private Constant() {
        /** 不可实例化*/
    }


    /**
     * url 正则匹配
     */
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    public static final String TOKEN_HEADER_KEY = "auth";

    public static final String Y = "Y";
    public static final String N = "N";
    public static final String NONE = "NONE";

    /**
     * not interceptor uris
     */
    public static final Set<String> NOT_INTERCEPTOR_URIS = new HashSet<>();

    public static final boolean isMatchNotInterceptor(String uri) {
        if (NOT_INTERCEPTOR_URIS.contains(uri)) {
            return true;
        }
        for (String registerUri : NOT_INTERCEPTOR_URIS) {
            if (pathMatcher.match(registerUri, uri)) {
                return true;
            }
        }
        return false;
    }

    /**
     * servlet context path
     */
    public static final String SERVLET_CONTEXT_PATH = "/v1/demo-ssh-vue-api";

    static {
        //登录登出
        NOT_INTERCEPTOR_URIS.add("put" + SERVLET_CONTEXT_PATH + "/sessions");
        NOT_INTERCEPTOR_URIS.add("delete" + SERVLET_CONTEXT_PATH + "/sessions");

    }

}
