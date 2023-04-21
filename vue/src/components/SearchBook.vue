<template>
    <div class="booksearch">

        <form v-on:submit.prevent="search" >
            <div class="book-details">
                <label for="search-title">Search for a Book:  </label>
                <input class = "search-book-input" type="text" placeholder="Enter Title" id="searchTitle" v-model="searchBook.title" />
                <input class = "search-book-input" type="text" placeholder="Enter ISBN" id="searchIsbn" v-model="searchBook.isbn" />
            </div>
            <div class="buttons">
                <input type="submit" id ="submitSearchBtn" value="Search"/>
                
            </div>
        </form>

        <div v-if="newbook.title" class="book-search-results">
            <p>{{newbook.title}}</p>
            <p>{{newbook.author}}</p>
            <p>{{ newbook.description.length > 500 ? newbook.description.slice(0, 500) + '...' : newbook.description }}</p>
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
        },
        // truncatedDescription() {
        //     const maxLength = 100;
        //     if (this.book.description.length > maxLength) {
        //         return this.book.description.slice(0, maxLength) + '...';
        //     } else {
        //         return this.book.description;
        //     }
        // }
    
    }
}
</script>

<style scoped>
    .booksearch{
         margin-bottom: 1rem;
         background-color: rgba(230, 230, 230, 0.5);
         padding: 1rem; 
         border-radius: 15px;
         display: grid;
         justify-items: center;
         width: 50%;
         margin: 0 auto;
         
    }
    #submitSearchBtn{
        width: 200px;
        height: 50px; /* set the desired height */
        background: linear-gradient(to right,#00afef,#ad63f1);
        color: white;
        border-radius: 15px;
        border: none;
        outline: none;
        padding: 0 20px; /* reduce the vertical padding */
        margin-top: 10px;
        cursor: pointer;
        margin-left: 10px;
    
        justify-content: center; /* center the text horizontally */
        align-items: center; /* center the text vertically */
    }
    
    button {
        width: 200px;
        background: linear-gradient(to right,#00afef,#ad63f1 );
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
        background: linear-gradient(to right,#102770,#ad63f1 );
        color: #ffffff;
        box-shadow: 0 8px 24px 0 rgba(16,39,112,.2);
    }
    label {
        display: block;
        margin-bottom: 5px;
    }

    input {
        display: block;
        margin-bottom: 10px;
    }
    .search-book-input{
        width: 90%;
        height: 40px;
        border: 1px solid #ad63f1;
        background: rgb(255, 255, 255);
        padding: 0 20px;
        border-radius: 15px;
        outline: none;
        font-weight: 400;
        font-size: 14px;
        transition: all 0.5s ease;
        margin-top: 5px;
    }

    .book-search-results {
        display: grid;
        grid-template-columns: 1fr;
        justify-content: center;
    }
</style>