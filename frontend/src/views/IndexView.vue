<template>
  <el-container class="main-container">
    <el-header class="main-header">
      <el-image
        style="height: 30px"
        src="https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/202408291933864.svg"
      />
      <div class="tabs">
        <tab-item
          v-for="item in tabs"
          :name="item.name"
          :active="item.id === tab"
          @click="changePage(item)"
        />
        <el-switch
          style="margin: 0 20px"
          v-model="dark"
          active-color="#424242"
          :active-action-icon="Moon"
          :inactive-action-icon="Sunny"
        />
        <div style="text-align: right; line-height: 16px; margin-right: 10px">
          <div>
            <el-tag type="success" size="small">MCDD-Hub</el-tag>
          </div>
        </div>
      </div>
    </el-header>
    <el-main class="main-content">
      <router-view v-slot="{ Component }">
        <transition name="el-fade-in-linear" mode="out-in">
          <keep-alive exclude="show">
            <component :is="Component" />
          </keep-alive>
        </transition>
      </router-view>
    </el-main>
  </el-container>
</template>

<script setup>
import TabItem from '@/component/TabItem.vue'
import router from '@/router'
import { Moon, Sunny } from '@element-plus/icons-vue'
import { ref } from 'vue'
import { useDark } from '@vueuse/core'
import { useRoute } from 'vue-router'

const route = useRoute()
const dark = ref(useDark())
const tabs = [
  { id: 1, name: '展示', route: 'show' },
  { id: 2, name: '管理', route: 'manage' }]
const defaultIndex = () => {
  for (let tab of tabs) {
    if (route.name === tab.route) return tab.id
  }
  return 1
}
const tab = ref(defaultIndex())

function changePage(item) {
  tab.value = item.id
  router.push({ name: item.route })
}
</script>

<style scoped>
.main-container {
  height: 100vh;
  width: 100vw;

  .main-header {
    height: 55px;
    background-color: var(--el-bg-color);
    border-bottom: solid 1px var(--el-border-color);
    display: flex;
    align-items: center;

    .tabs {
      height: 55px;
      gap: 10px;
      flex: 1px;
      display: flex;
      align-items: center;
      justify-content: right;
    }
  }

  .main-content {
    height: 100%;
    background-color: #f5f5f5;
  }
}

.dark .main-container .main-content {
  background-color: #232323;
}
</style>
