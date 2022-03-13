<template>
    <div id="product">
        <h2>ProductList</h2>
        <router-link :to="{name: ''}">
            게시물 작성
        </router-link>
        <product-list :products="products"/>
    </div>
</template>

<script>

import ProductList from '@/components/product/ProductList'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'ProductListPage',
    components: {
        ProductList
    },
    computed: {
        ...mapState(['products'])
    },
    mounted () {
        this.fetchProductList()
    },
    methods: {
        ...mapActions(['fetchProductList'])
    }
}
</script>