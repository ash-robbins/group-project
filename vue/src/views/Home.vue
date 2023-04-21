<template>
  
    <div class="homepage">
      <div class ="row1">

        <div class ="column1">
         <h2 class>Take a Look!<br>It's in a Book!</h2>
         
         <h3>-Track Family Reading Activity</h3>
         <h3>-Reward Progress</h3>
         <h3>-Elevate Imagination</h3>
         
        </div>

        <div class ="column2">
          <!-- <img src="assets\bookstairs.png" class="homepic1"> -->
          <div class="color-box"></div>
          
          
<!-- <book-card v-bind:book="book" v-for="book in books" v-bind:key="book.book_id"/> -->
</div>
  </div>
  </div>
  
  
</template>

<script>
// // import BookCard from '../components/BookCard.vue'
// import bookService from '../services/BookService.js'
export default {
  name: "home",
    components: {
        // BookCard
    },
    data() {
    return {
      books: []
    };
  },
  // created() {
  //   bookService.list()
  //   .then((response) => {
  //     this.books = response.data;
  //   });
  // }
};
</script>

<style scoped>
.row1{
  display:flex;
  justify-content: space-between;
  align-items:center;
  margin:100px 0;
}

.column1{
  flex-basis:50%;
  position:relative;
  margin-left: 100px;
  margin-right:-800px;
}
.column1 h2{
  font-size:54px;
}
.column1 h3{
  font-size:30px;
  color:#707070;
  font-weight:100;
  margin: 20px 0 10px
}
.column1 p{
  font-size:16px;
  color: #b7b7b7;
  font-weight:100;
}
.column1::after{
  content:'';
  width:10px;
  height:85%;
  background: linear-gradient(#00afef,#ad63f1 );
  position:absolute;
  left:-40px;
  top:55px;
}
.column2{
  position: relative;
  flex-basis: 60%;
  display: flex;
  align-items:center;
  margin-right: 100px; /* add margin-right */
  z-index: 1; /* set the z-index to 1 */
}
.column2 .homepic1{
  width:50%;
  left:-50;
  z-index: 2;
  position:relative;
}
.color-box{
 
  position:relative;
  left:0;
  top:40;
  background:linear-gradient(#ad63f1,#00afef );
  border-radius:20px 0 0 20px;
  height:200%;
  min-height: 500px; /* set a minimum height */
  width:100%;
  transform:translateX(150px);
  background-image: url('/images/boxboy.png');
  background-size: cover;
  background-position: center;
}

.column2 .homepic1 {
  width: 100%;
  
  
  position: relative;
  z-index: -1;
}
.homepage{
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-color: #f8fcfe;
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