<template>
    <div>
        you're in books views component
        <reading-list/>
        <button v-on:click="$router.push({ name: 'add-book' })">
            <div class="save-button">
                <router-link v-bind:to="{ name: 'add-book' }">Add New Book</router-link>
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

<style>

.save-button a {
    text-decoration: none;
    color: #ffffff;
}

</style>