<template>
  <div>
      you're book id number is: {{$route.params.book_id}}
      <book-detail v-bind:bookprop="parseInt($route.params.book_id)" />
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