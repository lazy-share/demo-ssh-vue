export const TOKEN_KEY = 'demo-ssh-vue-token';
export const TOKEN_USER_KEY = 'demo-ssh-vue-token-user';

////////////////////////////////系统模块/////////////////////////////////////////
//例子
export const ADMIN_EXAMPLES_URI = '/examples';
//系统-登录
export const ADMIN_LOGIN_URI = '/sessions';

//状态码
export const REQ_SUCCESS = '200';
export const TOKEN_EXPIRE = '302';

//前台uri白名单
export const F_URIS_WHITE_LIST = [
  '/login',
  '/permission_denied',
  '/not_legal'
];

//后台uri白名单
export const A_URIS_WHITE_LIST = [
  {'method': 'put', 'uri': '/sessions'},
  {'method': 'delete', 'uri': '/sessions'},
];
