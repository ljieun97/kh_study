<template>
    <div>
        <td @click="onClickTd">{{ cellData }}</td>
    </div>
</template>

<script>
export default {
    data () {
        return {
            game : {
                propTurn: this.turn,
                propWin: this.winner
            }
        }
    },
    props: {
        cellData: String,
        cellIndex: Number,
        rowIndex: Number,
        tableData: Array,
        turn: String,
        winner: String
    },
    methods: {
        onClickTd () {
            if (this.cellDate) {
                return
            }

            this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
            this.$emit('updateWinner', '')

            let win = false

            if (
                this.tableData[this.rowIndex][0] === this.turn &&
                this.tableData[this.rowIndex][1] === this.turn &&
                this.tableData[this.rowIndex][2] === this.turn
            ) {win = true}
            else if (
                this.tableData[0][this.cellIndex] === this.turn &&
                this.tableData[1][this.cellIndex] === this.turn &&
                this.tableData[2][this.cellIndex] === this.turn 
            ) {win = true}
            else if (
                this.tableData[0][0] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][2] === this.turn 
            ) {win = true}
            else if (
                this.tableData[0][2] === this.turn &&
                this.tableData[1][1] === this.turn &&
                this.tableData[2][0] === this.turn 
            ) {win = true}

            //리턴된 PropTurn이랑 tr에서 받아온 turn이랑 비교
            this.game.propTurn = this.turn === 'O' ? 'X' : 'O'

            if (win) {
                this.game.propWin = this.turn
                this.$emit('updateWinner', this.game.propWin)
                this.$emit('updateTurn', this.game.propTurn)
                this.$emit('updateTableData')
            } else {
                let all = true
                this.tableData.forEach(row => {
                    row.forEach(cell => {
                        if(!cell) {
                            all = false
                        }
                    })
                })

                if (all) {
                    this.propWin = ''
                    this.$emit('updateTurn', this.game.propTurn)
                    this.$emit('updateTableData')
                } else {

                    //tr에게 propTurn(turn)을 업데이트하라고 요청
                    //emit은 상위로 한칸올라감
                    this.$emit('updateTurn', this.game.propTurn)
                }
            }
        }
    }
}
</script>

<style scoped>
table {
    border-collapse: collapse;
}

td {
    border: 1px solid black;
    width: 80px;
    height: 80px;
    text-align: center;
}
</style>
