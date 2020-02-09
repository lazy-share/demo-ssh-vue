<template>
  <el-menu
    class="el-menu-demo"
    mode="horizontal"
    background-color="#23262E"
    @select="handleSelect"
    text-color="#D9D9D9"
    active-text-color="#fff">
    <el-menu-item index="1"><a class="nav-logo"></a></el-menu-item>
    <template v-for="(menu, ix) in nav_menus">
      <el-menu-item :index="menu.id" v-if="ix < getNavMenuNum">{{menu.res_name}}</el-menu-item>
    </template>
    <el-submenu index="2" v-if="nav_menus.length > (getNavMenuNum - 1)">
      <template v-for="(menu, ix) in nav_menus">
        <template slot="title" v-if="ix == getNavMenuNum">更多</template>
        <el-menu-item :index="menu.id" v-if="ix > (getNavMenuNum - 1)">{{menu.res_name}}</el-menu-item>
      </template>
    </el-submenu>
    <div style="float: right">
      <el-menu-item index="/sessions">
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
    data() {
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

        //实际项目这里替换为从后台获取
        return [{'id': '1', 'res_name': 'ssh-vue-demo'}];
      }
    },
    created() {

    },
    mounted() {
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
      setNavMenuNum: function () {
        if (this.windowWidth < 1250 && this.windowWidth > 1000) {
          this.navMenuNum = 6
        } else if (this.windowWidth < 500) {
          this.navMenuNum = 0
        } else if (this.windowWidth < 1000) {
          this.navMenuNum = 3
        }
      },

      handleSelect(key, keyPath) {
        //登出
        let self = this;
        if (key === '/sessions') {
          //异步调后台删除token，不关心结果
          let token = Utils.localStorageGet(Constant.TOKEN_KEY);
          if (token) {
            this.$axios.delete(Constant.ADMIN_LOGIN_URI + '/' + token,{}).then(function (resp) {
              if (resp.code === Constant.REQ_SUCCESS) {
                Utils.logout();
                self.$router.push('/login');
              } else {
                self.$message({type: 'info', message: resp.msg});
              }
            }).catch(resp => {
              self.$message({type: 'error', message: '服务器错误'});
            });
          }
        }
        //实际项目这里替换为菜单配置的url从后台请求子菜单，然后放到vux状态机中
        this.$store.dispatch('loadSideMenus', [
          {
            'id': '1',
            'res_name': 'demo',
            'uri': '',
            'title': 'demo',
            'submenus': [
              {
                'id': '2',
                'res_name': 'example',
                'uri': '/example',
                'title': 'example',
                'submenus': []
              }
            ]
          }
        ]);
      },
    }
  }
</script>

<style scoped>
  body {
    margin: 0px;
    padding: 0px;
  }
  .nav-logo {
    width: 100px;
    display: inline-block;
    color: #fff;
    height: 50px;
    background: url("../assets/logo.png") center center;
    background-size: 130px auto;
  }
</style>

