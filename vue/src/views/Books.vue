<template>
    <div class = "booksLibrary">
        Your Library of Books
        <reading-list/>
        <!-- <button v-on:click="$router.push({ name: 'add-book' })">
            <div class="save-button">
                <router-link v-bind:to="{ name: 'add-book' }">Add New Book</router-link>
            </div>
        </button> -->

        <button >
            <div class="save-button" v-on:click="$router.push({ name: 'searchbook' })">
                <router-link v-bind:to="{ name: 'searchbook' }">Search Book</router-link>
            </div>
            </button>

    </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
    name: 'books',
    components:{
        ReadingList,
        
    }

}
</script>

<style scoped>

.save-button a {
    text-decoration: none;
    color: #ffffff;
}

.booksLibrary {
  text-align: center;
  margin-bottom: 1rem;
  background-color: #f8fcfe; 
  border-radius: 15px;
  display: grid;
  justify-items: center;
}

button {
    width: 220px;
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

</style>