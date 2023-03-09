<template>
  <div class="book-list">
    <div v-for="item in bookList" :key="item.id" class="book-container" @mouseover="onMouseOver(item.id)"
         @mouseleave="onMouseLeave">
      <t-card :cover="item.cover" theme="poster2">
        <template #footer>
          <t-card :title="item.title" :subtitle="item.author" :description="item.desc" hover-shadow :bordered="false">
          </t-card>
        </template>
      </t-card>
      <div class="book-collect" v-if="showCollectIcon && id === item.id">
        <span class="iconfont icon-favorites" @click="onCollect(item.id)"></span>
      </div>
    </div>
  </div>
</template>
<script>
import {HeartFilledIcon} from 'tdesign-icons-vue-next';
import {ref} from 'vue';

export default {
  props: {
    bookList: Array,
    showCollectIcon: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      id: ""
    }
  },
  methods: {
    onMouseOver(id) {
      this.id = id;
    },
    onMouseLeave() {
      this.mouseOver = false;
    },
    onCollect(id) {
      console.log("collect: " + id)
    }
  }
}
</script>
<style lang="less">
.book-list {
  margin-top: 1vw;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;

  .book-container {
    width: 15vw;
    margin-top: 1vw;
    position: relative;
  }

  .book-collect {
    height: 30%;
    width: 100%;
    position: absolute;
    left: 0;
    bottom: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    background: linear-gradient(to bottom, rgba(0, 0, 0, 0.05) 0%, rgba(0, 0, 0, 0.2) 50%, rgba(0, 0, 0, 0.5) 100%);

    .iconfont {
      font-size: 20px;
      margin-bottom: 2vw;
    }

    .iconfont:hover {
      cursor: pointer;
    }
  }


  .t-card__footer {
    padding: 2px;
    background-color: rgba(139, 69, 19, 0.8);
    --td-bg-color-container: none;
  }

  .t-card__header {
    padding: 0;
  }

  .t-card__description {
    word-break: break-all;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
    margin: 4px;
    color: white;
  }
}
</style>