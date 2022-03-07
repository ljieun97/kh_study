
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
            <router-link :to="{name: 'Game'}"
                class="nav-link"
                active-class="active">
                Game
            </router-link>
        </div>

        <h1>Vue 테스트 페이지</h1>
        <div id="app">
            <p>{{ msg }}</p>

            <!--컴포넌트 이름은 이니셜마다 하이픈 넣어줘야함-->
            <!--v-bind가 컴포넌트 전역변수의 props과 연결-->
            <global-component v-bind:initial-test="counter">
            </global-component>

            <!--v-bind가 컴포넌트 지역변수의 props과 연결-->
            <local-component v-bind:num="value">
            </local-component>
            <button v-on:click="plus">좋아요</button>
        </div>
    </div>
</template>

<script>
import Vue from 'vue'
import GlobalComponent from '@/components/test/GlobalComponent.vue'
import LocalComponent from '@/components/test/LocalComponent.vue'

//전역변수: 어디서도 사용 가능하도록 만들어야함 -> 우리 실력엔 만들기 힘듦
Vue.component(GlobalComponent.name, GlobalComponent)

export default {
    //지역변수: 필요한 곳에만 사용 가능하도록 만듦
    components: {
        'local-component': LocalComponent
    },
    data () {
        return {
            counter: 0,
            value: 0,
            msg: '이래서 좋음'
        }
    },
    methods: {
        plus() {
            this.value++
        }
    }
}
</script>