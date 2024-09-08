import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('@/views/IndexView.vue'),
      children: [
        {
          path: '',
          name: 'show',
          component: () => import('@/views/main/Show.vue')
        },
        {
          path: 'manage',
          name: 'manage',
          component: () => import('@/views/main/Manage.vue')
        }
      ]
    }
  ]
})

export default router
