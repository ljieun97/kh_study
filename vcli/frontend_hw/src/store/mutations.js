import {
    FETCH_BOARD,
    FETCH_BOARD_LIST,
    FETCH_PRODUCT_LIST
} from './mutation-types'

export default {
    [FETCH_BOARD_LIST] (state, boards) {
        state.boards = boards
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    },
    [FETCH_PRODUCT_LIST] (state, products) {
        state.products = products
    }
}