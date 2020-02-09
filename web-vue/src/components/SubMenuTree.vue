<template>
  <div v-if="parentmenu">
    <el-submenu :index="parentmenu.uri ? parentmenu.uri : parentmenu.id">
      <template slot="title">
        <i :class=parentmenu.icon></i>
        <span>{{parentmenu.res_name}}</span>
      </template>
      <template v-for="(submenu, ix) in parentmenu.submenus">
        <template v-if="submenu.submenus.length > 0">
          <app-sub-menu-tree :parentmenu="submenu"></app-sub-menu-tree>
        </template>
        <el-menu-item v-else :index="submenu.uri ? submenu.uri : submenu.id">
          <i :class="submenu.icon"></i>
          <span slot="title">{{submenu.res_name}}</span>
        </el-menu-item>
      </template>
    </el-submenu>
  </div>
</template>

<script>
  import appSubMenuTree from './SubMenuTree';

    export default {
      name: "SubMenuTree",
      props: ['parentmenu'],
      components: {
        appSubMenuTree
      }
    }
</script>

<style scoped>

</style>
