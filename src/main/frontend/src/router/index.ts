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

router.beforeEach(async (to, from) => {
    
    if (to.meta.requiresAuth && 
        useAuthStore().isAuthenticated && 
        useAuthStore().userRole == "ROLE_USER" && 
        to.name !== 'guess'
    ) {
        return { name: 'guess' }
    }
    
    if ( to.meta.requiresAuth && 
        useAuthStore().isAuthenticated && 
        useAuthStore().userRole == "ROLE_ADMIN" && 
        to.name !== 'admin'
    ) {
        return { name: 'admin' }
    }

    if (to.meta.requiresAuth && !useAuthStore().isAuthenticated) {
        return {
            path: '/login',
            query: { redirect: to.fullPath }
        }
    }
})

export default router
