<template>
  <div>
      You're in the Prizes Component
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

<style>
.prizeform{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
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