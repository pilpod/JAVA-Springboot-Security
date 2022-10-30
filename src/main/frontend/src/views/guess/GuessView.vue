<script setup lang="ts">
import Logout from '@/components/auth/Logout.vue';
import { ref } from 'vue';


const header = ref("Welcome Guess")

</script>

<template>
    <div class="contain">
        <h2>{{ header }}</h2>
    </div>
</template>