<template>
  <el-container>
    <el-header><home-header></home-header></el-header>
    <el-container>
      <el-aside width="250px"><home-side></home-side></el-aside>
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
		name: "Home"
	}
</script>

<style scoped>

</style>
