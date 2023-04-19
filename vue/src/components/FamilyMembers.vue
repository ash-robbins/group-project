<template>
<div>
  <div> You're in family members component 2</div>
<family-member-card v-bind:familymember="familymember" v-for="familymember in familyMembers"  v-bind:key="familymember.userId"/>
<!-- {{familyMembers[0].userId}} -->
<!-- <div v-for="familymember in familyMembers" v-bind:key="familymember.userId"> user id is: {{familymember.userId}}</div> -->
</div>
</template>

<script>
 import FamilyMemberCard from './FamilyMemberCard.vue'
import familyMemberService from '../services/FamilyMemberService.js'
export default {
    components: {
         FamilyMemberCard
    },
     data() {
    return {
      familyMembers: []
    }
  },
    created() {
    familyMemberService.list()
    .then((response) => {
      this.familyMembers = response.data;
    });
  }

}
</script>

<style>

</style>
FamilyMemberCard