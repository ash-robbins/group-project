<template>
  <div>
      you're isbn number is: {{$route.params.isbn}}
      <book-detail v-bind:bookprop="parseInt($route.params.isbn)" />
      </div>
</template>

<script>
import BookDetail from '../components/BookDetail.vue'
export default {
name: 'book-details',
components: {
    BookDetail
}

   

}
</script>

<style>

</style>