<template>
    <div class="home">
        <div id="header">
            <router-link :to="{name: 'Home'}"
                class="nav-link"
                active-class="active">
                Home
            </router-link>
            <router-link :to="{name: 'Test'}"
                class="nav-link"
                active-class="active">
                Test
            </router-link>
            <router-link :to="{name: 'BoardListPage'}"
                class="nav-link"
                active-class="active">
                BoardListPage
            </router-link>
            <router-link :to="{name: 'Homework'}"
                class="nav-link"
                active-class="active">
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
