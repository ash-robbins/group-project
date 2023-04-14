<template>
  <div>
      <p>Time spent reading: {{book.reading_time}} Minutes</p>
     <p>Pages read: {{book.bookmark_page_number}} Pages read</p>


     {{book.is_completed ? 'You completed this book!' : 'You have not completed this book yet. Keep reading!'}}


        <div>
            <br>
        <button v-if="updateButton" v-on:click.prevent="updateButton = false">Update Book Activity</button>
        <form v-else v-on:submit.prevent="updateBookActivity">
          <label>Pages Read Today</label>
          <input type="text" placeholder="Pages Read" key="pages-read" v-model="newactivity.bookmark_page_number"/>
          <label>Minutes Read</label>
          <!-- <label>{{$route.params.isbn}}</label> -->
        
          <input type="text" placeholder="Minutes Read" key="minutes-read" v-model="newactivity.reading_time"/>
          <input type="submit" value="Submit"/>
        </form>
        </div>
      
      </div>
</template>

<script>
export default {
    name: 'book-reading-activity',
    data(){
        return {
            updateButton: true,
            newactivity: {
                book_id: this.$route.params.book_id,
                bookmark_page_number: '',
                reading_time: ''
            }

        }
    },
    methods: {
            updateBookActivity(){

               this.$store.commit("UPDATE_ACTIVITY", this.newactivity)
               this.newactivity = {
                book_id: this.$route.params.book_id,
                bookmark_page_number: '',
                reading_time: ''
            }
               this.updateButton = true;
                //this.$router.push({name: 'books'});
               // console.log( this.newactivity.reading_time, this.newactivity.bookmark_page_number)

            }
    },
    computed:{
         book(){
        return this.$store.state.readingactivity.find(act=>act.book_id == this.$route.params.book_id)
      }
    }

}
</script>

<style>

</style>