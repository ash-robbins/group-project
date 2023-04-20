<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Join Us</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <i class="input-icon uil uil-user"></i>
        <label for="username">Username: </label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <i class="input-icon uil uil-lock-alt"></i>
        <label for="password">Password: </label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <i class="input-icon uil uil-lock-alt"></i>
        <label for="confirmPassword">Confirm Password: </label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div>
        <i class="input-icon uil uil-users-alt"></i>
        <label for="family-code">Family Code: </label>
        <input type="text" id="family-code" v-model="user.familyCode"/>
        </div>

      <!-- !!! -->
      <div class="button">
        <button type="submit">Create Account</button>
      </div>
      
      <p><router-link class="link" :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

import '@iconscout/unicons/css/line.css';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        familyCode: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register{
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
}
input{
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

    /* !!! */
    margin-bottom: 5px;
    
    }
form {
  margin-bottom: 1rem;
  background-color: rgba(255, 255, 255, 0.5); /* white with 50% transparency */
  padding: 1rem; 

  /*!!!*/
  border-radius: 15px;

}
label {
  margin-right: 0.5rem;
  
}

/* !!!! */ 

.button {
  display: grid;
  justify-content: center;

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

.link {
  text-align: center;
  color: black;
}

.link:hover {
    text-decoration: none;
}

h1 {
  text-align: center;
}
p {
  text-align: center;
}
</style>
