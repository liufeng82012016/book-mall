<template>
  <div class="login-mask">
    <div class="login-container">
      <div class="login-body">
        <Login v-if="pageInfo.isLogin"></Login>
        <Register v-if="!pageInfo.isLogin"></Register>
      </div>
      <div class="login-footer">
        <Verse></Verse>
        <span @click="change()" class="login-change">{{ pageInfo.isLogin ? '立即注册' : '立即登录' }}</span>
      </div>
    </div>

  </div>
</template>
<script lang="ts" setup>
import Login from './Login.vue'
import Register from './Register.vue'
import Verse from './Verse.vue'
import {ref, reactive} from 'vue'

const pageInfo = reactive({
  isLogin: true
})

const change = () => {
  pageInfo.isLogin = !pageInfo.isLogin;
}
</script>
<style lang="less" scoped>
.login-mask {
  height: 100%;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 888;
  position: absolute;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;


  .login-container {
    background-image: url("../assets/shici.jpeg");
    background-size: cover;
    height: 350px;
    width: 700px;
    box-shadow: 0 0 0 2px rgb(102, 85, 85), 0 0 0 5px rgb(89, 122, 122);

    .login-body {
      overflow: hidden;
      height: 310px;
    }

    .login-footer {
      padding: 5px;
      display: flex;
      justify-content: space-between;
    }

    .login-change {
      border: 1px solid black;
      box-shadow: 0 0 0 1px rgb(102, 85, 85)
    }

    .login-change:hover {
      cursor: pointer;
    }
  }

}


</style>