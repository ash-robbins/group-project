import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    books: [{
      title: "Kafka by the Shore",
      author: "Haruki Murakami",
      read: false,
      isbn: "9781784877989"
    },
    {
      title: "The Girl With All the Gifts",
      author: "M.R. Carey",
      read: true,
      isbn: "9780356500157"
    },
    {
      title: "The Old Man and the Sea",
      author: "Ernest Hemingway",
      read: true,
      isbn: "9780684830490"
    },
    {
      title: "Le Petit Prince",
      author: "Antoine de Saint-Exupéry",
      read: false,
      isbn: "9783125971400"
    }
  ],
  family: [{
    family_name: 'adam',
    family_description: 'adam family description',
    family_code: '2234',
    user_id: 'mnaser'
  }]
      },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SAVE_BOOK(state, book) {
      state.books.push(book);
    },
    CREATE_FAMILY(state, family){
      state.family.push(family)
    }
  }
})
