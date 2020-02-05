package com.lazy.demo.sshvue.server.api.Interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

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
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        if (!currentLimiter.acquire()) {
//            BusinessExceptionHelper.throw500("系统繁忙，稍等会再操作");
//        }
//        TokenHolder.getInstance().cleanup();
//        String requestUrl = httpServletRequest.getRequestURI();
//
//        //param checked
//        if (StringUtils.isEmpty(requestUrl)) {
//            requestUrl = httpServletRequest.getPathInfo();
//        }
//        if (StringUtils.isEmpty(requestUrl)) {
//            requestUrl = httpServletRequest.getServletPath();
//        }
//
//        //filter not need checked uri
//        String method = httpServletRequest.getMethod();
//        //options method not need checked
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(method)) {
//            return true;
//        }
//        //过滤不拦截uri
//        String uri = String.format("%s%s", method.toLowerCase(), requestUrl);
//        boolean isInterceptor = !ApiConstants.isMatch(uri);
//
//        //begin checked token
//        String token = httpServletRequest.getHeader(ApiConstants.TOKEN_RES_HEADER_KEY);
//
//        //如果请求头带有token
//        if (StringUtils.isNotBlank(token)) {
//            TokenInfo tokenInfo = (TokenInfo) cacheTemplate.get(token);
//            //如果请求头带有token 且token在缓存中有效
//            if (tokenInfo != null) {
//                //校验userinfo
//                TActivitiesUserEntity userEntity = ActivitiesServiceRegistry.getInstance().iActivitiesUserService
//                        .findOne(tokenInfo.getUserEntity().getId());
//                if (userEntity == null){
//                    cacheTemplate.delete(token);
//                    throw new DefaultBusinessException(new SimpleResCodeDto(ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getCode(),
//                            ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getMsg()));
//                }
//                //如果请求头带有token且有效，则直接更新实体和有效期
//                tokenInfo.setUserEntity(userEntity);
//                cacheTemplate.set(token, tokenInfo, ApiConstants.TOKEN_EXPIRE, TimeUnit.SECONDS);
//                //如果请求头带有token且有效，则直接保存到本地线程
//                TokenHolder.getInstance().set(token);
//
//                //如果请求头带有token 且token在缓存中失效 且uri需要拦截 则异常3000，提示需要登录
//            } else if (isInterceptor) {
//                throw new DefaultBusinessException(new SimpleResCodeDto(ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getCode(),
//                        ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getMsg()));
//
//                //如果请求头带有token 且token在缓存中失效 且uri不需要拦截
//            } else {
//
//                //忽略 后续按游客处理
//            }
//
//            //如果请求头没有token，且uri需要拦截，则异常3000，提示需要登录
//        } else if (isInterceptor) {
//            throw new DefaultBusinessException(new SimpleResCodeDto(ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getCode(),
//                    ApiCodeEnum.NOT_FOUND_TOKEN_INFO.getMsg()));
//
//            //如果请求头没有token，且uri不需要拦截
//        } else {
//            //忽略，后续按游客处理
//        }
//        return true;

        return true;
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     *
     * @param httpServletRequest
     * @param httpResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpResponse, Object o, ModelAndView modelAndView) throws Exception {

//        TokenHolder.getInstance().cleanup();
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
