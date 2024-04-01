import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('../views/VHome.vue')
    },
    {
      path: '/Login',
      name: 'Sesion',
      component: () => import('../views/VSesion.vue')
    },
    {
      path:'/Registro',
      name:'Registro',
      component: () => import('../views/VRegistro.vue')
    },
    {
      path:'/Registro/menu',
      name:'Registromenu',
      component: () => import('../views/Vmenu.vue')
    }
  ]
})

export default router
