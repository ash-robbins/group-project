<template>
<div class="book-container">
    
<book-card v-bind:book="book" v-for="book in books" v-bind:key="book.book_id"/>
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

<style scoped>
.book-container {
    display:flex;
    justify-content: space-between;
    flex-wrap: wrap;
}

button {
    width: 220px;
    background: #00AFEF;
    color: white;
    border-radius: 15px;
    border: none;
    outline: none;
    padding: 23px 0;
    margin-top: 10px;
    cursor: pointer;
    margin-left: 10px;
}
button:hover {
  background-color: #102770;
  color: #ffffff;
  box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
}

</style>