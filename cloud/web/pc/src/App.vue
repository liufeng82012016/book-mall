<template>
  <div class="app-container">
    <!--头部导航区域-->
    <div class="app-header">
      <div class="menu">
        <t-head-menu v-model="menu1Value" theme="light" @change="changeHandler">
          <template #logo>
            <Logo></Logo>
          </template>
          <router-link to="/index"><t-menu-item value="indexMenuItem">首页</t-menu-item></router-link>
          <router-link to="/collect"> <t-menu-item value="collectMenuItem">收藏</t-menu-item></router-link>
          <t-menu-item value="orderMenuItem">订单</t-menu-item>
        </t-head-menu>
      </div>
      <div>
        <t-button theme="default" size="medium" variant="outline" @click="onClickLogin()" v-if="notLogin">登录</t-button>
        <t-button theme="default" size="medium" variant="outline" @click="onLoginOut()" v-if="!notLogin">退出登录</t-button>
      </div>
    </div>

    <div>
      <router-view></router-view>
    </div>

  </div>

  <LoginPop v-if="visible"></LoginPop>


</template>


<script type="ts">
import LoginPop from './components/LoginPop.vue'
import Logo from './components/Logo.vue'
import Index from './components/Index.vue'
import {reactive, ref} from 'vue'
import {useUserInfo} from './js/Store.js'
import {storeToRefs} from 'pinia'
import {MessagePlugin} from 'tdesign-vue-next';
import {MoreIcon} from 'tdesign-icons-vue-next';

export default {

  setup() {
    // 页面状态
    const pageInfo = reactive({
      counter: 0
    });
    const userInfo = useUserInfo();
    let {token} = storeToRefs(userInfo)
    document.addEventListener("keydown", function (e) {
      if (e.key === 'Escape') {
        pageInfo.counter = 0;
      }
    })

    // 目录
    const indexMenuRef = ref("indexMenuItem");
    const collectMenuRef = ref("collectMenuItem");
    const orderMenuRef = ref("orderMenuItem");


    return {
      pageInfo, token, userInfo, indexMenuRef, collectMenuRef, orderMenuRef
    };

  },
  data() {
    return {
      menu1Value: ""
    }
  },
  methods: {
    onClickLogin() {
      if (this.token.length > 0) {
        // token存在，无响应
      } else {
        this.pageInfo.counter = 1;
      }
    },
    onLoginOut() {
      this.userInfo.clearToken();
      this.pageInfo.counter = 0;
    },
    changeHandler(active) {
      this.menu1Value = active;
    },

  },
  computed: {
    // 登录弹窗是否可见
    visible() {
      return this.token.length <= 0 && this.pageInfo.counter == 1;
    },
    // 是否未登录
    notLogin() {
      return this.token.length <= 0;
    },
    bookOptionHandle(data, item) {
      console.log(data.content)
      console.log(item.id)
    }
  }
}


</script>


<style lang="less">
.app-container {
  width: 80vw;
  margin: 0 auto;

  .app-header {
    display: flex;
    align-items: center;
    padding: 1vw;

    .menu {
      flex: 1;
    }
  }

}


.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>

