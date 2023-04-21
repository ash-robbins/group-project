<template>
<div>
   <div class="topic-list">
    <table>
      <thead>
        <tr>
          <!-- <th>UserId</th> -->
          <th>Your Family Members</th>
          <!-- <th>Edit</th>
          <th>Delete</th> -->
        </tr>
      </thead>
      <tbody>
        <tr v-bind:familymember="familymember" v-for="familymember in familyMembers"  v-bind:key="familymember.userId">
          <!-- <td width="80%">
            User Id Number: {{familymember.userId}} 
            <router-link
              v-bind:to="{ name: 'Messages', params: { id: topic.id } }"
            >{{ topic.title }}</router-link>
          </td> -->
          <td>
            <router-link v-bind:to="{name: 'familymember-books', params:{id: familymember.userId}}">  {{familymember.username[0].toUpperCase()}}{{familymember.username.slice(1)}} </router-link>
            
              </td>
          <!-- <td>
            <router-link :to="{ name: 'EditTopic', params: {id: topic.id} }">Edit</router-link>
          </td>
          <td>
            <a href="#" v-on:click="deleteTopic(topic.id)">Delete</a>
          </td> -->
        </tr>
      </tbody>
    </table>

    <button v-if="newMemberForm == true" v-on:click.prevent="newMemberForm = false" >Add New Family Member</button>
    <form v-else v-on:submit.prevent="addFamilyMember">
        <br><br>
        <label for="username">Enter Members Username to add to Family     </label>
        <input class ="newfamilymember_input" type="text" id="username" v-model="newFamilyMember.username" placeholder="Family Member's Username" />
       
        <input class = "submit_new_fam_mem" type="submit" value="Submit"/>
    </form>
  </div>



<!-- <family-member-card v-bind:familymember="familymember" v-for="familymember in familyMembers"  v-bind:key="familymember.userId"/> -->
<!-- {{familyMembers[0].userId}} -->
<!-- <div v-for="familymember in familyMembers" v-bind:key="familymember.userId"> user id is: {{familymember.userId}}</div> -->
</div>
</template>

<script>
 //import FamilyMemberCard from './FamilyMemberCard.vue'
import familyMemberService from '../services/FamilyMemberService.js'
export default {
    components: {
     //    FamilyMemberCard
    },
     data() {
    return {
      familyMembers: [],
      newMemberForm: true,
      newFamilyMember: {
          username: ''
      }
    }
  },
  methods:{
      addFamilyMember(){
          console.log("clicked on added family member")
        familyMemberService.addFamilyMember(this.newFamilyMember)
        .then(response=>{
            if(response.status === 201 ){
                 this.$router.push('/books')
            }
        })
        this.newMemberForm = true;
      }
  },
    created() {
    familyMemberService.list()
    .then((response) => {
      this.familyMembers = response.data;
      console.log(this.familyMembers)
    });
  }

}
</script>

<style>
.topic-list {
  margin: 0 auto;
  max-width: 800px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
table {
  text-align: left;
  width: 800px;
  border-collapse: collapse;
}
tbody tr:nth-child(even) {
  background-color:white;
}

tbody tr:nth-child(odd) {
  background-color: rgba(121, 12, 194, 0.1);
}
td {
  padding: 4px;
}


.topic-list a:link,
.topic-list a:visited {
  color: blue;
  text-decoration: none;
}
.topic-list a:hover {
  text-decoration: underline;
}
button ,.submit_new_fam_mem{
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
.newfamilymember_input{
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

</style>
FamilyMemberCard