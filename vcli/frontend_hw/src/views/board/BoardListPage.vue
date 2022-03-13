<template>
    <div id="board">
        <h2>Vue + Spring 게시판</h2>
        <router-link :to="{name: 'BoardRegisterPage'}">
            게시물 작성
        </router-link>
        <!-- v-bind:board="boards"와 같으며 아래와 같이 생략 가능 
        boardList를 로컬컴포넌트로 등록하여 state로 받아온 boards값을 전달-->
        <board-list :boards="boards"/>
    </div>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'

//다른 파일에 있는 내용을 참조할 때
export default {
    name: 'BoardListPage',
    //사용할 컴포넌트들, 위치는 template에서 선언
    components: {
        BoardList
    },
    computed: {
        //현재 state의 보드 값을 this에 매핑
        ...mapState(['boards'])
    },
    mounted () {
        //methods에서 가져온 보드 호출하여 Mutations.js을 통해 state에 보드정보를 넣음
        this.fetchBoardList()
    },
    methods: {
        //store에 action에 있는 fetchBoardList와 매핑하여
        //보드전체를 가져올 수 있게됨
        ...mapActions(['fetchBoardList'])
    }
}
</script>