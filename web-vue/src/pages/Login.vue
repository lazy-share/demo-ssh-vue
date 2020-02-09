<template>
  <div id="login">
    <el-row :gutter="10">
      <div class="bg-color" id="bg-color">
        <login-header></login-header>
        <div id="loginFormDiv">
          <el-col :offset="8" :xs="8" :sm="8" :md="8" :lg="8" :xl="8">
            <div class="main grid-content bg-purple">
              <el-form :model="loginForm" status-icon :rules="login" ref="loginForm" label-width="100px"
                       class="demo-ruleForm">
                <el-form-item label="账号" prop="username">
                  <el-input type="text" v-model="loginForm.username" auto-complete="on"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="pass">
                  <el-input type="password" v-model="loginForm.password" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="submitForm()">登录</el-button>
                  <el-button @click="resetForm()">重置</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-col>
        </div>
      </div>
    </el-row>
  </div>
</template>

<script>

  import * as Constant from '../constant'
  import Utils from '../utils'
  import {Loading} from 'element-ui';
  import LoginHeader from '../components/LoginHeader'

  export default {
    name: "Login",
    components: {
      LoginHeader
    },
    data() {
      let checkUsername = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('请输入用户名'));
        }
        callback();
      };
      let validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        }
        callback();
      };
      return {
        loginForm: {
          username: '',
          password: ''
        },
        login: {
          password: [
            {validator: validatePassword, trigger: 'blur'}
          ],
          username: [
            {validator: checkUsername, trigger: 'blur'}
          ]
        }
      }
    },

    methods: {

      submitForm: function () {
        const self = this;
        self.$refs['loginForm'].validate((valid) => {
          if (valid) {
            let loadingInstance = Loading.service({});
            self.$axios.put(Constant.ADMIN_LOGIN_URI, this.loginForm).then(function (resp) {
              loadingInstance.close();
              console.log(resp);
              if (resp.code !== Constant.REQ_SUCCESS) {
                self.$alert(resp.msg, '系统提示');
              } else {
                Utils.localStorageSet(Constant.TOKEN_KEY, resp.data.token);
                Utils.localStorageSet(Constant.TOKEN_USER_KEY, resp.data.account);
                self.$router.push("/")
              }
            }).catch(resp => {
              console.log(resp);
              loadingInstance.close();
              self.$alert('请求出错', '系统提示');
            });
          } else {
            self.$alert('请正确地输入账号和密码', '系统提示');
            return false;
          }
        });
      },

      resetForm: function () {
        this.$refs['loginForm'].resetFields();
      }
    }
  }
</script>

<style scoped>
  #login {
    background-color: #EBEBEB;
    height: 100%;
    width: 100%;
    border: 1px solid green;
    position: fixed;
  }

  #loginFormDiv{

  }
</style>
