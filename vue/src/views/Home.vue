<template>
  <div class="home">
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
.home{
   display: flex;
  flex-direction: column;
  
  height: 100vh;
  background-color: #f8fcfe;

}
  
</style>