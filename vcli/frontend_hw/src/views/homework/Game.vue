<template>
  <div class="game">
    <div id="header">
            <router-link :to="{name: 'Home'}"
                class="nav-link"
                active-class="active">
                Home
            </router-link>
            <router-link :to="{name: 'Homework'}"
                class="nav-link"
                active-class="active">
                homework
            </router-link>
        </div>
    <h1>Vue RolePlayGame</h1>

    <h3>상태</h3>
        <p>HP: {{ Math.floor(characterStatus.hp) }} MP: {{ Math.floor(characterStatus.mp) }}
            ATK: {{ Math.floor(characterStatus.atk) }} Lv: {{ Math.floor(characterStatus.level) }}</p>
        <p>STR: {{ Math.floor(characterStatus.str) }} INT: {{ Math.floor(characterStatus.intelligence) }}
            DEX: {{ Math.floor(characterStatus.dex) }} VIT: {{ Math.floor(characterStatus.vit) }}
            DEF: {{ Math.floor(characterStatus.def) }} MEN: {{ Math.floor(characterStatus.men) }}</p>
        <p>현재 경험치 상태: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
        <p>소지금: {{ characterStatus.money }}</p>

    <h3>인벤토리</h3>
        <label>
            <input type="checkbox" v-model="inventoryView">
            소지품 보기
        </label>
        <button v-on:click="equipItem()">아이템 장착!</button>
        <table border="1" v-if="inventoryView">
            <tr>
                <th align="center" width="40">번호</th>
                <th align="center" width="120">아이템명</th>
                <th align="center" width="320">아이템 설명</th>
                <th align="center" width="40">장착</th>
            </tr>
            <tr v-for="(ilist, idx) in inventory" v-bind:key="ilist.idx">
                <th align="center" width="40">{{ idx + 1 }}</th>
                <th align="center" width="120">{{ ilist.name }}</th>
                <th align="center" width="320">{{ ilist.effect.desc }}</th>
                <th align="center" width="40">
                    <label>
                        <input type="checkbox"
                                v-model="inventoryValue"
                                v-bind:value="idx">
                    </label>
                </th>
            </tr>
        </table>
    <h3>상점</h3>
        <label>
            <input type="checkbox" v-model="shopListView" v-on:click="shuffleShopList()">
            판매 목록
        </label>
        <button v-on:click="calcBuy()">구매 확정!</button>
        <table border="1" v-if="shopListView">
            <tr>
                <th align="center" width="40">번호</th>
                <th align="center" width="120">아이템명</th>
                <th align="center" width="160">가격</th>
                <th align="center" width="320">아이템 설명</th>
                <th align="center" width="40">선택</th>
            </tr>
            <tr v-for="(slist, idx) in shopList" v-bind:key="slist.idx">
                <th align="center" width="40">{{ idx + 1 }}</th>
                <th align="center" width="120">{{ slist.name }}</th>
                <th align="center" width="160">{{ slist.price }}</th>
                <th align="center" width="320">{{ slist.effect.desc }}</th>
                <th align="center" width="40">
                    <label>
                        <input type="checkbox"
                                v-model="shopListValue"
                                v-bind:value="idx">
                    </label>
                </th>
            </tr>
        </table>

    <h3>전장</h3>
    <div>
      <button v-on:click="addMonster">몬스터 추가</button>
      <button v-on:click="addManyMonsters">몬스터 군단 추가</button>
      <button v-on:click="myStealthDarkFlameDragonFear">스텔스 다크 플레임 드래곤 피어!!!!!</button>
    </div>
    <ul>
      <li v-for="(item, index) in list"
          v-bind:key="item.id">
          ID: {{ item.id }} {{ item.name }} HP: {{ item.hp }}
          <button v-on:click="attackMonster(index)">기본 공격</button>
          
      </li>
    </ul>
  </div>
</template>

<script>
export default {
    data () {
        return {
          characterStatus: {
            level: 1,
            hp: 70,
            mp: 30,
            itemAtk: 0,
            defaultAtk: 10,
            atk: 10,
            str: 10,
            intelligence: 10,
            dex: 10,
            vit: 10,
            def: 10,
            men: 0,
            totalLevelBar: 10,
            currentLevelBar: 0,
            money: 0,
            selectJob: '모험가'
        },
          monsterBook: [
            { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
            { monsterId: 2, name: '고블린', hp: 80, exp: 15, dropMoney: 10 },
            { monsterId: 3, name: '사슴', hp: 100, exp: 25, dropMoney: 10 },
            { monsterId: 4, name: '리본돼지', hp: 100, exp: 15, dropMoney: 25 },
            { monsterId: 5, name: '오크', hp: 150, exp: 45, dropMoney: 30 },
            { monsterId: 6, name: '멧돼지', hp: 150, exp: 30, dropMoney: 45 },
            { monsterId: 7, name: '스켈레톤', hp: 200, exp: 70, dropMoney: 55 },
            { monsterId: 8, name: '고블린매지션', hp: 200, exp: 150, dropMoney: 100 },
            { monsterId: 9, name: '소', hp: 500, exp: 200, dropMoney: 150 },
            { monsterId: 10, name: '뱀', hp: 350, exp: 100, dropMoney: 250 },
            { monsterId: 11, name: '곰', hp: 1000, exp: 500, dropMoney: 350 },
            { monsterId: 12, name: '토끼', hp: 50, exp: 5, dropMoney: 100 },
            { monsterId: 13, name: '호랑이', hp: 800, exp: 400, dropMoney: 300 },
            { monsterId: 14, name: '스켈레톤 아처', hp: 150, exp: 150, dropMoney: 5 },
            { monsterId: 15, name: '리치', hp: 2000, exp: 2000, dropMoney: 25 },
            { monsterId: 16, name: '죽음의 군주', hp: 100000, exp: 10000, dropMoney: 100000 },
            { monsterId: 17, name: '골렘', hp: 2000, exp: 3500, dropMoney: 500 },
            { monsterId: 18, name: '와이번', hp: 3500, exp: 3000, dropMoney: 200 },
            { monsterId: 19, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 1000 },
            { monsterId: 20, name: '구울', hp: 120, exp: 20, dropMoney: 1 },
            { monsterId: 21, name: '오우거', hp: 1000, exp: 500, dropMoney: 50 },

            { monsterId: 999, name: '드래곤', hp: 100000, exp: 10000, dropMoney: 100000 },
            { monsterId: 1000, name: '옐로 드래곤', hp: 1000000, exp: 20000, dropMoney: 200000 },
            { monsterId: 1001, name: '그린 드래곤', hp: 10000000, exp: 40000, dropMoney: 400000 },
            { monsterId: 1002, name: '레드 드래곤', hp: 100000000, exp: 80000, dropMoney: 800000 },
            { monsterId: 1003, name: '블루 드래곤', hp: 1000000000, exp: 160000, dropMoney: 1600000 },
            { monsterId: 1004, name: '블랙 드래곤', hp: 10000000000, exp: 300000, dropMoney: 3000000 },
            { monsterId: 1005, name: '골드 드래곤', hp: 100000000000, exp: 1000000, dropMoney: 10000000 },
            { monsterId: 1005, name: '데스 드래곤', hp: 999999999999, exp: 2000000, dropMoney: 20000000 },
            { monsterId: 1007, name: '스텔스 드래곤', hp: 9999999999999, exp: 4000000, dropMoney: 40000000 },
            { monsterId: 1008, name: '리무르', hp: 999999999999999999999999999, exp: 1, dropMoney: 1 },
        ],
          list: [
            { id: 1, name: '슬라임', hp: 100 },
            { id: 2, name: '고블린', hp: 200 },
            { id: 3, name: '사슴', hp: 150 },
            { id: 4, name: '리본돼지', hp: 250},
            { id: 5, name: '슬라임', hp: 100 },
        ],
        itemBook: [
            { name: 'HP 포션 I', price: 50, effect: { desc: 'hp 200 회복', amount: 200 }},
            { name: 'HP 포션 II', price: 200, effect: { desc: 'hp 700 회복', amount: 700 }},
            { name: '낡은 검', price: 500000, effect: { desc: '무기 공격력 100', atk: 100 }},
            { name: '검', price: 2500000, effect: { desc: '무기 공격력 200', atk: 200 }},
            { name: '강철 검', price: 15000000, effect: { desc: '무기 공격력 350', atk: 350 }},
            { name: '발라리아 강철 검', price: 150000000, effect: { desc: '무기 공격력 500', atk: 500 }},
            { name: '화열검', price: 1500000000, effect: { desc: '무기 공격력 700', atk: 700 }},
            { name: '칠지도', price: 150000000000, effect: { desc: '무기 공격력 1000', atk: 1000 }},
        ],
        shopListView: false,
        shopList: [],
        shopListValue: [],
        inventoryView: false,
        inventory: [],
        inventoryValue: []
      }
    },
    methods: {
      equipItem () {
            let tmpSum = 0

            console.log('equipItem(): ' + this.inventoryValue.length)
            console.log('inventory Length: ' + this.inventory.length)

            for (let i = 0; i < this.inventoryValue.length; i++) {
                console.log('외곽 루프 - 선택된 값: ' + this.inventoryValue[i])

                for (let j = 0; j < this.inventory.length; j++) {
                    console.log('내부 루프')

                    if (this.inventoryValue[i] === j) {
                        console.log('매칭 완료')
                        if (this.inventory[j].effect.atk) {
                          tmpSum += this.inventory[j].effect.atk
                        }
                        break
                    }
                }
            }

            this.characterStatus.itemAtk = tmpSum
            this.characterStatus.atk = this.characterStatus.defaultAtk + tmpSum
        },
        shuffleShopList() {
            if (!this.shopListView) {
                this.shopListValue = []
            }

            for (let i = 0; i < 10; i++) {
                let randIdx = Math.floor(Math.random() * this.itemBook.length)
                this.shopList[i] = this.itemBook[randIdx]
            }
        },
        calcBuy() {
            let tmpSum = 0

            console.log('calcBuy(): ' + this.shopListValue.length)
            console.log('shopList Length: ' + this.shopList.length)

            for (let i = 0; i < this.shopListValue.length; i++) {
                console.log('외곽 루프 - 선택된 값: ' + this.shopListValue[i])

                for (let j = 0; j < this.shopList.length; j++) {
                    console.log('내부 루프')

                    if (this.shopListValue[i] === j) {
                        console.log('매칭 완료')
                        tmpSum += this.shopList[j].price
                        break
                    }
                }
            }

            if (this.characterStatus.money - tmpSum >= 0) {
                this.characterStatus.money -= tmpSum

                for (let i = 0; i < this.shopListValue.length; i++) {
                    this.inventory.push({
                        name: this.shopList[this.shopListValue[i]].name,
                        effect: this.shopList[this.shopListValue[i]].effect,
                    })
                }
            } else {
                alert('돈읎다 돈벌어와!')
            }
        },
        addMonster() {
            let max = this.list.reduce(function(a, b) {
                return a > b.id ? a : b.id
            }, 0)

            let idx = Math.floor(Math.random()*this.monsterBook.length)

            this.list.push({
                id: max + 1,
                monsterId: idx,
                name: this.monsterBook[idx].name,
                hp: this.monsterBook[idx].hp
            })
        },
        addManyMonsters() {
            for (let i = 0; i < 100; i++) {
                let max = this.list.reduce(function(a, b) {
                    return a > b.id ? a : b.id
                }, 0)

                let idx = Math.floor(Math.random() * this.monsterBook.length)

                this.list.push({
                    id: max + 1,
                    monsterId: idx,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp
                })
            }
        },
        attackMonster(index) {
            this.list[index].hp -= 10
        },
        myStealthDarkFlameDragonFear() {
            console.log("내안의 보이지 않는 어둠의 흑염룡이 울부짖었다!!! " +
                        "스텔스 다크 플레임 드래곤 피어!!!!!")

            for (let i = 0; i < this.list.length; i++) {
                //this.list[i].hp = parseInt(this.list[i].hp - 1000)
                this.list[i].hp = this.list[i].hp - 1000
            }
        }
    },
    beforeUpdate() {
        console.log('VDOM의 변화를 감지하는 루틴')

        let i
        for (i = 0; i < this.list.length; i++) {
            if (this.list[i].hp <= 0) {
                for (let j = 0; j < this.monsterBook.length; j++) {
                    if (this.list[i].monsterId === this.monsterBook[j].monsterId) {
                        this.characterStatus.currentLevelBar += this.monsterBook[j].exp
                        this.characterStatus.money += this.monsterBook[j].dropMoney
                    }
                }
                this.list.splice(i, 1)
            }
        }
        for (; this.characterStatus.currentLevelBar >= this.characterStatus.totalLevelBar; ) {
            this.characterStatus.currentLevelBar = 
            parseInt(this.characterStatus.currentLevelBar - this.characterStatus.totalLevelBar)

            this.characterStatus.level += 1
            this.characterStatus.hp *= 1.2
            this.characterStatus.mp *= 1.2
            this.characterStatus.defaultAtk += 3
            this.characterStatus.atk += 3
            this.characterStatus.def += 1
            this.characterStatus.str *= 1.2
            this.characterStatus.intelligence *= 1.2
            this.characterStatus.dex *= 1.2
            this.characterStatus.vit *= 1.2
            this.characterStatus.def *= 1.2
            this.characterStatus.men *= 1.2

            if (this.characterStatus.level < 10) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.1)
            } else if (this.characterStatus.level < 30) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.2)
            } else if (this.characterStatus.level < 50) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.3)
            } else if (this.characterStatus.level < 70) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.4)
            } else if (this.characterStatus.level < 80) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.5)
            } else if (this.characterStatus.level < 100) {
                this.characterStatus.totalLevelBar =
                    parseInt(this.characterStatus.totalLevelBar * 1.8)
            }
        }
    }
}
</script>