<template>
  <div v-if="menus.length > 0">
    <template v-for="(menu, ix) in menus">
      <template v-if="menu.submenus.length > 0">
        <app-sub-menu-tree :parentmenu="menu"></app-sub-menu-tree>
      </template>
      <template v-else>
        <el-menu-item :index="menu.uri ? menu.uri : menu.id">
          <i :class="menu.icon"></i>
          <span slot="title">{{menu.res_name}}</span>
        </el-menu-item>
      </template>
    </template>
  </div>
</template>

<script>
  import appSubMenuTree from './SubMenuTree';

  export default {
    name:'MenuTree',
    props: ['menus'],
    components: {
      appSubMenuTree,
      }
    }
</script>

<style scoped>
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
    overflow-y:auto;
  }
</style>
