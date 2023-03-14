<template>
  <!--中间banner展示区域-->
  <div class="app-index">
    <div class="body">
      <div class="body-tags">
        <t-tag v-for="item in tags" :key="item.id">{{ item.tag }}</t-tag>
      </div>
      <div class="body-banner">
        <t-swiper class="tdesign-demo-block--swiper" :duration="300" :interval="2000">
          <t-swiper-item v-for="item in carousels" :key="item.id">
            <div class="body-banner-container"><img v-bind:src="item.url"></div>
          </t-swiper-item>
        </t-swiper>
      </div>
    </div>

    <Column title="经典书籍"></Column>
    <BookList :bookList="recommendBooks"></BookList>

    <Column title="楚辞汉赋"></Column>
    <BookList :bookList="recommendBooks"></BookList>

    <Column title="唐诗宋词"></Column>
    <BookList :bookList="recommendBooks"></BookList>

    <Column title="明清话本"></Column>
    <BookList :bookList="recommendBooks"></BookList>


  </div>

</template>
<script lang="ts">
import {ref} from 'vue'
import Column from './Column.vue'
import BookList from './BookList.vue'

export default {
  setup() {
    // 左侧标签
    const tags = ref([
      {id: 1, tag: "古诗"},
      {id: 2, tag: "唐朝"},
      {id: 3, tag: "医术"},
      {id: 4, tag: "诗词歌赋小说话本"},
      {id: 5, tag: "诗词歌赋小说话本"},
      {id: 6, tag: "诗词歌赋小说话本"},
      {id: 7, tag: "诗词歌赋小说话本"},
      {id: 8, tag: "诗词歌赋小说话本"},
      {id: 9, tag: "诗词歌赋小说话本"},
      {id: 10, tag: "诗词歌赋小说话本"},
      {id: 11, tag: "诗词歌赋小说话本"},
      {id: 12, tag: "诗词歌赋小说话本"},
      {id: 13, tag: "诗词歌赋小说话本"},
      {id: 14, tag: "诗词歌赋小说话本"},
      {id: 15, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 16, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 17, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 18, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 19, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 20, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 21, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 22, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 23, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 24, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 25, tag: "诗词歌赋小说话本神灵精怪"},
      {id: 26, tag: "诗词歌赋小说话本神灵精怪"},
    ])
    // 推荐书籍展示
    const recommendBooks = ref([
      {
        id: 1,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 2,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 3,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 4,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 5,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 6,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      }, {
        id: 7,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      }, {
        id: 8,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      }, {
        id: 9,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      }, {
        id: 10,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      },
      {
        id: 10,
        title: "周易",
        author: "周文王",
        cover: "/src/assets/carousel2.png",
        desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
        collect: 100
      }
    ])
    // 轮播
    const carousels = ref([
      {url: "/src/assets/carousel1.png", id: 1},
      {url: "/src/assets/carousel2.png", id: 2},
    ])
    return {
      tags, recommendBooks, carousels
    }
  }
}
</script>

<style lang="less">
.app-index {
  .body {
    display: flex;
    width: 100%;
    justify-content: space-between;
    height: 380px;

    .body-banner {
      width: 66%;
      height: 100%;

      .body-banner-container {
        height: 380px;

        img {
          width: 100%;
        }
      }
    }

    .body-tags {
      width: 32%;
      height: 100%;
      //display: flex;
      overflow: scroll;
      background-color: lightslategray;

      span {
        height: 20px;
        line-height: 20px;
        padding: 2px 5px;
        border-radius: 2px;
        margin-left: 5px;
        float: left;
      }

      span:nth-child(2n) {
        background-color: #55e3c1;
      }

      span:nth-child(2n+1) {
        background-color: orange;
      }

      span:hover {
        cursor: pointer;
      }
    }
  }


}


</style>