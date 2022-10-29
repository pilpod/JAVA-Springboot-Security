import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '@/views/auth/LoginView.vue'
import AdminView from '@/views/admin/AdminView.vue'
import { useAuthStore } from '@/stores/auth'
import GuessView from '@/views/guess/GuessView.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView,
        },
        {
            path: '/about',
            name: 'about',
            // route level code-splitting
            // this generates a separate chunk (About.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: () => import('../views/AboutView.vue'),
        },
        {
            path: '/login',
            name: 'login',
            component: LoginView,
        },
        {
            path: '/admin',
            name: 'admin',
            component: AdminView,
            meta: {
                requiresAuth: true,
            },
        },
        {
            path: '/guess',
            name: 'guess',
            component: GuessView,
            meta: {
                requiresAuth: true,
            }
        }
    ],
})

router.beforeEach((to, from, next) => {
    if (to.matched.some((record) => record.meta.requiresAuth)) {
        if (useAuthStore().isAuthenticated && useAuthStore().userRole == "ROLE_USER") {
            next({ name: 'guess'})
        } else if(useAuthStore().isAuthenticated && useAuthStore().userRole == "ROLE_ADMIN") {
            next({ name: 'admin'})
        } else {
            next({
                name: 'login',
            })
        }
    } else {
        next()
    }
})

export default router
