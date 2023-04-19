<template>
  <div class = "familyaccount">
      Family Account
      <family-members/>
      <create-family-account/>
</div>
</template>

<script>
import CreateFamilyAccount from '../components/CreateFamilyAccount.vue'
import FamilyMembers from './FamilyMembers.vue'
export default {
name: 'create-family-accounts',
components: {
    CreateFamilyAccount,
FamilyMembers
}
}
</script>

<style scoped>

div {
  text-align: center;
}

</style>