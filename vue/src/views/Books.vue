<template>
    <div>
        you're in books views component
        <reading-list/>
        <router-link v-bind:to="{ name: 'add-book' }">Add New Book</router-link>
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

</style>