<script setup lang="ts"></script>

<template>
    <div class="login">
        <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label"
                >Username</label
            >
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" />
            </div>
        </div>

        <div class="row mb-3">
            <label for="inputPassword3" class="col-sm-2 col-form-label"
                >Password</label
            >
            <div class="col-sm-10">
                <input
                    type="password"
                    class="form-control"
                    id="inputPassword3"
                />
            </div>
        </div>
    </div>
    <button class="btn btn-primary">Login</button>
</template>
