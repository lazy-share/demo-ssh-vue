<template>
  <el-header>
    <el-menu
      class="el-menu-demo"
      mode="horizontal"
      background-color="#23262E"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1"><a class="nav-logo"></a></el-menu-item>
      <el-menu-item index="2"><span style="color: white;">欢迎登录后台管理系统</span></el-menu-item>
    </el-menu>
  </el-header>
</template>

<script>
    export default {
        name: "GenericHeader"
    }
</script>

<style scoped>
  .el-header {
    background-color: #23262E;
    color: #333;
    font-size: x-large;
    margin-bottom: 30px;
    margin-top: 0px;
    margin-left: 5px;
    text-align: left;
    line-height: 60px;
    padding: 0px;
  }

  .nav-logo {
    width: 50px;
    display: inline-block;
    height: 50px;
    background: url("../assets/logo.png") center center;
    background-size: 50px auto;
  }
</style>
