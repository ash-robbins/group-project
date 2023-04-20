<template>
  <div>
     
        <form v-on:submit.prevent="search" >
          <label for="search-title">Enter title</label>
          <input id="search-title" type="text" v-model="searchBook.title" />
           <label for="search-isbn">Enter Isbn</label>
          <input id="search-isbn" type="text" v-model="searchBook.isbn" />
         <input type="submit" value="Submit"/>
          </form>

          <p>new book title: {{newbook.title}}</p>
          <p>{{newbook.author}}</p>
          <p>{{newbook.description}}</p>
         
          <div>
          <button v-on:click.prevent="addToList">Add Book to List</button>
          </div>
      </div>
</template>

<script>
import googleApi from '../services/GoogleApi.js'
import bookService from '../services/BookService.js'
export default {
    data(){
        return{
            searchBook: {
                title:'',
                isbn: ''
            },
            showButton: false,
            newbook: {
                title: '',
                author: '',
                description: '',
                isbn: '',
                coverImage: ''
            }

        }
    },
    methods:{
        search(){
            if(this.searchBook.title == ''){
                this.searchBook.title = ' '
            }
            if(this.searchBook.isbn == ''){
                this.searchBook.isbn = '0'
            }
          
           
           googleApi.getBook(this.searchBook)
           .then(response=>{
               this.newbook = response.data
               // console.log("search method called", this.newbook.title, this.newbook.author)
            //   this.showButton = true;
        //        bookService.postBook(this.newBook)
        //         .then(response=>{
        //         if(response.status === 201){
        //         this.$router.push('/books')

        // } 
        // })

           })

       
           
        },
        addToList(){
            //alert(JSON.stringify(this.newbook))
            console.log("add to list method called", this.newbook.title, this.newbook.author)
        bookService.postBook(this.newbook)
        .then(response=>{
        if(response.status === 201){
          this.$router.push('/books')
        } 
        })
        }
    }

}
</script>

<style>

</style>