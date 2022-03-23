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

import ProductBoardListPage from '@/views/productBoard/ProductBoardListPage'
import ProductBoardRegisterPage from '@/views/productBoard/ProductBoardRegisterPage'
import ProductBoardReadPage from '@/views/productBoard/ProductBoardReadPage.vue'
import ProductBoardModifyPage from '@/views/productBoard/ProductBoardModifyPage.vue'

import VuetifyTestPage from '@/views/ui/VuetifyTestPage'
import VuetifyImageTestPage from '@/views/ui/VuetifyImageTestPage'
import CoverflowTestPage from '@/views/ui/CoverflowTestPage'
import AwesomeSwiperTestPage from '@/views/ui/AwesomeSwiperTestPage'
import ImageGalleryTestPage from '@/views/ui/ImageGalleryTestPage'
import CalendarTestPage from '@/views/ui/CalendarTestPage'
import FileUploadPage from '@/views/fileUpload/FileUploadPage'

import VuetifyMemberRegisterPage from '@/views/jpaMember/VuetifyMemberRegisterPage'
import VuetifyMemberJoinColumnTestPage from '@/views/jpaMember/VuetifyMemberJoinColumnTestPage.vue'
import LoginTestPage from '@/views/jpaMember/LoginTestPage'

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
    path: '/productBoardList',
    name: 'ProductBoardListPage',
    component: ProductBoardListPage
  },
  {
    path: '/productBoardRegister',
    name: 'ProductBoardRegisterPage',
    component: ProductBoardRegisterPage
  },
  {
    path: '/productBoardRead/:productNo',
    name: 'ProductBoardReadPage',
    components: {
      default: ProductBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/productBoardModify/:productNo',
    name: 'ProductBoardModifyPage',
    components: {
      default: ProductBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/veutifyTest',
    name: 'VuetifyTestPage',
    component: VuetifyTestPage
  },
  {
    path: '/veutifyImageTest',
    name: 'VuetifyImageTestPage',
    component: VuetifyImageTestPage
  },
  {
    path: '/coverflowTest',
    name: 'CoverflowTestPage',
    component: CoverflowTestPage
  },
  {
    path: '/awesomeSwiperTest',
    name: 'AwesomeSwiperTestPage',
    component: AwesomeSwiperTestPage
  },
  {
    path: '/imageGalleryTest',
    name: 'ImageGalleryTestPage',
    component: ImageGalleryTestPage
  },
  {
    path: '/calendarTest',
    name: 'CalendarTestPage',
    component: CalendarTestPage
  },
  {
    path: '/fileUpload',
    name: 'FileUploadPage',
    component: FileUploadPage
  },
  {
    path: '/vuetifyMemberRegister',
    name: 'VuetifyMemberRegisterPage',
    component: VuetifyMemberRegisterPage
  },
  {
    path: '/vuetifyMemberJoinColumnTest',
    name: 'VuetifyMemberJoinColumnTestPage',
    components: {
      default: VuetifyMemberJoinColumnTestPage
    }
  },
  {
    path: '/loginTest',
    name: 'LoginTestPage',
    components: {
      default: LoginTestPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
