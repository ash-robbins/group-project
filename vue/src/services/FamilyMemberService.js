import axios from 'axios';

export default {

  list(){
    return axios.get('/families/familyMembers')
  },
  addFamilyMember(newFamilyMember){
      return axios.post(`/addFamilyMember`, newFamilyMember)
  },

  verifyFamilyAccount(){
      return axios.get(`/verifyfamilyaccount`)
  },
  addFamilyAccount(family){
      return axios.post(`/addFamilyAccount`, family)
  },

  viewFamilyMemberBooks(id){
    return axios.get(`/books/listbooks/${id}`)
  }
  

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