<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
      <input class="book-id" type="text" placeholder="book-id" v-model="book.book_id" />
    <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
    <textarea placeholder="Description of Book" v-model="book.description" />
    <input class="new-book-input" type="text" placeholder="ISBN" v-model="book.isbn" />
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