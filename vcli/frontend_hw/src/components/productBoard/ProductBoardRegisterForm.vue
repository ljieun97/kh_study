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
                <td>가격</td>
                <td>
                    <input type="text" v-model="price"/>
                </td>
            </tr>
            <tr>
                <td>설명</td>
                <td>
                    <textarea cols="50" rows="20" v-model="description">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{name: 'ProductBoardListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'ProductBoardRegisterForm',
    data() {
        return {
            title: '제목을 작성하세요.',
            writer: '너님',
            price: '0',
            description: '본문을 작성하세요.'
        }
    },
    methods: {
        onSubmit() {
            const { title, writer, price, description } = this
            //에밋: 보드레지스터페이지의 온서밋을 동작시킴
            this.$emit('submit', { title, writer, price, description })
        }
    }
}
</script>