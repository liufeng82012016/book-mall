<template>
  <div class="login-form">
    <t-form ref="form" :data="formData" :rules="rules" @reset="onReset" @submit="onSubmit" :label-width="0">
      <t-form-item>
        <t-space>
          <t-select v-model="formData.type" placeholder="请选择登录方式">
            <t-option v-for="item in loginTypeOptions" :key="item.value" :value="item.value"
                      :label="item.label"></t-option>
          </t-select>
        </t-space>
      </t-form-item>
      <t-form-item label="账号" help="" name="account" :required-mark="false">
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
        <t-button block type="submit">登录</t-button>
      </t-form-item>
    </t-form>
  </div>

</template>
<script setup>
import {ref, reactive} from 'vue';
import {MessagePlugin} from 'tdesign-vue-next';
import {DesktopIcon, LockOnIcon} from 'tdesign-icons-vue-next';


const form = ref(null);
const formData = reactive({
  account: '',
  password: '',
  code: '',
  type: '1',
});

const rules = {
  account: [
    {required: true, message: '请输入账号', type: 'error'},
    {pattern: /^[a-zA-Z0-9\u4e00-\u9fa5]{8,40}$/, message: '请输入8-40位数字字母汉字组合账号', type: 'error', trigger: 'blur'},
  ],
  password: [
    {required: true, message: '请输入密码', type: 'error'},
    {pattern: /^[a-zA-Z0-9\u4e00-\u9fa5]{8,20}$/, message: '请输入8-20位数字字母汉字组合账号', type: 'error', trigger: 'blur'},
  ],
  code: [
    {required: true, message: '请输入动态口令', type: 'error'},
    {pattern: /^[0-9]{6}$/, message: '请输入6位数字口令', type: 'error', trigger: 'blur'},
  ]
};

const loginTypeOptions = [
  {label: '账户名登录', value: '1'},
  {label: '手机号登录', value: '2'},
  {label: '邮箱登录', value: '3'},
];

const onReset = () => {
  MessagePlugin.success('重置成功');
};

const onSubmit = ({validateResult, firstError, e}) => {
  e.preventDefault();
  if (validateResult === true) {
    MessagePlugin.success('提交成功');
  } else {
    console.log('Validate Errors: ', firstError, validateResult);
    MessagePlugin.warning(firstError);
  }
};

const handleClear = () => {
  form.value.clearValidate();
};
</script>
<style scoped>
.login-form {
  width: 350px;
  padding: 10px;
  float: right;
}
</style>

