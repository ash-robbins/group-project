<template>
  
     <div>
        isbn: {{book.isbn}}
      <h1>title: {{book.title}}</h1>
      <h2>author: {{book.author}}</h2>

      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />

      <p>{{'i have read this book'}}</p>

  </div>
    
</template>

<script>
export default {
    name: 'book-detail',
    props: {
          bookprop: Object,
            enableAdd: {
            type: Boolean,
            default: false
        }
    },
      data() {
    return {
    }
  },
  computed: {
      book(){
          return this.$store.state.books.find(book=>book.isbn == this.bookprop)
      }
  }

    //   created() {
//     docsService.get(this.$route.params.id).then((response) => {
//       this.document = response.data;
//     });

}
</script>

<style>

</style>
