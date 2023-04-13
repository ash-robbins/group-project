<template>
  <div class="container">
    <header>
      header content
    
      </header>

      <nav>
        Left nav component
      <div class="content">
      Navigation
      <div><router-link v-bind:to="{ name: 'home' }">Home </router-link>&nbsp;|&nbsp; </div> 
      <div><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></div>
     <div> <router-link v-bind:to="{name: 'books'}">Books</router-link> </div>
     <div> <router-link v-bind:to="{name: 'prizes'}">Prizes</router-link></div>
      <div> <router-link v-bind:to="{name: 'family-account'}">Create Family account</router-link></div>
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
                Family name:
              <div v-for="family in $store.state.family" v-bind:key="family.name"> 
                   {{family.name}}
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
            "nav content side"
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
                75px /*Nav*/
                1fr /* content */
                75px /* Sidebar */
                auto; /* Footer */
            
        }
        header, footer, nav, main, aside {
            padding: 5px 0;
        }
        nav, aside {
        margin: 0;
        }

    }

    header {
    grid-area: header;
    background-color: #f69a00;
    }

    nav {
        grid-area: nav;
        margin-left: 0.5rem;
        background-color: #f2ead2;
    }

    nav div{
        padding: 10px;

    }

    main {
        grid-area: content;
        background-color: #f9f5f0;
    }

    aside {
        grid-area: side;
        margin-right: 0.5rem;
        background-color: #f2ead2;
    }

    footer {
        grid-area: footer;
        background-color: #331312;
    }

    header, footer {
        color: #ffffff;
    }
    nav, main, aside {
        color: #74889a;
    }
    header, footer, nav, main, aside {
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 20px;
        text-transform: uppercase;
    }

    div.content {
        text-align: center;
        padding-top: 20px;
    }
</style>
