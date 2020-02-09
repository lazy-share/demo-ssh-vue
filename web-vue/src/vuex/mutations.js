import * as types from './mutation_types'

export default {
  //当调用commit(types.LOAD_SIDE_MENUS, side_menus)时，会回调这里,具体查看actions.js文件中
  [types.LOAD_SIDE_MENUS](state, side_menus) {
    state.side_menus = side_menus;
  }
};
