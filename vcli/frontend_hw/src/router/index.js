import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import TestView from '@/views/TestView.vue'
import RolePlayGame from '@/views/homework/RolePlayGame'

import BoardListPage from '@/views/board/BoardListPage'
import BoardRegisterPage from '@/views/board/BoardRegisterPage'
import BoardReadPage from '@/views/board/BoardReadPage'
import BoardModifyPage from '@/views/board/BoardModifyPage'

import Concave from '@/views/game/Concave'
import EventBusTestPage from '@/views/eventbus/EventBusTestPage'

import ProductListPage from '@/views/homework/product/ProductListPage'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/test',
    name: 'TestView',
    component: TestView
  },
  {
    path: '/rolePlayGame',
    name: 'RolePlayGame',
    component: RolePlayGame
  },
  {
    path: '/boardList',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/boardRegister',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/boardRead/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    //BoardReadPage Props으로 boardNo을 받을 수 있어짐
    props: {
      default: true
    }
  },
  {
    path: '/boardModify/:boardNo',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/game/concave',
    name: 'Concave',
    component: Concave
  },
  {
    path: '/eventBusTestPage',
    name: 'EventBusTestPage',
    component: EventBusTestPage
  },
  {
    path: '/productList',
    name: 'ProductListPage',
    component: ProductListPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
