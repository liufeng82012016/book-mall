<template>
  <div class="verse-container">
    <t-swiper class="tdesign-demo-block--swiper" direction="vertical" :navigation="{ showSlideBtn: 'never' }"
              :height="24" :autoplay="true">
      <t-swiper-item v-for="item in verses" :key="item">
        <span>{{ item }}</span>
      </t-swiper-item>
    </t-swiper>
  </div>
</template>
<script>
export default {
  name: "Verse",
  data() {
    return {
      verses: [
        "举杯邀明月，对影成三人",
        "三人行，必有我师焉",
        "天行健，君子以自强不息"
      ]
    }
  }
}
</script>
<style lang="less">
.verse-container {
  width: 500px;
  height: 24px;
  overflow: hidden;
  text-align: left;


  ul {
    display: none;
  }
}
</style>