<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
      <input class="book-id" type="text" placeholder="book-id" v-model="book.book_id" />
    <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
    <textarea placeholder="Description of Book" v-model="book.description" />
    <input class="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <button>Save</button>
  </form>
</template>

<script>
export default {
        name: "add-newbook-form",
    data() {
        return {
            book: {
                book_id: '',
                title: '',
                author: '',
                read: false,
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
                read: false,
                description: '',
                isbn: ''
            };
            this.$router.push({name: 'books'});
        } else {
            alert('Please fill in all fields');
        }
    }}

}
</script>

<style>

</style>