<template>
    <div class="home">
        <div id="header">
            <!--라우터의 네임이랑 맞춤-->
            <router-link style="text-decoration: none;" :to="{name: 'HomeView'}"
                class="nav-link"
                active-class="active">
                &nbsp;Home
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'TestView'}">
                &nbsp;Test&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'BoardListPage'}">
                &nbsp;BoardListPage&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'Concave'}">
                &nbsp;Concave&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{ name: 'EventBusTestPage' }">
                &nbsp;Eventbus&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'VuetifyTestPage'}">
                &nbsp;VuetifyUITest&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'VuetifyImageTestPage'}">
                &nbsp;VuetifyImage&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'CoverflowTestPage'}">
                &nbsp;Coverflow&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'AwesomeSwiperTestPage'}">
                &nbsp;AwesomeSwiper&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'ImageGalleryTestPage'}">
                &nbsp;ImageGallery&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'CalendarTestPage'}">
                &nbsp;Calendar&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'FileUploadPage'}">
                &nbsp;FileUpload&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{name: 'VuetifyMemberRegisterPage'}">
                &nbsp;VuetifyMemberRegisterPage&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{ name: 'VuetifyMemberJoinColumnTestPage' }">
                &nbsp;Vuetify Member Join Column Test&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{ name: 'LoginTestPage' }">
                &nbsp;LoginTest&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{ name: 'JpaBoardListPage' }">
                &nbsp;JpaBoardList&nbsp;
            </router-link>
            <router-link style="text-decoration: none;" :to="{ name: 'JpaMemberAuthTestPage' }">
                &nbsp;BusinessMemberCheck&nbsp;
            </router-link>
            <p>
                Homework:
                <router-link style="text-decoration: none;" :to="{name: 'RolePlayGame'}">
                    &nbsp;RolePlayGame&nbsp;
                </router-link>
                <router-link style="text-decoration: none;" :to="{name: 'ProductBoardListPage'}">
                    &nbsp;상품게시판&nbsp;
                </router-link>
            </p>
        </div>
        <h1>Vue 홈 페이지</h1>
    </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
  }
}
</script>
