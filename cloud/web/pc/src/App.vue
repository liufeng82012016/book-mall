<template>
  <div class="header">
    <div class="menu">
      <t-breadcrumb>
        <template #default>
          <t-breadcrumbItem>首页</t-breadcrumbItem>
          <t-breadcrumbItem>我的收藏</t-breadcrumbItem>
          <t-breadcrumbItem>订单列表</t-breadcrumbItem>
        </template>
        <template #separator></template>
      </t-breadcrumb>

    </div>
    <div>
      <t-button theme="default" size="small" variant="outline" @click="pageInfo.visible = true">登录</t-button>
    </div>
  </div>

  <LoginPop v-if="pageInfo.visible"></LoginPop>


</template>


<script type="ts" setup>
import LoginPop from './components/LoginPop.vue'
import {reactive, ref} from 'vue'

import merge from 'lodash/merge';
import enConfig from 'tdesign-vue-next/es/locale/zh_CN';

// 全局特性配置，引入英文语言配置包 enConfig
const globalConfig = merge(enConfig, {
  // 可以在此处定义更多自定义配置，具体可配置内容参看 API 文档
  calendar: {},
  table: {},
  pagination: {},
});

const pageInfo = reactive({
  visible: false
});
</script>


<style lang="less">
.header {
  width: 80vw;
  margin: 0 auto;
  display: flex;
  align-items: center;
  padding: 1vw;

  .menu {
    flex: 1;
  }


}


.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>

