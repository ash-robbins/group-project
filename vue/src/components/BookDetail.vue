<template>
  
     <div class = "book_details">
       <img v-bind:src="book.coverImage"/>
        
      <h1>Title: {{book.title}}</h1>
      <h2>Author: {{book.author}}</h2>
      <h2>Description: {{book.description}}</h2>

      <!-- <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" /> -->
      <!-- <img v-bind:src="book.imageLink"/> -->
      
      <router-link v-bind:to="{name:'bookReadingActivity', params: {book_id: book.bookId}}" >Click to see reading activity</router-link>

  
      <!-- <div>
        Book Activity: 
        <p>{{ book.reading_activity.is_completed ? 'You Have Completed reading this Book !' : 'Book Not Yet Completed'}}</p>
        Page Number: 
        <p>{{book.reading_activity.bookmark_page_number}}</p>
        Minutes Read: 
        <p>{{book.reading_activity.reading_time}}</p>

        </div> -->
      <!-- <div>
        <button v-if="updateButton" v-on:click.prevent="updateButton = false">Update Book Activity</button>
        <form v-else v-on:submit.prevent="updateBookActivity">
          <label>Pages Read Today</label>
          <input type="text" placeholder="Pages Read" key="pages-read" v-model="new_activity.bookmark_page_number"/>
          <label>Minutes Read</label>
          <input type="text" placeholder="Minutes Read" key="minutes-read" v-model="new_activity.reading_time"/>
          <input type="submit" value="Submit"/>
        </form>
      </div> -->

  </div>
    
</template>

<script>
import bookService from '../services/BookService'
export default {
    name: 'book-detail',
    props: {
          bookprop: Number
    },
    data() {
    return {
  myUser: this.$store.state.user.id,
  // updateButton: true,
  book: {
    bookId: '',
    isbn: '',
    title: '',
    author: '',
    coverImage: '',
    description: ''
}
    }
  },

  computed: {
      // book(){
      //     return this.$store.state.books.find(book=>book.book_id == this.bookprop)
      // }
},
created(){
  // this.$route.params.id
         bookService.getBook(this.$route.params.book_id)
         .then((response) => {
         this.book = response.data;
          });
      
}
}


</script>

<style scoped>
.book_details {
  
  text-align: center;
  margin-bottom: 1rem;
  background-color: rgba(141, 141, 141, 0.5);
  padding: 1rem; 
  border-radius: 15px;
  display: grid;
  justify-items: center;
}

</style>
