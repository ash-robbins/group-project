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
button:hover {
  background-color: #102770;
  color: #ffffff;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}
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