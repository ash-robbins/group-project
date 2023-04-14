import axios from 'axios';

export default {

//   login(user) {
//     return axios.post('/login', user)
//   },

//   register(user) {
//     return axios.post('/register', user)
//   }
list(){
    return axios.get('/books')
},

getBook(id) {
    return axios.get(`/books/${id}`)
  },

  getReadingActivity(book_id) {
      return axios.get(`/reading_activity/${book_id}`)
  }





}