<template>
  <el-header>
    <el-menu
      class="el-menu-demo"
      mode="horizontal"
      background-color="#143f6d"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1"><a class="nav-logo"></a></el-menu-item>
      <el-menu-item index="2"><span style="color: white;">欢迎登录后台管理系统</span></el-menu-item>
    </el-menu>
  </el-header>
</template>

<script>
    export default {
        name: "LoginHeader"
    }
</script>

<style scoped>
  .el-header {
    background-color: #143f6d;
    color: #333;
    font-size: x-large;
    margin-bottom: 30px;
    margin-top: 0px;
    text-align: left;
    line-height: 60px;
    padding: 0px;
  }

  .nav-logo {
    width: 155px;
    display: inline-block;
    height: 50px;
    background: url("../assets/logo.png") center center;
    background-size: 150px auto;
  }
</style>
