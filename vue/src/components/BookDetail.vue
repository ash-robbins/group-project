<template>
  
     <div>
        isbn: {{book.isbn}}
      <h1>title: {{book.title}}</h1>
      <h2>author: {{book.author}}</h2>
      <h2>description: {{book.description}}</h2>

      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <router-link v-bind:to="{name:'bookReadingActivity', params: {book_id: book.book_id}}" >Click to see reading activity</router-link>


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
export default {
    name: 'book-detail',
    props: {
          bookprop: Number
    },
    data() {
    return {
  
  // updateButton: true,
  // book: {
  //   book_id:'',
  //   isbn: '',
  //   is_completed: true,
  //   reading_time: '',
  //   bookmark_page_number: ''
  //   }
    }
  },

  computed: {
      book(){
          return this.$store.state.books.find(book=>book.book_id == this.bookprop)
      }
    //   book(){
    //     docsService.getBook(this.$route.params.id).then((response) => {
    //   this.book = response.data;
    // });
      }
}



</script>

<style>

</style>
