<template>
  <form class="new-book-form" v-on:submit.prevent="saveBook">
    <input class="new-book-input" id="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="new-book-input" id="author-input" type="text" placeholder="Author" v-model="book.author" />
    <input class="new-book-input" id="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <button>Save</button>
  </form>
</template>

<script>
export default {
        name: "add-newbook-form",
    data() {
        return {
            book: {
                title: '',
                author: '',
                read: false,
                isbn: ''
            }
        }
    },
        methods: {
        saveBook() {
            if (this.book.title && this.book.author && this.book.isbn){
            this.$store.commit('SAVE_BOOK', this.book);
            this.book = {
                title: '',
                author: '',
                read: false,
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