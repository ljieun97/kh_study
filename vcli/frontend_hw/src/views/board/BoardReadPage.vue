<template>
    <div align="center">
        <h2>게시판 읽기</h2>
        <!--boardRead 컴포넌트-->
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중......</p>
        <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'BoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardRead from '@/components/board/BoardRead'
import axios from 'axios'

export default {
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        BoardRead
    },
    computed: {
        ...mapState(['board'])
    },
    created() {
        this.fetchBoard(this.boardNo)
            .catch(()=>{
                alert('게시물 요청 실패')
                this.$router.push()
            })
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete() {
            const {boardNo} = this.board
            //alert('지우는 게시물 번호: '+boardNo)
            axios.delete(`http://localhost:7777/vueBoard/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    this.$router.push({name: 'BoardListPage'})
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
            
        }
    }
}
</script>