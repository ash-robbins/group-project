<template>
  <div>
      Prizes View
      <create-prize/>
  </div>
</template>

<script>
import CreatePrize from '../components/CreatePrize.vue'
export default {
name: 'prizes',
components: {
  CreatePrize
}
}
</script>

<style scoped>


div {
  text-align: center;
}
</style>