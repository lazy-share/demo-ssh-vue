package com.lazy.demo.sshvue.server.api.Interceptor;

import com.lazy.demo.sshvue.server.api.constants.Constant;
import com.lazy.demo.sshvue.server.api.enums.ResponseEnum;
import com.lazy.demo.sshvue.server.api.except.BusinessException;
import com.lazy.demo.sshvue.server.api.token.TokenHolder;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * token拦截器
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/5.
 */
public class TokenInterceptor implements HandlerInterceptor {


    /**
     * 进入控制器前拦截,验证是否存在Token信息，验证Token是否有效
     *
     * @param httpServletRequest  请求对象
     * @param httpServletResponse 响应对象
     * @param o                   对象
     * @return 是否放过
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String requestUrl = httpServletRequest.getRequestURI();

        //param checked
        if (StringUtils.isEmpty(requestUrl)) {
            requestUrl = httpServletRequest.getPathInfo();
        }
        if (StringUtils.isEmpty(requestUrl)) {
            requestUrl = httpServletRequest.getServletPath();
        }

        //filter not need checked uri
        String method = httpServletRequest.getMethod();
        //options method not need checked
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(method)) {
            return true;
        }

        //过滤不拦截uri
        String uri = String.format("%s%s", method.toLowerCase(), requestUrl);
        if (Constant.isMatchNotInterceptor(uri)) {
            return true;
        }

        String token = httpServletRequest.getHeader(Constant.TOKEN_HEADER_KEY);

        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(ResponseEnum.TOKEN_ERROR);
        }

        //判断token是否过期
        if (!TokenHolder.getSingle().isValidAndSet(token)) {
            throw new BusinessException(ResponseEnum.TOKEN_EXPIRE);
        }

        return true;
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     *
     * @param httpServletRequest 请求对象
     * @param httpResponse       响应对象
     * @param o                  对象
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse, Object o, ModelAndView modelAndView) throws Exception {

        TokenHolder.getSingle().cleanup();
    }

    /**
     * 视图渲染之后的操作
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
