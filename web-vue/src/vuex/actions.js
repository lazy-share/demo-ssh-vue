import * as types from './mutation_types'

export default {

  //当调用store.dispatch('loadSideMenus',...)时，会回调这里
  loadSideMenus({ commit }, side_menus) {
    commit(types.LOAD_SIDE_MENUS, side_menus)
  },
}
