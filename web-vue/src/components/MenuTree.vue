<template>
  <div v-if="menus.length > 0">
    <template v-for="(menu, ix) in menus">
      <template v-if="menu.submenus.length > 0">
        <sub-menu-tree :parentmenu="menu"></sub-menu-tree>
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
  import SubMenuTree from './SubMenuTree';

  export default {
    name:'MenuTree',
    props: ['menus'],
    components: {
      SubMenuTree,
      }
    }
</script>

<style scoped>

</style>
