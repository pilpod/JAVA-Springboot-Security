<script setup lang="ts">
import { ref } from 'vue'
import { useAuthStore } from "@/stores/auth";
import AuthController from "@/api/auth/AuthController";
import router from '@/router';

const store = useAuthStore()
const username = ref<String>()
const password = ref<String>()
let loginResult = ref<String>()

async function login(): Promise<void> {

    const authController = new AuthController
    if(username.value && password.value) {
        const response:Response = await authController.login(username.value,password.value)
        const json = await response.json()
        const status = response.status
        
        if (status == 200) {
            store.isAuthenticated = true
            store.userRole = json.role
            loginResult.value = "Logged successfully"

            if (store.userRole == "ROLE_USER") {
                router.push('guess')
            } else {
                router.push('admin')
            }
        }
    }
}
</script>

<template>
    <div class="login">
        <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label"
                >Username</label
            >
            <div class="col-sm-10">
                <input
                    v-model="username"
                    type="text"
                    class="form-control"
                    id="username"
                />
            </div>
        </div>

        <div class="row mb-3">
            <label for="password" class="col-sm-2 col-form-label"
                >Password</label
            >
            <div class="col-sm-10">
                <input
                    v-model="password"
                    type="password"
                    class="form-control"
                    id="password"
                />
            </div>
        </div>
    </div>
    <button
        :disabled="!username || !password"
        @click="login"
        class="btn btn-primary"
    >
        Login
    </button>
</template>
