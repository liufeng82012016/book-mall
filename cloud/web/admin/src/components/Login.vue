<template>
  <div class="fullscreen container">
    <div>
      <h3>书城</h3>
      <el-form ref="ruleFormRef" :model="ruleForm" status-icon
               :rules="rules" label-width="120px" class="demo-ruleForm">
        <el-form-item label="账号" prop="account">
          <el-input v-model="ruleForm.account" type="text" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input v-model="ruleForm.pass" type="password" autocomplete="off"/>
        </el-form-item>
        <el-form-item label="口令" prop="code">
          <el-input v-model="ruleForm.code"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(ruleFormRef)">登录</el-button>
          <el-button @click="resetForm(ruleFormRef)">清空</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script lang="ts" setup>
import {reactive, ref} from 'vue'
import type {FormInstance} from 'element-plus'

const codePattern = /^\d{6}$/;
const accountPattern = /^[a-zA-Z0-9\u4e00-\u9fa5]{8,40}$/;
const passPattern = /^[a-zA-Z0-9]{8,20}$/;

console.log("test:" + codePattern.test('098632'));
console.log("test2:" + accountPattern.test('poi096gfddr'));

const ruleFormRef = ref<FormInstance>()
// 定义方法
const checkCode = (rule: any, value: any, callback: any) => {
  console.log("code:" + value + ",match:" + codePattern.test(value))
  if (!value || !codePattern.test(value)) {
    return callback(new Error('请输入6位数字口令'))
  }
  setTimeout(() => {
    callback()
  }, 1000)
}

const validatePass = (rule: any, value: any, callback: any) => {
  console.log("pass:" + value + ",match:" + passPattern.test(value))

  if (value === '' || !passPattern.test(value)) {
    callback(new Error('请输入8-20位数字字母组合的密码'))
  } else {
    callback()
  }
}
const validateAccount = (rule: any, value: any, callback: any) => {
  console.log("account:" + value + ",match:" + accountPattern.test(value))

  if (value === '' || !accountPattern.test(value)) {
    callback(new Error('请输入8-40位数字字母汉字组合账号'))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  account: '',
  pass: '',
  code: '',
})

const rules = reactive({
  account: [{validator: validateAccount, trigger: 'blur'}],
  pass: [{validator: validatePass, trigger: 'blur'}],
  code: [{validator: checkCode, trigger: 'blur'}],
})

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!')
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<style lang="less">
.container {
  display: flex;
  align-items: center;
  justify-content: space-evenly;

  background: linear-gradient(-45deg, #5290ee, #78da93, #c8ce74, #55e3c1);
  background-size: 600% 600%;
  animation: gradientBG 5s ease infinite;

  input {
    width: 180px;
  }
}

@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

</style>
