<template>
<div class="book-container">
    
<book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.book_id"/>
</div>
</template>

<script>
import BookCard from '../components/BookCard.vue'
import bookService from '../services/BookService.js'
export default {
    name: 'reading-list',
    components: {
        BookCard
    },
    data() {
    return {
      books: []
    };
  },
  created() {
    bookService.list()
    .then((response) => {
      this.books = response.data;
    });
  }

}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-between;
    flex-wrap: wrap;
}

</style>