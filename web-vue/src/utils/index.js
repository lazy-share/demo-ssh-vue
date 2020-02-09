import * as Constants from "../constant";

export default {

  "jsonParseStr": function (str) {
    return JSON.parse(str);
  },

  "toJsonStr": function (obj) {
    return JSON.stringify(obj);
  },

  "formatDate": function (date, fmt) {
    if (/(y+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    let o = {
      'M+': date.getMonth() + 1,
      'd+': date.getDate(),
      'h+': date.getHours(),
      'm+': date.getMinutes(),
      's+': date.getSeconds()
    };
    for (let k in o) {
      if (new RegExp(`(${k})`).test(fmt)) {
        let str = o[k] + '';
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : ('00' + str).substr(str.length));
      }
    }
    return fmt;
  },

  "localStorageGet": function (key) {
    return window.localStorage.getItem(key);
  },

  'logout': function () {
    this.localStorageSet(Constants.TOKEN_USER_KEY, '');
    this.localStorageSet(Constants.TOKEN_KEY, '');
  },

  "localStorageSet": function (key, value) {
    if (value instanceof Object || value instanceof Array) {
      value = this.toJsonStr(value);
    }
    return window.localStorage.setItem(key, value);
  },

  "getToken": function () {
    let login_info = this.localStorageGet(Constants.TOKEN_KEY);
    if (login_info) {
      login_info = JSON.parse(login_info);
      return login_info['token'];
    }
    return undefined;
  },

  "timeHoursDiff": function (time) {
    let interval = new Date().getTime() - new Date(time).getTime();
    let intervalMinute = Math.floor(interval / (60 * 1000));
    console.log("当前时间毫秒" + new Date().getTime() + '-最后更新时间' + new Date(time).getTime() + "间隔时间为: " + intervalMinute);
    return intervalMinute
  },

  "getUserId": function () {
    let loginInfo = this.localStorageGet(Constants.TOKEN_KEY);
    loginInfo = JSON.parse(loginInfo);
    let user = loginInfo['user'];
    user = JSON.parse(user);
    let uid = user.id;
    return uid;
  },

  "hasAdminUriPermi": function (uris, uri, method) {
    uris = JSON.parse(uris);
    method = method.toUpperCase();
    for (let ix in uris) {
      if (uris[ix]['uri'] === uri && uris[ix]['method'] === method) {
        return true;
      }
    }
    console.log(uri + ' not permi');
    return false;
  },

  "hasFrontUriPermi": function (uris, uri) {
    uris = JSON.parse(uris);
    for (let ix in uris) {
      if (uris[ix]['uri'] === uri) {
        return true;
      }
    }
    return false;
  },

  "isInArr": function (arr, el) {
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === el) {
        return true;
      }
    }
    return false;
  }
}

