<template>
    <div class="card" v-bind:class="{ read: book.read }">
      
        <h2 class="book-title">
            <router-link v-bind:to="{name: 'book-details', params: { book_id: book.bookId}}">
              {{ book.title }}
            </router-link>
        </h2>
        

        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
        <h3 class="book-author">{{ book.author }}</h3>
        <div class="button-container" v-if="! enableAdd">
            <!-- <button class="mark-read" v-on:click.prevent="setRead(true)" v-if=" ! book.read">Mark Read</button>
            <button class="mark-unread" v-on:click.prevent="setRead(false)" v-if="book.read">Mark Unread</button> -->
        </div>
            <!-- <button v-if="enableAdd" v-on:click.prevent="addToReadingList(book)">Add to Reading List</button> -->
    </div>
</template>

<script>
export default {
    name: 'book-card',
    props: {
        book: Object,
           enableAdd: {
            type: Boolean,
            default: false
        }
    }

}
</script>

<style>

.card a {
    text-decoration: none;
}

.card {
    background-color: #ffffff;
    border: 3px solid black;
    border-radius: 10px;
    width: 250px;
    height: auto;
    margin: 10px;
    padding: 0px;

    text-align: center;


}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
    text-align: center;
}

.card .book-author {
    font-size: 1rem;
}


</style>