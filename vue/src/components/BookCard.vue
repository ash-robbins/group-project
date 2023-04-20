<template>
    <div class="card" v-bind:class="{ read: book.read }">
      
        <!-- <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" /> -->
        <img v-bind:src="book.coverImage"/>
       
        <div class="title-author">
        <h2 class="book-title">
            <router-link v-bind:to="{name: 'book-details', params: { book_id: book.bookId}}">
              {{ book.title }}
            </router-link>
        </h2>
        
        <h3 class="book-author">{{ book.author }}</h3>
        </div>

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

<style scoped>



img {
    border-radius: 15px;
    margin-top: 20px;
}

.card a {
    text-decoration: none;
}

.card {
    background-color: #ffffff;
    box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.5);
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
    font-size: 1rem;
    text-align: center;
}

.card .book-author {
    font-size: .8rem;
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


@media (max-width: 768px) {
    .card {
        width: 45%;
    }

    img {
        height: 60%;
        margin-top: 20px;
    }

    .card .book-title {
    font-size: 70%;
    text-align: center;
    }

   

}

</style>