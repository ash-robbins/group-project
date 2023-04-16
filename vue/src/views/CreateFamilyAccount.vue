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
  align-items: center;
  height: 100vh;
  background-image: url('/images/openbook.jpg');
  background-size: cover;
  background-position: center;
}
</style>