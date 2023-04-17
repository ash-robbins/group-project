<template>
  <div class="family">
     <form class="new-book-form" v-on:submit.prevent="saveFamily">
    <label for="family-name">Family Name: </label>
    <input class="family-input" type="text" placeholder="Family Name" id="family-name" v-model="family.family_name" /><br><br>
    <label for="family-description"> Family Description: </label>
    <input class="family-input" type="text" placeholder="Family Description" id="family-description" v-model="family.description" /> <br><br>

    <label for="family-code">Family Code: </label>
    <input class="family-input" type="text" placeholder="Family Code" v-model="family.code" /><br><br>
    <button>Save</button>
  </form>
      </div>
  
</template>

<script>
export default {
    name: "add-newfamily-form",
    data() {
        return {
            family: {
                family_name: '',
                description: '',
                code: '',
                username: ''
            }
        }
    },
    methods:{
         saveFamily() {
            this.$store.commit('CREATE_FAMILY', this.family);
            this.family = {
                family_name: '',
                description: '',
                code: '',
                username: ''
            }
            this.$router.push({name: 'books'})
        }
    }

}
</script>

<style>


.family-input  {
  width: 40%;
  height: 40px;
  border: 1px solid white;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 0 20px;
  border-radius: 15px;
  outline: none;
  font-weight: 400;
  font-size: 14px;
  transition: all 0.5s ease;
  margin-top: 5px;
}


</style>