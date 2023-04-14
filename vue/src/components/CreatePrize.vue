<template>
  <div>
      
        <button v-if="updateButton" v-on:click.prevent="updateButton = false">Set new Prize</button>
        <form v-else v-on:submit.prevent="createNewPrize">
          <label>Prize description</label>
          <input type="text" placeholder="Prize description" v-model="prize.description"/>
          <label>Start Date</label>
          <input type="date" v-model="prize.start_date"/>
           <label>End Date</label>
          <input type="date" v-model="prize.end_date"/>
          <input type="submit" value="Submit"/>
        </form>
      

      </div>
</template>

<script>
export default {
    name: 'create-prize',
    data(){
        return{
            updateButton: true,
            prize:{
                description: '',
                start_date: '',
                end_date: ''
            }
        }
    }

}
</script>

<style>

</style>