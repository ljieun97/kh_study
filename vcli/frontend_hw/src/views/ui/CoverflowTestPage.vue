<template>
    <div>
        <coverflow :margin="0" :coverList="coverList" :coverWidth="260" 
        :index="0"
        />
    </div>
</template>

<script>

import coverflow from 'vue-coverflow'

export default {
    data () {
        return {
            coverList: [
                {
                    cover: require('@/assets/logo.png'),
                    // title: '듄'
                },
                {
                    cover: require('@/assets/logo.png'),
                    // title: '마리오'
                },
                {
                    cover: require('@/assets/logo.png'),
                    // title: '스타벅스'
                },
                {
                    cover: require('@/assets/logo.png'),
                    // title: '듄'
                },
                {
                    cover: require('@/assets/logo.png'),
                    // title: '마리오'
                },
                {
                    cover: 'http://1.bp.blogspot.com/-mVAqnKw_lW8/VL9V6fhewNI/AAAAAAAAAco/-eTiP5HF40I/s1600/3034007-slide-s-3-whats-the-difference-between-a-logo-and-a-symbol.jpg',
                    // title: '스타벅스'
                }
            ]
        }
    },
    components: {
        coverflow
    }
}

</script>