<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
    <input class="new-book-input" type="text" placeholder="Book-ID" v-model="book.book_id" />
    <input class="new-book-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="new-book-input" type="text" placeholder="Author" v-model="book.author" />
    <input class="new-book-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <textarea class="new-book-input" id="description" placeholder="Description of Book" v-model="book.description" />
    <button>Save</button>
  </form>
</template>

<script>
import bookService from '../services/BookService.js'
export default {
        name: "add-newbook-form",
    data() {
        return {
            book: {
                book_id: '',
                title: '',
                author: '',
                cover_image: '',
                description: '',
                isbn: ''
            }
        }
    },
        methods: {
        saveBook() {
            if (this.book.title && this.book.author && this.book.isbn){
            this.$store.commit('SAVE_BOOK', this.book);
            this.book = {
                book_id: '',
                title: '',
                author: '',
                cover_image: '',
                description: '',
                isbn: ''
            };
            this.$router.push({name: 'books'});
        } else {
            alert('Please fill in all fields');
        }},
    postBook(){
    bookService.postBook(this.book)
    .then(response=>{
        if(response.status === 201){
          this.$router.push('/')
        } 
        })
    .catch(error=>{
        this.handleResponse(error, "adding")
      })
    }
    
    
    }

}
</script>

<style>

.new-book-input {
    width: 50%;
    height: 65px;
    border: 1px solid white;
    background: rgb(226, 226, 226);
    padding: 0 20px;
    border-radius: 15px;
    outline: none;
    font-weight: 400;
    font-size: 14px;
    transition: all 0.5s ease;
    margin-top: 5px;
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

}


</style>