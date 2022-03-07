<template>
    <div class="homework">
        <div id="header">
            <router-link :to="{name: 'Home'}"
                class="nav-link"
                active-class="active">
                Home
            </router-link>
            <router-link :to="{name: 'Game'}"
                class="nav-link"
                active-class="active">
                Game
            </router-link>
        </div>
        <h1>Vue 숙제</h1>
    </div>
</template>

<script>
export default {
  name: 'Homework',
  components: {
  }
}
</script>
