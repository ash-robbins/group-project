<template>
  <div class = "prizeform">
    <!-- <button v-if="updateButton" v-on:click.prevent="updateButton = false">Set new Prize</button> -->
    <button id="update-button" v-if="updateButton" v-on:click.prevent="getPrizeWinner">Family Member Prize Winner</button>

    <div v-else>
     <div>Winner is : {{this.prizeWinner.username}}</div>
      <div>With total number of Pages read: {{this.prizeWinner.totalPages}} pages</div>
      <img src="https://i.gifer.com/2cOJ.gif"/>

    </div>
      <!-- <form v-else v-on:submit.prevent="postPrize">
        <label for="prize-description">Prize Description:  </label>
        <input id="prize description" class="prize-input" type="text" placeholder="Prize Description" v-model="prize.description"/><br>
        
        <label for="prize-startdate">Start Date:  </label>
        <input id="prize-startdate" class="prize-input" type="date" v-model="prize.startDate"/> <br>
        
        <label for="prize-enddate">End Date:  </label>
        <input id="prize-enddate" class="prize-input" type="date" v-model="prize.endDate"/><br>
        
        <input id="submit_prize" type="submit" value="Submit"/>

      </form> -->
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
      }, 
      prizeWinner:{
        username: '',
        totalPages: ''
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
    getPrizeWinner(){
    prizeService.getPrizeWinner()
    .then(response=>{
      this.prizeWinner = response.data
      this.updateButton = false;
    })

   
    },
    cancel(){
        this.$router.push('/')
    }
    }

}
</script>

<style scoped>
#update-button,#submit_prize  {
    width: 220px;
    background: linear-gradient(to right,#00afef,#ad63f1 );
    color: white;
    border-radius: 15px;
    border: none;
    outline: none;
    padding: 23px 0;
    margin-top: 10px;
    cursor: pointer;
    margin-left: 10px;
}

#update-button:hover,#submit_prize:hover {
  background: linear-gradient(to right,#102770,#ad63f1 );
  color: #ffffff;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}

.prizeform{
  display: flex;
 
  justify-content: center;
  margin-top: 50px;
  
  
  background-size: cover;
  background-position: center;
  border-radius: 15px;
  margin-bottom: 1rem;
  background-color: #D3D3D3;
  padding: 1rem; 
  border-radius: 15px;
  
  
  
}
 .prize-input {
  /* width: 40%;
  height: 40px;
  border: 1px solid black;
  padding: 0 20px;
  border-radius: 15px;
  outline: none;
  font-weight: 400;
  font-size: 14px;
  transition: all 0.5s ease;
  margin-top: 5px;
  color: black; */
  
    width: 90%;
    height: 40px;
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