import {
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_PRODUCT_LIST
} from './mutation-types'

import axios from 'axios'
// npm install axios --save-dev


//스프링이 리턴한 결과를 res에 저장하고 res.data가 commit에 저장되어 Mutations으로 전달
export default {
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/vueBoard/list')
            .then((res) => {
                commit(FETCH_BOARD_LIST, res.data)
            })
    },
    fetchBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/vueBoard/${boardNo}`)
            .then((res) => {
                commit(FETCH_BOARD, res.data)
            })
    },
    fetchProductList ({commit}) {
        return axios.get('http://localhost:7777/bank13/list')
            .then((res) => {
                commit(FETCH_PRODUCT_LIST, res.date)
            })
    }
}