<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="500">제목</th>
                <th align="center" width="150">가격</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productNo">
                <td align="center">
                    {{ product.productNo }}
                </td>
                <td align="left">
                    <!-- <router-link :to="{
                        name: 'ProductReadPage',
                        params: {productNo: product.productNo.toString()}}">
                    {{ product.title }}
                    </router-link> -->
                    {{ product.title }}
                </td>
                <td align="right">
                    {{ product.price }}
                </td>
                <td align="right">
                    {{ product.writer }}
                </td>
                <td align="center">
                    {{ product.regDate }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'ProductList',
    props: {
        products: {
            type: Array
        }
    },
    beforeUpdate () {
        console.log('check: ' + this.products)
    }
}
</script>

<style scoped>

</style>