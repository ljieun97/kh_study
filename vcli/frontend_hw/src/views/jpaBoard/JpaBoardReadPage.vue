<template>
    <div align="center">
        <h2>게시판 읽기</h2>
        <jpa-board-read v-if="jpaBoard" :jpaBoard="jpaBoard"/>
        <p v-else>로딩중......</p>
        <router-link :to="{ name: 'JpaBoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'JpaBoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import JpaBoardRead from '@/components/jpaBoard/JpaBoardRead'
import axios from 'axios'

export default {
    name: 'JpaBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        JpaBoardRead
    },
    computed: {
        ...mapState(['jpaBoard'])
    },
    created() {
        this.fetchJpaBoard(this.boardNo)
            .catch(()=>{
                alert('게시물 요청 실패')
                this.$router.push()
            })
    },
    methods: {
        ...mapActions(['fetchJpaBoard']),
        onDelete() {
            const {boardNo} = this.jpaBoard
            axios.delete(`http://localhost:7777/jpaBoard/${boardNo}`)
                .then(()=> {
                    alert('삭제 성공')
                    this.$router.push({name: 'JpaBoardListPage'})
                })
                .catch(()=> {
                    alert('삭제실패 문제발생')
                })
            
        }
    }
}
</script>