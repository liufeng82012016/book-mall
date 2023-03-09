<template>
  <div class="logo-container">
    <div class="logo-bg">
      Liu Feng
    </div>
  </div>
</template>
<style lang="less" scoped>
.logo-container {
  height: 32px;
  width: 110px;
  background-image: url("../assets/shici.jpeg");
  background-size: cover;
  text-align: right;
  line-height: 32px;
  padding-right: 10px;
  font-size: 20px;

  .logo-bg {
    background: linear-gradient(to right, rgba(255, 0, 0, 0.5) 0%, rgba(0, 0, 255, 0.5) 50%, rgba(128, 0, 128, 0.5) 80%);
    -webkit-background-clip: text;
    color: transparent;
  }
}
</style>