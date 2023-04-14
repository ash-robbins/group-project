import axios from 'axios';

export default {

list(){
    return axios.get('/books')
},

getBook(id) {
    return axios.get(`/books/${id}`)
  },

  getReadingActivity(book_id) {
      return axios.get(`/reading_activity/${book_id}`)
  },

  postBook(book) {
    return axios.post('/books', book)
  },

  updateReadingActivity(reading_activity){
    return axios.put(`/topics/${reading_activity.book_id}`, reading_activity)
    }









}