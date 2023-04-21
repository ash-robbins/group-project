<template>
  <div class="container">
    <header>
        <div class="link-block" v-on:click="$router.push({ name: 'home' })">
            <img src="../images/Logo_Words.png" alt="" />
        </div>
    </header>

    <nav>
        <div class="content">
            <div class="link-block" v-on:click="$router.push({ name: 'home' })">
                <img src="../images/purplehome.png" alt="Home Icon">
                <router-link v-bind:to="{ name: 'home' }"  >  Home </router-link>
            </div> 
            
            <div class="link-block" v-on:click="$router.push({ name: 'books' })">
                <img class ="icon" src="../images/purplebook.png" alt="Book Icon">
                <router-link v-bind:to="{name: 'books'}">  Books</router-link> 
            </div>
            <div class="link-block" v-on:click="$router.push({ name: 'prizes' })">
                <img src="../images/purpleprize.png" alt="Prize Icon">
                <router-link v-bind:to="{name: 'prizes'}">  Prizes</router-link>
            </div>
            <div class="link-block" v-on:click="$router.push({ name: 'family-account' })">
                <img src="../images/purplefamily.png" alt="Family Icon">
                <router-link v-bind:to="{name: 'family-account'}">  Family</router-link>
            </div>
            <div v-if="$store.state.token !== ''" class="link-block" v-on:click="$router.push({ name: 'logout' })">
                <img src="../images/purplelogout.png" alt="LogOut Icon">
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">  Logout </router-link>
            </div>
        </div>
    </nav> 

    <main>
        <div>
                    <!-- different views/pages are displayed/injected here -->

            <router-view />
        </div>
    </main>



    

    <footer>
        <div class="content">
                            <!-- Footer Content -->
        </div>
    </footer>
    
  
  </div>
</template>

<script>
    
   
  export default {
   
  };
</script>

<style scoped>
    body {
        margin: 0;
    }

    /* Add CSS Grid here  background colors: Header - #f69a00;  Nav - #f2ead2;  
    main - #f9f5f0;  aside - #f2ead2;  footer - #331312;
    font colors header, footer - #ffffff;  nav, main, aside - #74889a;*/

    .container{
        display: grid;

        grid-template-areas: 
            "header nav nav" 
            "content content content"   /*main = content and side = aside*/ 
            "footer footer footer";

        grid-template-columns: 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr 1fr;
        

        height: 100vh;


    }
    /*handle responsive behavior */
    @media (max-width: 768px) {

        /* Block text so only icons show */
        .link-block a {
        display: none;
        }
        .link-block img {
        display: flex;
        height: 25px; /* Adjust the height of the icons as needed */
        margin: auto; /* Center the icons horizontally */
        }

        .container{
            grid-template-areas: 
                "header"
                "nav"
                "content"
                "side"
                "footer";
            grid-template-columns: 1fr;
            grid-template-rows:
                auto /*Header */
                auto /*Nav*/   
                1fr /* content */
                auto /* Sidebar */
                auto; /* Footer */
            
        }
        header, footer, nav, main, aside {
            padding: 5px;
            
        }
        
        /* Navigation bar becomes side by side*/
        nav div.content {
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        padding: 0 10px;
        
        }
    } /* End of Small View */

    
    /*Remove underline from nav links */
    .link-block a {
    text-decoration: none;
    color: #505050;
    }

    /* Logo clickable */
   .link-block > img {
       cursor: pointer;
   }

    /* Nav link alignment and appears clickable*/
    div.content {
        text-align: center;
        padding-top: 25px;
        
        cursor: pointer;

        display: flex;
        justify-content: flex-end;
        justify-content: space-around;
        
        
    }

    /* Highlights tabs in nav*/
    .content > div:hover {
        display: block;
        background-color: rgba(19, 160, 241, 0.849);
        border-radius: 10px 10px 10px 10px;
        
    }

    /* Logo */
    header div img {
        height: 10vh;
        margin: 10px;
    } 

    footer {
        grid-area: footer;
        background-color: #f8fcfe;

    }

    /* Header & Footer font color */
    header, footer, nav {
        color: #505050;
    }

    main {
        grid-area: content;
        background-color: #f8fcfe;
        color: #505050;
        border-radius: 10px;
        
    }


    nav {
        grid-area: nav;
        background-color: #f8fcfe;
        border-radius: 10px;

        
    }


    nav, aside {
        color: #ffffff;
    }

    header, footer, nav, main, aside {
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 24px;
        
        background-color: #f8fcfe;
        color: #838383
        
    }

    
</style>
