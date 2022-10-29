<script setup lang="ts">
import { ref, onMounted, type Ref } from 'vue'
import HelloController from '../api/publicPath/HelloController'
import MessageModel from '../api/models/MessageModel'

let response: Ref<Object | undefined> = ref()

onMounted(async () => {
    const controller = new HelloController()
    const json = await controller.getHelloWord()
    const messageModel = new MessageModel(json.message)
    response.value = messageModel.message
})
</script>

<template>
    <main class="contain">
        <h2>Calling the api</h2>
        <span>{{ response }}</span>
        <p>Lorem ipsum dolor.</p>
    </main>
</template>

<style lang="css">
.contain {
    text-align: center;
}
</style>
