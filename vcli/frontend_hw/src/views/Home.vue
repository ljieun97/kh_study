<template>
    <div class="home">
        <div id="header">
            <!--라우터의 네임이랑 맞춤-->
            <router-link :to="{name: 'Home'}"
                class="nav-link"
                active-class="active">
                Home
            </router-link>
            <router-link :to="{name: 'Test'}">
                Test
            </router-link>
            <router-link :to="{name: 'BoardListPage'}">
                BoardListPage
            </router-link>
            <router-link :to="{name: 'Concave'}">
                Concave
            </router-link>
            <router-link :to="{name: 'Homework'}">
                homework
            </router-link>
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
