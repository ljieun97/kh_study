<template>
    <div align="center">
        <h2>게시물 수정</h2>
        <jpa-board-modify-form v-if="jpaBoard" :jpaBoard="jpaBoard" @submit="onSubmit"/>
        <p v-else>로딩중......</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import JpaBoardModifyForm from '@/components/jpaBoard/JpaBoardModifyForm'

export default {
    name: 'JpaBoardModifyPage',
    components: {
        JpaBoardModifyForm
    },
    props: {
        boardNo: {
            type: String,
            require: true
        }
    },
    computed: {
        ...mapState(['jpaBoard'])
    },
    methods: {
        ...mapActions(['fetchJpaBoard']),
        onSubmit(payload) {
            const {title, content} = payload
            axios.put(`http://localhost:7777/jpaBoard/${this.boardNo}`, {title, writer: this.jpaBoard.writer, content, regData: this.jpaBoard.regData})
                .then(res => {
                    alert('게시물 수정 성공')
                    this.$router.push({
                        name: 'JpaBoardListPage',
                        params: {boardNo: res.data.boardNo.toString()}
                    })
                })
                .catch(()=>{
                    alert('게시물 수정 실패')
                })
        }
    },
    created() {
        this.fetchJpaBoard(this.boardNo)
            .catch(()=> {
                alert('게시물 조회 실패')
                this.$router.back()
            })
    }
}
</script>