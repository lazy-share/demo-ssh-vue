<template>
  <el-menu
    class="el-menu-vertical-demo"
    background-color="#23262E"
    text-color="#fff"
    router
    active-text-color="#fff">
	<el-menu-item index="/">
      <i class="el-icon-menu"></i>
      <span class="side_title" slot="title">首页报表统计</span>
    </el-menu-item>
    <menu-tree :menus="side_menus" v-if="side_menus && side_menus.length > 0"></menu-tree>
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

</style>

<style>
   .el-submenu .el-submenu__title {
        text-align: left;
    }
	
	.el-menu-vertical-demo {
	   width: 200px;
	   text-align: left;
	  
	}
	
	.side_title {
	   font-weight: bold;
	}

</style>
