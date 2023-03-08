<template>
  <div class="register-qrcode">
    <div ref="qrcodeRef"></div>
  </div>
  <div class="register-form">
    <t-form ref="form" :data="formData" :rules="rules" @submit="onSubmit" :label-width="0">
      <t-form-item label="账号" help="" name="account" :required-mark="true">
        <t-input v-model="formData.account" name="account" placeholder="请输入账号">
          <template #prefix-icon>
            <desktop-icon/>
          </template>
        </t-input>
      </t-form-item>

      <t-form-item label="密码" name="password" :required-mark="false">
        <t-input v-model="formData.password" type="password" placeholder="请输入密码">
          <template #prefix-icon>
            <lock-on-icon/>
          </template>
        </t-input>
      </t-form-item>

      <t-form-item label="口令" name="code" :required-mark="false">
        <t-input v-model="formData.code" placeholder="请输入动态口令">
          <template #prefix-icon>
            <lock-on-icon/>
          </template>
        </t-input>
      </t-form-item>
      <t-form-item>
        <t-button theme="success" @click="generateSecret()">获取动态口令</t-button>
      </t-form-item>
      <t-form-item>
        <t-button block type="submit">注册</t-button>
      </t-form-item>
    </t-form>
  </div>
</template>
<script setup lang="ts">
import {MessagePlugin} from 'tdesign-vue-next';
import {DesktopIcon, LockOnIcon} from 'tdesign-icons-vue-next';
import {reactive, ref, getCurrentInstance, nextTick} from 'vue'
import QRCode from 'qrcodejs2-fixes';


const form = ref(null);
const formData = reactive({
  account: '',
  password: '',
  code: '',
});

const accountPattern = /^[a-zA-Z0-9\u4e00-\u9fa5]{8,40}$/;

const rules = {
  account: [
    {required: true, message: '请输入账号', type: 'error'},
    {pattern: accountPattern, message: '请输入8-40位数字字母汉字组合账号', type: 'error'},
  ],
  password: [
    {required: true, message: '请输入密码', type: 'error'},
    {pattern: /^[a-zA-Z0-9\u4e00-\u9fa5]{8,20}$/, message: '请输入8-20位数字字母汉字组合账号', type: 'error'},
  ],
  code: [
    {required: true, message: '请输入动态口令', type: 'error'},
    {pattern: /^[0-9]{6}$/, message: '请输入6位数字口令', type: 'error'},
  ]
};


const currentInstance = getCurrentInstance()
const $http = currentInstance.appContext.config.globalProperties.$http

const generateSecret = () => {
  if (!accountPattern.test(formData.account)) {
    return MessagePlugin.warning("请输入正确的账号");
  }

  $http({
    method: "GET",
    url: "/activity/public/getSecret",
    params: {
      'account': formData.account
    }
  }).then(function (response) {
    console.log("data:" + response.data);
    if (response.data.code === 0) {
      initQrcode(response.data.data);
    } else {
      MessagePlugin.warning(response.data.msg);
    }
  }).catch(function (error) {
    MessagePlugin.warning("获取动态口令失败，请稍后再试")
  })
};


const onSubmit = ({validateResult, firstError, e}) => {
  e.preventDefault();
  if (validateResult === true) {
    $http({
      method: "POST",
      url: "/activity/public/register",
      header: {
        'Content-Type':'application/json'
      },
      data: {
        'account': formData.account,
        'password': formData.password,
        'code': formData.code
      }
    }).then(function (response) {
      console.log("data:" + response.data);
      if (response.data.code === 0) {
        localStorage.setItem("token", response.data.data.token)
      } else {
        MessagePlugin.warning(response.data.msg);
      }
    }).catch(function (error) {
      MessagePlugin.warning("获取动态口令失败，请稍后再试")
    })
  } else {
    MessagePlugin.warning(firstError);
  }
};

const qrcodeRef = ref<HTMLElement | null>(null);
const initQrcode = (secret: String) => {
  nextTick(() => {
    (qrcodeRef.value).innerHTML = '';
    new QRCode(qrcodeRef.value, {
      text: secret,
      width: 200,
      height: 200,
      colorDark: '#000000',
      colorLight: '#ffffff'
    })
  })
}

</script>
<style scoped>
.register-form {
  width: 350px;
  float: right;
  padding: 10px;
}

.register-qrcode {
  float: left;
  padding: 50px;
}
</style>

