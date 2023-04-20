<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Welcome!</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">

        <i class="input-icon uil uil-user"></i>
        <label for="username">Username: </label>
        <input type="text" placeholder="Username" id="username" v-model="user.username" required autofocus />
       
      </div>
      <div class="form-input-group">

        <i class="input-icon uil uil-lock-alt"></i>

        <label for="password">Password: </label>
        <input type="password" placeholder="Password" id="password" v-model="user.password" required />
      
        
        

      </div>
      <button type="submit">Sign In</button>
      <p> <!-- !!! -->
        <router-link class="link" :to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
    
  </div>
</template>

<script>
import authService from "../services/AuthService";

/* import icons > npm install @iconscout/unicons */ 
import '@iconscout/unicons/css/line.css';

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

  /* !!! */
  border-radius: 15px;
  /*!!!*/
}

form {
  margin-bottom: 1rem;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 1rem; 

  /* !!! */
  border-radius: 15px;
  display: grid;
  justify-items: center;
  /*!!!*/
  
}
label {
  margin-right: 0.5rem;
}

/* !!! */
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


.link {
  text-align: center;
  color: black;
}

.link:hover {
    text-decoration: none;

}

body {
  
}


/*
.form-input-group {
  position: relative;
}

.input-icon {
  position: absolute;
  top: 50%;
  left: 5px;
}
*/

/*!!!*/

</style>