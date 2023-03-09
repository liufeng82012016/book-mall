<template>
  <div class="empty" v-if="!recommendBooks || recommendBooks.length === 0">
    书架空空如也～
  </div>
  <div v-if="recommendBooks.length>0">
    <t-form :data="formData">
      <t-form-item label="朝代" name="dynasty" initial-data="['1']">
        <t-select v-model="formData.dynasties" :options="dynasties" placeholder="全部" multiple :auto-width="true"
                  :borderless="true"/>
      </t-form-item>
      <t-form-item label="作者" name="author" initial-data="['1']">
        <t-select v-model="formData.author" :options="authors" placeholder="选择作者" multiple :auto-width="true"
                  :borderless="true"/>
      </t-form-item>
    </t-form>
    <div class="collect-options-container">
      <span class="option" @click="onSelect()">筛选</span>
    </div>
    <BookList :bookList="recommendBooks" :showCollectIcon="true"></BookList>
  </div>

</template>
<script lang="ts">
import BookList from './BookList.vue';
import {ref, reactive} from 'vue'

export default {
  setup() {
    const formData = reactive({
      keyword: "",
      dynasties: [],
      author: []
    })
    const dynasties = reactive([
      {"label": "全选", checkAll: true},
      {"label": "先秦", value: '1'},
      {"label": "秦汉", value: '2'},
      {"label": "魏晋", value: '3'},
      {"label": "唐", value: '4'},
      {"label": "宋", value: '5'},
      {"label": "元", value: '6'},
      {"label": "明", value: '7'},
      {"label": "清", value: '8'},
    ])
    const authors = reactive([
      {"label": "孔子", value: '1'},
      {"label": "屈原", value: '2'},
      {"label": "吴起", value: '3'},
      {"label": "诸葛亮", value: '4'},
      {"label": "谢安", value: '5'},
      {"label": "杨炯", value: '6'},
      {"label": "李白", value: '7'},
      {"label": "苏轼", value: '8'},
    ])
    // const recommendBooks = reactive([
    //   {
    //     id: 1,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 2,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 3,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 4,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 5,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 6,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   }, {
    //     id: 7,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   }, {
    //     id: 8,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   }, {
    //     id: 9,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   }, {
    //     id: 10,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   },
    //   {
    //     id: 11,
    //     title: "周易",
    //     author: "周文王",
    //     cover: "/src/assets/carousel2.png",
    //     desc: "是一部中国古哲学书籍，是建立在阴阳二元论基础上对事物运行规律加以论证和描述的书籍，其对于天地万物进行性状归类，天干地支五行论，甚至精确到可以对事物的未来发展做出较为准确的预测",
    //     collect: 100
    //   }
    // ])
    const recommendBooks = reactive([])

    const onSelect = () => {
      console.log(JSON.stringify(formData))
    }
    return {
      recommendBooks, formData, dynasties, authors, onSelect
    }
  }
}
</script>

<style lang="less">
.collect-options-container {
  overflow: hidden;

  span {
    padding: 2px 8px;
    float: right;
    font-size: 15px;
    background-color: rgb(100, 128, 238);
    border-radius: 5px;
    color: white;
  }

  span:hover {
    cursor: pointer;
  }

  .t-form__label--right {
    width: 40px;
  }
}

.empty {
  min-height: 60vh;
  //background-color: #55e3c1;
  display: flex;
  justify-content: center;
  align-items: center;
  color: lightslategray;
  font-weight:200;
  text-shadow: 1px -1px 1px rgba(255,155,155,0.3) ;

  img {
    height: 20px;
  }
}
</style>