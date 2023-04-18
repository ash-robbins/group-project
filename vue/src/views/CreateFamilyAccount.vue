<template>
  <div class = "familyaccount">
      Family Account
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

<style scoped>

div {
  text-align: center;
}

</style>