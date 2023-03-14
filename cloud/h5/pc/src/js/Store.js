import {defineStore} from 'pinia'

export const useUserInfo = defineStore("userInfo", {
    state: () => ({
        nickname: "",
        avatar: "",
        token: ""
    }),
    getters: {
        // nickname: () => {
        //     return userInfo.nickname;
        // },
        // avatar: () => {
        //     return userInfo.avatar;
        // },
        // token: () => {
        //     return userInfo.token;
        // },
    },
    actions: {
        setToken(token) {
            if (!token) {
                return;
            }
            this.token = token;
            console.log("set token:" + token)
        },
        clearToken() {
            this.token = '';
        }
    }
})