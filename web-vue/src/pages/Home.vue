<template>
  <el-container>
    <el-header><home-header></home-header></el-header>
    <el-container>
      <el-aside width="200px"><home-side></home-side></el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

  import HomeHeader from '../components/HomeHeader';
  import HomeFooter from '../components/HomeFooter';
  import HomeSide from '../components/HomeSide';

	export default {
		name: "Home",

    components:{
      HomeHeader,
      HomeFooter,
      HomeSide
    },
	}
</script>

<style scoped>

  .el-header {
    background-color: #23262E;
    color: #333;
    font-size: x-large;
    margin-bottom: 0px;
    margin-top: 0px;
    text-align: left;
    line-height: 60px;
    padding: 0px;
  }

  .el-aside {
    background-color: #344058;
    color: #333;
    line-height: 200px;
    padding: 0px;
    overflow-y:auto;
    width: 200px;
    height: calc(100vh - 80px);
  }
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  .el-footer {
    background-color: #143f6d;
    color: white;
    font-size: x-small;
    text-align: center;
    line-height: 60px;
  }
  body > .el-container {
    margin-bottom: 40px;
  }
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
