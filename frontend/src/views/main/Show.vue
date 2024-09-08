<script setup lang="ts">
import McddCard from '@/component/McddCard.vue'
import { onMounted, ref } from 'vue'
import { get } from '@/net'

interface CardItem {
  id: number;
  seriesId: number;
  name: string;
  imgUrl: string;
}

const cardData = ref<CardItem[]>([]);

onMounted(() => {
  fetchCardData();
});

const fetchCardData = () => {
  get('/api/v1/mcdd/mcdds', (data: CardItem[]) => {
    cardData.value = data;
  });
};
</script>

<template>
  <div class="card-container">
    <McddCard
      v-for="item in cardData"
      :key="item.id"
      :name="item.name"
      :imgUrl="item.imgUrl"
    />
  </div>
</template>

<style scoped>
.card-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 20px;
  padding: 20px;
}
</style>