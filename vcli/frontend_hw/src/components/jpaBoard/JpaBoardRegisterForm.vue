<template>
    <!--등록을 누르면 아래 온서밋을 실행하라-->
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" v-model="writer"/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{name: 'BoardListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data() {
        return {
            title: '제목을 작성하세요.',
            writer: '너님',
            content: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit() {
            const { title, writer, content } = this
            //에밋: 보드레지스터페이지의 온서밋을 동작시킴
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>