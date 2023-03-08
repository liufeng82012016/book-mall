import {createApp} from 'vue'
import './style.css'
import App from './App.vue'
import axios from 'axios'
import 'tdesign-vue-next/es/style/index.css';

import {createPinia} from 'pinia'

// let loadingInstance = null;
axios.defaults.baseURL = "http://localhost:8080"
// 配置请求拦截器
axios.interceptors.request.use(config => {
    // loadingInstance = ElLoading.service({fullscreen: true});
    // 添加header
    config.headers.Authorization = "";
    // 固定写法
    return config;
})
// 配置相应拦截器
axios.interceptors.response.use(function (response) {
        // if (loadingInstance) {
        //     关闭loading效果
        // loadingInstance.close();
        // }
        // 固定写法
        return response;
    }, function (error) {
        console.log("error:" + JSON.stringify(error))
        return Promise.reject(error);
    }
)
const pinia = createPinia();


let app = createApp(App);
app.config.globalProperties.$http = axios
app.use(pinia)
app.mount('#app')
