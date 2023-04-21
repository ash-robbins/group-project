<template>
  <div class = "book_details">
    
    <div class="book-info">
      <img v-bind:src="book.coverImage"/>
      <h2>{{book.title}}</h2>
      <h3>By: {{book.author}}</h3>
    </div>

    <div class="book-description">
      <p>{{book.description}}</p>
      <br>
     
      <router-link class="link" v-bind:to="{name:'bookReadingActivity', params: {book_id: book.bookId}}" >Click For Reading Activity</router-link>
    </div>

    

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
         bookService.getBook(this.$route.params.book_id)
         .then((response) => {
         this.book = response.data;
          });
    },
    // truncatedDescription() {
    //   const maxLength = 50;
    //   if (this.book.description && this.book.description.length > maxLength) {
    //     return this.book.description.slice(0, maxLength) + '...';
    //   } else {
    //     return this.book.description;
    //   }
    // },

};


</script>

<style scoped>
.book_details {
  text-align: center;
  margin-bottom: 1rem;
  background-color: rgba(230, 230, 230, 0.5);
  padding: 1rem; 
  border-radius: 15px;
  display: grid;
  grid-template-columns: 1fr 1fr;
}

img {
  width: 250px;
  border-radius: 15px;
  margin-top: 20px;
}

.link {
  text-align: center;
  /* color: black; */
   width: 120px;
    background: linear-gradient(to right,#00afef,#ad63f1 );
    color: white;
    border-radius: 15px;
    border: none;
    outline: none;
    padding: 15px;
    margin-top: 10px;
    cursor: pointer;
    margin-left: 10px;
}

.link:hover {
    text-decoration: none;

}

.book-description {
  margin-right: 50px;
  margin-top: 20px;
}

@media (max-width: 768px) {
  .book_details {
    display: grid;
    grid-template-columns: 1fr;
  }
  .book-description {
    margin: 0px;
  }


}



</style>
