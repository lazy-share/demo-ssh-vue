package com.lazy.demo.sshvue.server.api.utils;

import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;
import com.lazy.demo.sshvue.server.api.except.BusinessException;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 断言工具类
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/8.
 */
public class AssertUtils {

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static void assertIsEmpty(String str) {
        if (isEmpty(str)) {
            throw new BusinessException(ResponseEnum.PARAM_ERROR);
        }
    }

}
