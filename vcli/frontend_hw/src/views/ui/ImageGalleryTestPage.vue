<template>
    <div>
        <v-container>
            <v-row>
                <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                    <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                        <template v-slot:placeholder>
                            <v-row class="fill-height ma-0" align="center" justify="center">
                                <v-progress-circular indeterminate color="grey lighten-5">
                                </v-progress-circular>
                            </v-row>
                        </template>
                    </v-img>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
export default {
    data() {
        return {
            images: [
                require('@/assets/logo.png'),
                require('@/assets/img/kirby.png'),
                'https://w.namu.la/s/6d229410e3814f0113aa79f1d1ff269d0445aaa0d6dfe50223a65d5b8260cfecf5d926136fb31c18d75a2eb8b4ecccc3e6c8a5bc2a5fa9712162c9d99585db47b545c3d079fbd142bf18798129b3cb997c4cd8dcde54dc8cf7dcc802261025f6',
                'https://w7.pngwing.com/pngs/622/549/png-transparent-pokemon-black-white-pikachu-pachirisu-pokemon-minccino-pikachu.png',

            ]
        }
    },
}
</script>