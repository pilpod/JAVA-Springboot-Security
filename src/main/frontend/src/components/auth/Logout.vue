<script setup lang="ts">
import router from '@/router';
import { useAuthStore } from '@/stores/auth';

const store = useAuthStore();

const logout = () => {
    store.isAuthenticated = false;
    store.userRole = "";
    router.push('/');
}
</script>

<template>
    <a @click="logout"> Logout </a>
</template>