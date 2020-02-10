<template>
  <el-menu
    class="el-menu-vertical-demo"
    background-color="#383B4B"
    text-color="#fff"
    router
    active-text-color="#E6E6E6">
    <menu-tree :menus="side_menus" v-if="side_menus && side_menus.length > 0"></menu-tree>
    <el-menu-item index="/" v-else>
      <i class="el-icon-menu"></i>
      <span slot="title">首页报表统计</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
  import MenuTree from './MenuTree';

  export default {
    name: "HomeSide",
    components: {
      MenuTree
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
  el-menu-vertical-demo {
    margin: 0px;
    padding-right: 10px;
    width: 200px;
    background-color: #23262E;
  }
</style>
