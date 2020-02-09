import Utils from "../utils";
import * as Constant from '../constant'

export default {

  // 前台路由前置拦截器
  "routerBeforeEach": function (axios, routes) {
    routes.beforeEach((to, from, next) => {
      // 白名单的路由全部放过
      if (Constant.F_URIS_WHITE_LIST.indexOf(to.path) !== -1) {
        next();
        return;
      }
      // 否则检查是否有token
      let token = Utils.localStorageGet(Constant.TOKEN_KEY);
      // 如果没有token，跳到登录页面
      if (!token) {
        next('/login');
        return;
      }
      next();
    })
  },

  // 请求后台前置拦截器
  "requestIntercept": function (axios, router) {
    axios.interceptors.request.use(function (config) {
      // 白名单的路由全部放过
      for (let i in Constant.A_URIS_WHITE_LIST) {
        if (Constant.A_URIS_WHITE_LIST[i]['method'] === config.method.toLowerCase()) {
          if (Constant.A_URIS_WHITE_LIST[i]['uri'] === config.url) {
            return config;
          }
        }
      }
      // 否则检查是否有token
      let token = Utils.localStorageGet(Constant.TOKEN_KEY);
      // 如果没有token,则跳到登录页
      if (!token) {
        axios.CancelToken.source().cancel();
        router.push('/login');
        return;
      }
      config.headers['auth'] = token;
      return config;
    }, function (err) {
      return Promise.reject(err);
    });
  },

  // 后台响应前置拦截器
  "responseIntercept": function (axios, router) {
    axios.interceptors.response.use(function (res) {
      res = res.data;

      //token过期
      if (res.code === Constant.TOKEN_EXPIRE) {
        Utils.localStorageSet(Constant.TOKEN_KEY, "");
        Utils.localStorageSet(Constant.TOKEN_USER_KEY, "");
        axios.CancelToken.source().cancel();
        router.push("/login")

        //其它错误
      } else {
        return res;
      }
    }, function (err) {
      return Promise.reject(err);
    })
  }
}
