<template>
  <div>
     <form class="new-book-form" v-on:submit.prevent="saveFamily">
    <label for="family-name">Family name: </label>
    <input class="" type="text" placeholder="Family Name" id="family-name" v-model="family.name" /><br><br>
    <label for="family-description"> Family description</label>
    <input class="" type="text" placeholder="Family description" id="family-description" v-model="family.description" /> <br><br>

    <label for="family-code">Family Code</label>
    <input class="" type="text" placeholder="family code" v-model="family.code" /><br><br>
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
                name: '',
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
                name: '',
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

</style>