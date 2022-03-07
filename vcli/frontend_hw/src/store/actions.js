import {
    FETCH_BOARD_LIST,
    //FETCH_BOARD
} from './mutation-types'

import axios from 'axios'
// npm install axios --save-dev


//res에 저장하고 res.data가 commit에 저장되어 Mutations으로 전달
export default {
    fetchBoardList ({ commit }) {
        return axios.get('http://localhost:7777/vueBoard/list')
                .then((res) => {
                    commit(FETCH_BOARD_LIST, res.data)
                })
    }
}