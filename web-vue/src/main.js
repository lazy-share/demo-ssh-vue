// 导入vue框架
import Vue from 'vue'
// 导入elementUi框架（ui框架）
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 导入axios插件（发起ajax http用的）
import axios from 'axios'
// 导入vuex插件
import store from './vuex';
import VueAxios from 'vue-axios'
// 导入router插件（前端路由跳转url用的）
import router from './router'
// 导入vuex插件
import Vuex from 'vuex'
// 导入主模板
import App from './App'
// 导入拦截器模块（自定义的）
import Intercept from "./intercept";

// 配置router、axios全局拦截器
Intercept.routerBeforeEach(axios, router);
Intercept.requestIntercept(axios, router);
Intercept.responseIntercept(axios, router);

// 关闭生产提示
Vue.config.productionTip = false;

// 注入axios插件
axios.defaults.baseURL = process.env.ADMIN_DOMAIN;
Vue.use(VueAxios, axios);
Vue.prototype.$axios = axios;

// 注入vuex插件
Vue.use(Vuex);
// 注入elementUi框架
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount("#app");
