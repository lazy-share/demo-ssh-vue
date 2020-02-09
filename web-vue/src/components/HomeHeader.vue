<template>
  <el-menu
    class="el-menu-demo"
    mode="horizontal"
    background-color="#143f6d"
    @select="handleSelect"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-menu-item index="1"><a class="nav-logo"></a></el-menu-item>
    <template v-for="(menu, ix) in nav_menus">
      <el-menu-item :index="menu.id"  v-if="ix < getNavMenuNum">{{menu.res_name}}</el-menu-item>
    </template>
    <el-submenu index="2" v-if="nav_menus.length > (getNavMenuNum - 1)">
      <template v-for="(menu, ix) in nav_menus">
        <template slot="title" v-if="ix == getNavMenuNum">更多</template>
        <el-menu-item :index="menu.id"  v-if="ix > (getNavMenuNum - 1)">{{menu.res_name}}</el-menu-item>
      </template>
    </el-submenu>
    <div style="float: right">
      <el-menu-item index="/sessions" >
        <template slot="title">
          <i class="el-icon-caret-right"></i>退出
        </template>
      </el-menu-item>
    </div>

  </el-menu>
</template>

<script>
    import * as Constant from "../constant";
    import Utils from "../utils";

    export default {
      name: "HomeHeader",
      data(){
          return {
            windowWidth: document.body.clientWidth,
            navMenuNum: 6
          }
      },
      computed: {
        getNavMenuNum: function () {
          return this.navMenuNum != null ? this.navMenuNum : this.windowWidth < 1250 ? 6 : 9;
        },
        nav_menus: function () {
          return Utils.getNavMenus();
        }
      },
      created(){

      },
      mounted () {
        const that = this;
        window.onresize = () => {
          return (() => {
            window.screenWidth = document.body.clientWidth;
            that.windowWidth = window.screenWidth;
            that.setNavMenuNum();
          })()
        }
      },
      methods: {
        setNavMenuNum: function(){
          if (this.windowWidth < 1250 && this.windowWidth > 1000){
            this.navMenuNum = 6
          }else if (this.windowWidth < 500){
            this.navMenuNum = 0
          }else if (this.windowWidth < 1000){
            this.navMenuNum = 3
          }
        },

        handleSelect(key, keyPath) {
          if (key === '/sessions'){
            Utils.localStorageSet(Constant.TOKEN_KEY, "");
            this.$router.push('/login');
          }
      },
      }
    }
</script>

<style scoped>
  .nav-logo {
    width: 155px;
    display: inline-block;
    height: 50px;
    background: url("../assets/logo.png") center center;
    background-size: 150px auto;
  }
</style>
