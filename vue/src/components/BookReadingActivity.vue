<template>
  <div class ="readingactivity">
      <p>Time Spent Reading: {{reading_activity.readingTime}} Minutes</p>
     <p>Pages Read: {{reading_activity.bookmarkPage}} Pages Read</p>
     <p>Completed: {{reading_activity.completed}} </p>
      <p>Favorite: {{reading_activity.favorite}}</p>

     <!-- {{book.is_completed ? 'You completed this book!' : 'You have not completed this book yet. Keep reading!'}} -->


        <div>
            <br>
        <button v-if="updateButton" v-on:click.prevent="updateButton = false">Update Book Activity</button>
        <form v-else v-on:submit.prevent="updateBookActivity">
          <label>Pages Read Today</label>
          <input type="text" placeholder="Pages Read" key="pages-read" v-model="reading_activity.bookmarkPage"/>
          <label>Minutes Read</label>
          
        
          <input type="text" placeholder="Minutes Read" key="minutes-read" v-model="reading_activity.readingTime"/>
          <label>Notes</label>
          <input type="text" placeholder="notes" key="notes" v-model="reading_activity.notes"/>
          <label>Completed</label>
          <input type="checkbox" placeholder="completed" v-model="reading_activity.completed"/>

          <label>Is Favorited: </label>
          <input type="checkbox" placeholder="is Favorited" v-model="reading_activity.favorite"/>
          <input type="submit" value="Submit"/>
        </form>
        </div>
      
      </div>
</template>

<script>
import bookService from '../services/BookService.js'
export default {
    name: 'book-reading-activity',
    data(){
        return {
            updateButton: true,
            reading_activity: {
                bookId: this.$route.params.book_id,
                completed: '',
                favorite: '',
                bookmarkPage: '',
                readingTime: '',
                notes: ''
            }

        }
    },
    methods: {
            // updateBookActivity(){

            //    this.$store.commit("UPDATE_ACTIVITY", this.reading_activity)
            //    this.reading_activity = {
            //     book_id: this.$route.params.book_id,
            //     is_completed: false,
            //     is_favorite: false,
            //     bookmark_page_number: '',
            //     reading_time: '',
            //     notes: ''
            // }
            //    this.updateButton = true;
            //     //this.$router.push({name: 'books'});
            //    // console.log( this.newactivity.reading_time, this.newactivity.bookmark_page_number)

            // },
             updatePutBookActivity(){
                bookService.updateBookActivity(this.reading_activity)
                .then(response=>{
                if(response.status === 200){
                    this.$router.push('/')
                }
                })
                .catch(error=>{
                 this.handleResponse(error, "updating")
                })
            }
    },
           
    created(){
          bookService.getReadingActivity(this.$route.params.book_id)
          .then((response) => {
      this.reading_activity = response.data;
    })
      }
    // computed:{},
        //  book(){
        // return this.$store.state.readingactivity.find(act=>act.book_id == this.$route.params.book_id)
     // }
    //   reading_activity(){
    //       bookService.getReadingActivity(this.$route.params.book_id)
    //       .then((response) => {
    //         this.reading_activity = response.data;
    //         });
      
      
      
    }


</script>

<style scoped>
.readingactivity{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  

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