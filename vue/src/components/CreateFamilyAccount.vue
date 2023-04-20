<template>
    <div class="family">
        <form class="family-form" v-on:submit.prevent="saveFamily">
            <div class="family-login-field">
                <i class="input-icon uil uil-user"></i>
                <input class="family-input" type="text" placeholder="Family Name" id="family-name" v-model="family.familyName" /><br><br>
            </div>
            
            <div class="family-login-field">
                <i class="uil uil-edit"></i>                
                <input class="family-input" type="text" placeholder="Family Description" id="family-description" v-model="family.description" /> <br><br>
            </div>
            
            <!-- <div class="family-login-field">
                <i class="uil uil-users-alt"></i>
                <input class="family-input" type="text" placeholder="Family Code" v-model="family.code" /><br><br>
            </div> -->
            
            <button>Save</button>

        </form>
    </div>
  
</template>

<script>
import familyMemberService from '../services/FamilyMemberService.js'

import '@iconscout/unicons/css/line.css';


export default {
    name: "add-newfamily-form",
    data() {
        return {
            family: {
                createdBy: '',
                familyName: '',
                description: ''
            }
        }
    },
    methods:{
        //  saveFamily() {
        //     this.$store.commit('CREATE_FAMILY', this.family);
        //     this.family = {
        //         family_name: '',
        //         description: '',
        //         code: '',
        //         username: ''
        //     }
        //     this.$router.push({name: 'books'})
        // }
        saveFamily(){
            familyMemberService.addFamilyAccount(this.family)
            .then(response=>{
                if(response.status == 201){
                    this.$router.push('/books')
                }
            })
        }
    }

}
</script>

<style scoped>


.family-input  {
  width: 50%;
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


.family{
  text-align: center;
  margin-bottom: 1rem;
  background-color: rgba(141, 141, 141, 0.5);
  padding: 1rem; 
  border-radius: 15px;
 
  justify-items: center;
}
body {
  margin: 0;
}

button {
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

button:hover {
  background: linear-gradient(to right,#102770,#ad63f1 );
  color: #ffffff;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}

div {
  text-align: center;
}

</style>