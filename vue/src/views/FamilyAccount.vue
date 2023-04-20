<template>
  <div class = "familyaccount">
      Family Account
      <create-family-account v-if="hasAccount == false"/>
      <family-members v-else/>
      <!-- <create-family-account/> -->
</div>
</template>

<script>
import CreateFamilyAccount from '../components/CreateFamilyAccount.vue'
import FamilyMembers from './FamilyMembers.vue'
import familyAccount from '../services/FamilyMemberService.js'

export default {
name: 'create-family-accounts',
components: {
CreateFamilyAccount,
FamilyMembers
},
data(){
  return{
    hasAccount: false
  }
},
created(){
  familyAccount.verifyFamilyAccount()
  .then((response)=>{
    this.hasAccount = response.data
  })
}

}
</script>

<style scoped>

div {
  text-align: center;
}

</style>