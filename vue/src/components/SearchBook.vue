<template>
  <div>
      you're in search book component 2
        <form v-on:submit.prevent="search" >
          <label for="search-title">Enter title</label>
          <input id="search-title" type="text" v-model="searchBook.title" />
           <label for="search-isbn">Enter Isbn</label>
          <input id="search-isbn" type="text" />
         <input type="submit" value="Submit"/>
          </form>

          <p>{{newBook.title}}</p>
          <p>{{newBook.author}}</p>
          <p>{{newBook.description}}</p>
          <p></p>
          <div>
          <button v-on:click="addToList">Add Book to List</button>
          </div>
      </div>
</template>

<script>
import googleApi from '../services/GoogleApi.js'
//import bookService from '../services/BookService.js'
export default {
    data(){
        return{
            searchBook: {
                title:'',
                isbn: ''
            },
            showButton: false,
            newBook: {
                title: '',
                author: '',
                description: '',
                isbn: '',
                imageLink: ''
            }

        }
    },
    methods:{
        search(){
           googleApi.getBook(this.searchBook.title)
           .then(response=>{
               this.newBook = response.data
            //   this.showButton = true;
        //        bookService.postBook(this.newBook)
        //         .then(response=>{
        //         if(response.status === 201){
        //         this.$router.push('/books')

        // } 
        // })

           })
           
        }
    }

}
</script>

<style>

</style>