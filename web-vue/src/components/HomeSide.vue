<template>
  <el-menu
    class="el-menu-vertical-demo"
    background-color="#0D5477"
    text-color="#fff"
    router
    active-text-color="#ffd04b">
    <app-menu-tree :menus="side_menus" v-if="side_menus && side_menus.length > 0"></app-menu-tree>
    <el-menu-item index="/" v-else>
      <i class="el-icon-menu"></i>
      <span slot="title">报表统计</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
  import appMenuTree from './MenuTree';

  export default {
    name: "HomeSide",
    components: {
      appMenuTree
    },
    data() {
      return {}
    },
    computed: {
      side_menus: function () {
        return this.$store.state.side_menus;
      },
    }
  }
</script>

<style scoped>

</style>
