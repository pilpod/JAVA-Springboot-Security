import type { BlobOptions } from "buffer";
import { defineStore } from "pinia";
import { ref, type Ref } from "vue";

export const useAuthStore = defineStore('auth', () => {
    
    let isAuthenticated: Ref<boolean> = ref(false);

    return { isAuthenticated }
})