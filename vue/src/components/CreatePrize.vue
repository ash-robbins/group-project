<template>
  <div>
    <button v-if="updateButton" v-on:click.prevent="updateButton = false">Set new Prize</button>
      <form v-else v-on:submit.prevent="createNewPrize">
        <label>Prize description</label>
        <input class="prize-input" type="text" placeholder="Prize description" v-model="prize.description"/>
        <label>Start Date</label>
        <input class="prize-input" type="date" v-model="prize.start_date"/>
        <label>End Date</label>
        <input class="prize-input" type="date" v-model="prize.end_date"/>
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