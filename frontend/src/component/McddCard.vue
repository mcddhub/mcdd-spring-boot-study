<script setup lang="ts">
import { defineProps } from 'vue'

const props = defineProps<{
  name: string;
  imgUrl: string;
}>();
</script>
<template>
  <div class="mcdd-card">
    <img :src="imgUrl" :alt="name" class="mcdd-card-image">
    <div class="mcdd-card-name">{{ name }}</div>
  </div>
</template>

<style scoped>
.mcdd-card {
  background-color: var(--el-bg-color);
  border-radius: 8px;
  box-shadow: var(--el-box-shadow-light);
  overflow: hidden;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.mcdd-card:hover {
  transform: translateY(-5px);
  box-shadow: var(--el-box-shadow);
}

.mcdd-card-image {
  width: 100%;
  height: auto;
  object-fit: cover;
}

.mcdd-card-name {
  padding: 10px;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: var(--el-text-color-primary);
}

html.dark .mcdd-card {
  background-color: var(--el-bg-color-overlay);
}

html.dark .mcdd-card-name {
  color: var(--el-text-color-primary);
}
</style>