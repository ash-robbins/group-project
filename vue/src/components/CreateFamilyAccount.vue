<template>
    <div class="family">
        <form class="family-form" v-on:submit.prevent="saveFamily">
            <div class="family-login-field">
                <i class="input-icon uil uil-user"></i>
                <input class="family-input" type="text" placeholder="Family Name" id="family-name" v-model="family.family_name" /><br><br>
            </div>
            
            <div class="family-login-field">
                <i class="uil uil-edit"></i>                
                <input class="family-input" type="text" placeholder="Family Description" id="family-description" v-model="family.description" /> <br><br>
            </div>
            
            <div class="family-login-field">
                <i class="uil uil-users-alt"></i>
                <input class="family-input" type="text" placeholder="Family Code" v-model="family.code" /><br><br>
            </div>
            
            <button>Save</button>

        </form>
    </div>
  
</template>

<script>

import '@iconscout/unicons/css/line.css';


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

<style scoped>


.family-input  {
  width: 40%;
  height: 40px;
  border: 1px solid black;
  padding: 0 20px;
  border-radius: 15px;
  outline: none;
  font-weight: 400;
  font-size: 14px;
  transition: all 0.5s ease;
  margin-top: 5px;
  color: black;
}


form{
  margin-bottom: 1rem;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 1rem; 
}
body {
  margin: 0;
}

button {
    width: 220px;
    background: #00AFEF;
    color: white;
    border-radius: 15px;
    border: none;
    outline: none;
    padding: 23px 0;
    margin-top: 10px;
    cursor: pointer;
    margin-left: 10px;
}

button:hover {
  background-color: #102770;
  color: #ffffff;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}

div {
  text-align: center;
}

</style>