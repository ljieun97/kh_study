<template>
    <div class="slide-3d">
        <v-app id="inspire">
            <v-container>
                <swiper class="swiper" :options="swiperOption">
                    <swiper-slide><v-img src="@/assets/dd.jpeg"/></swiper-slide>
                    <swiper-slide><v-img src="@/assets/dd.jpeg"/></swiper-slide>
                    <swiper-slide>Slide 3</swiper-slide>
                    <div class="swiper-pagination" slot="pagination"></div>
                    <div class="swiper-button-prev" slot="button-prev"></div>
                    <div class="swiper-button-next" slot="button-next"></div>
                </swiper>
            </v-container>
        </v-app>
    </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name: 'AwesomeSwiperTestPage',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            swiperOption: {
                // loop: false,
                effect: 'coverflow',
                grabCursor: true,
                // autoHeight: true,
                // centeredSlides: true,
                // slidesPerView: 'auto',
                // coverflowEffect: {
                //     rotation: 50,
                //     stretch: 0,
                //     depth: 100,
                    // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                    // modifier: 1,
                //     slideShadows: true
                // },
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: false
                },
                navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        },
                // autoplay: {
                //     delay: 1000
                // }
            }
        }
    }
}
</script>

<style lang="scss" scoped>
.slide-3d {
    width: 300px;
    // height: 500px;
    // padding-top: 50px;
    // padding-bottom: 50px;
}
.swiper {
    // height: 100%;
    // width: 100%;
    .swiper-slide {
        // display: flex;
        // justify-content: center;
        // align-items: center;
        width: 300px;
        // height: 300px;
        // text-align: center;
        // font-weight: bold;
        // font-size: 1.7rem;
        background-color: white;
        background-position: center;
        background-size: cover;
    }
    
}
.swiper-button-prev, .swiper-button-next {
  --swiper-theme-color: #ffffff;
}
</style>