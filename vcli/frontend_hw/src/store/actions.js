import {
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_PRODUCT_BOARD,
    FETCH_PRODUCT_BOARD_LIST,
    FETCH_JPA_BOARD,
    FETCH_JPA_BOARD_LIST,
    FETCH_BUSINESS_MEMBER,
    CRAWL_START
} from './mutation-types'

import axios from 'axios'
import router from '../router'
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
    fetchProductBoardList ({ commit }) {
        return axios.get('http://localhost:7777/bank13/list')
                .then((res) => {
                    commit(FETCH_PRODUCT_BOARD_LIST, res.data)
                })
    },
    fetchProductBoard ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/bank13/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT_BOARD, res.data)
                })
    },
    fetchJpaBoardList ({ commit }) {
        return axios.get('http://localhost:7777/jpaBoard/list')
                .then((res) => {
                    commit(FETCH_JPA_BOARD_LIST, res.data)
                })
    },
    fetchJpaBoard ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/jpaBoard/${boardNo}`)
                .then((res) => {
                    commit(FETCH_JPA_BOARD, res.data)
                })
    },
    fetchBusinessMember ({ commit }) {
        return axios.get('http://localhost:7777/jpaMember/checkBusiness')
                .then((res) => {
                    commit(FETCH_BUSINESS_MEMBER, res.data)
                })
    },
    async crawlFind ({commit}, category) {
        axios.get('http://localhost:7777/crawl/' + `${category}`)
            .then(({data}) => {
                commit(CRAWL_START, data)
                
                if(window.location.pathname !== '/daumNewsCrawl') {
                    router.push('/daumNewsCrawl')
                }
            })
    }
}