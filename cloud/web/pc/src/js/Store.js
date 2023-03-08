import {defineStore} from 'pinia'

export default useUserInfo = defineStore("userInfo", {
    userInfo: () => ({
        nickname: "",
        avatar: "",
        token: ""
    }),
    getters: {
        nickname: (useUserInfo) => useUserInfo.nickname,
        avatar: (useUserInfo) => useUserInfo.avatar,
        token: (useUserInfo) => useUserInfo.token,
    }, actions: {
        setToken(token: String) {
            if (!token) {
                return;
            }
            this.token = token;
        },
        clearToken() {
            this.token = '';
        }
    }
})