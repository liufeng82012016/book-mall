<template>
  <div class="column">
    <img src="src/assets/swallow.png" class="recommend-icon"/>
    {{ title }}
    <img src="src/assets/swallow.png" class="recommend-icon"/>
  </div>
</template>
<script>
export default {
  name: "Column",
  props: {
    title: String
  }

}
</script>
<style lang="less" scoped>
.column {
  margin-top: 10px;
  height: 40px;
  line-height: 40px;
  font-size: 28px;
  display: flex;
  align-items: center;
  justify-content: center;


  img {
    height: 100%;
  }
}
</style>