<template>
  <div>
    <button v-if="updateButton" v-on:click.prevent="updateButton = false">Set new Prize</button>
      <form v-else v-on:submit.prevent="postPrize">
        <label for="prize-description">Prize description</label>
        <input id="prize description" class="prize-input" type="text" placeholder="Prize description" v-model="prize.description"/><br>
        <label for="prize-startdate">Start Date</label>
        <input id="prize-startdate" class="prize-input" type="date" v-model="prize.startDate"/> <br>
        <label for="prize-enddate">End Date</label>
        <input id="prize-enddate" class="prize-input" type="date" v-model="prize.endDate"/><br>
        <input type="submit" value="Submit"/>
      </form>
    </div>
</template>

<script>
import prizeService from '../services/PrizeService.js'
export default {
    name: 'create-prize',
    data(){
        return{
            updateButton: true,
            prize: {
            description: '',
            milestone: 0,
            familyId: 0,
            maxPrizes: 0,
            startDate: '',
            endDate: ''
      }
        }
    },
    methods: {
      postPrize(){
    prizeService.postPrize(this.prize)
    .then(response=>{
        if(response.status === 201){
          this.$router.push('/')
        } 
        })
        
    },
    cancel(){
        this.$router.push('/')
    }
    }

}
</script>

<style>

.prize-input {
  width: 50%;
    height: 65px;
    border: 1px solid white;
    background: rgb(226, 226, 226);
    padding: 0 20px;
    border-radius: 15px;
    outline: none;
    font-weight: 400;
    font-size: 14px;
    transition: all 0.5s ease;
    margin-top: 5px;
}

</style>