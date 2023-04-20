import axios from 'axios';


export default {

    // list(){
    //   return axios.get('/books')
    // },
  
    // getBook(book_id) {
    //   return axios.get(`/books/${book_id}`)
    // },
  
    // // get reading activity by book_id
    // getReadingActivity(book_id) {
    //     return axios.get(`/books/reading_activity/${book_id}`)
    // },
  
    // postBook(book) {
    //   return axios.post('/postbook', book)
    // },
  
    // updateReadingActivity(reading_activity){
    //   return axios.put(`/books/reading_activity/${reading_activity.book_id}`, reading_activity)
    //   }
  
    postPrize(prize) {
        return axios.post('/prize', prize)
    },
    getPrizeWinner(){
        return axios.get(`/prizewinner`)
    }
  
  
  
  
  
  
  
  
  }