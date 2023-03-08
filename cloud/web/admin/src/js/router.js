import {createRouter, createWebHashHistory} from 'vue-router'


const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        // {path: "/", redirect: '/home'},
    ]
})
router.beforeEach(() => {
    console.log('ok');
})

export default router