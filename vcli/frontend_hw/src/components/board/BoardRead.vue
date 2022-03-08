<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="board.boardNo" readonly/>
                </td>
            </tr>
                <tr>
                <td>제목</td>
                <td>
                    <input type="text" :value="board.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" :value="board.writer" readonly/>
                </td>
            </tr>
                        <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="board.regDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="50" rows="20" :value="board.content" readonly>
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
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            require:true
        }
    }
}
</script>