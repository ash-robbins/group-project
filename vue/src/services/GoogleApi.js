import axios from 'axios';

export default {
      getBook(searchBook) {
    return axios.get(`/searchBy/title/${searchBook.title}/isbn/${searchBook.isbn}`)
  },

//   list(){
//     return axios.get('/books/listbooks')
//   },

//   getBook(book_id) {
//     return axios.get(`/books/${book_id}`)
//   },

//   // get reading activity by book_id
//   getReadingActivity(book_id) {
//       return axios.get(`/books/reading_activity/${book_id}`)
//   },

//   postBook(book) {
//     return axios.post('/addBook', book)
//   },

//   updateReadingActivity(reading_activity){
//     return axios.put(`/update/reading_activity/book/${reading_activity.bookId}`, reading_activity)
//     }









}