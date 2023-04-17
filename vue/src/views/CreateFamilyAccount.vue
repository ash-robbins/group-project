<template>
  <div class = "familyaccount">
      family account

      <create-family-account/>
</div>
</template>

<script>
import CreateFamilyAccount from '../components/CreateFamilyAccount.vue'
export default {
name: 'create-family-accounts',
components: {
    CreateFamilyAccount
}
}
</script>

<style>
.familyaccount{
  
  display: flex;
  flex-direction: column;
  justify-content: center;
  
  height: 100vh;
  background-image: url('/images/openbook.jpg');
  background-size: cover;
  background-position: center;
}

form{
  margin-bottom: 1rem;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 1rem; 
}
</style>