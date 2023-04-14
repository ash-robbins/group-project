<template>
  <div class="container">
    <header>
        <div>
        <img src="../images/Tech_Reader_Logo-removebg-preview.png" alt="" />
        </div>
        <div>TE Book Club </div>
    </header>

    <section id="left-panel">
        <nav>
            <menu>
                <li>

                </li>
            </menu>
        </nav>
        
    </section>
    <nav>
        <div class="content">
            <div><router-link v-bind:to="{ name: 'home' }">Home </router-link></div> 
            <div><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout </router-link></div>
            <div> <router-link v-bind:to="{name: 'books'}">Books</router-link> </div>
            <div> <router-link v-bind:to="{name: 'prizes'}">Prizes</router-link></div>
            <div> <router-link v-bind:to="{name: 'family-account'}">Family</router-link></div>
        </div>
    </nav> 

    <main>
        <div>
                    <!-- different views/pages are displayed/injected here -->

            <router-view />
        </div>
    </main>



    <aside>
        <div class="content">
                        SideBar /Info
        </div>
    </aside>

    <footer>
        <div class="content">
                            Footer Content
        </div>
    </footer>
    
  
  </div>
</template>

<script>
    
   
  export default {
   
  };
</script>

<style>
    body {
        margin: 0;
    }

    /* Add CSS Grid here  background colors: Header - #f69a00;  Nav - #f2ead2;  
    main - #f9f5f0;  aside - #f2ead2;  footer - #331312;
    font colors header, footer - #ffffff;  nav, main, aside - #74889a;*/

    .container{
        display: grid;

        grid-template-areas: 
            "header header header" 
            "nav content side"   /*main = content and side = aside*/ 
            "footer footer footer";

        grid-template-columns: 200px 1fr 200px;
        grid-template-rows: 125px 1fr 85px;
        gap: 10px;

        height: 100vh;


    }
    /*handle responsive behavior */
    @media (max-width: 768px) {
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
        nav, aside, main {
        margin: 10px;
        
        }
        /* Navigation bar becomes side by side*/
        nav div.content {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        align-items: center;
        padding: 0 10px;
    }

    }

    /* Highlights tabs in nav*/
    .content > div:hover {
        display: block;
        background-color: rgba(208, 235, 252, 0.5);
        border-radius: 30px 30px 30px 30px;
        
    }

    /* Logo */
    header div img {
        height: 100px;
        margin: 10px;
    } 

    header {
    grid-area: header;
    background-color: #f8f7ff; /*Great White*/

    display: flex;
    align-items: center;    
    }

    footer {
        grid-area: footer;
        background-color: #f8f7ff;
    }

    /* Header & Footer font color */
    header, footer {
        color: #505050;
    }

    main {
        grid-area: content;
        background-color: #f8f7ff; 

        color: #505050;

        border-radius: 10px;

    }


    nav {
        grid-area: nav;
        margin-left: 0.5rem;
        background-color: #f8f7ff;

        border-radius: 10px;

        
    }

    aside {
        grid-area: side;
        margin-right: 0.5rem;
        background-color: #424B54;

        border-radius: 10px;
    }

    nav, aside {
        color: #ffffff;
    }

    header, footer, nav, main, aside {
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 24px;
        text-transform: uppercase;
    }

    div.content {
        text-align: center;
        padding-top: 20px;
    }
</style>
