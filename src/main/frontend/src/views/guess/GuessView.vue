<script setup lang="ts">
import { ref } from 'vue';


const header = ref("Welcome Guess")

</script>

<template>
    <div class="contain">
        <h2>{{ header }}</h2>
    </div>
</template>