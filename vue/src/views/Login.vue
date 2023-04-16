<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username: </label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password: </label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign In</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
    
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

input {
    width: 90%;
    height: 40px;
    border: 1px solid white;
    background: rgb(226, 226, 226);
    padding: 0 20px;
    border-radius: 15px;
    outline: none;
    font-weight: 400;
    font-size: 14px;
    transition: all 0.5s ease;
    margin-top: 5px;
}
h1{
   text-align: center;
}
#login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-image: url('/images/openbook.jpg');
  background-size: cover;
  background-position: center;
}

form {
  margin-bottom: 1rem;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 1rem; 
}
label {
  margin-right: 0.5rem;
}
</style>