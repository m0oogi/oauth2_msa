<template>
  <div>
    <h1>Login Page</h1>
    <form @submit.prevent="loginPost">
      <table>
      <tr>
        <td><span>ID: </span></td>
        <td><input v-model.lazy="inputID" name="inputID" placeholder="input id"/></td>
      </tr>
      <tr>
        <td><span>PW: </span></td>
        <td><input v-model.lazy="inputPW" name="inputPW" placeholder="input password"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><button>Login</button></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><NLink to="/">Go Home</NLink></td>
      </tr>
    </table>
    </form>
  </div>
</template>

<script>
const axios = require('axios');
const qs = require('querystring');
export default {
  componets:{
  },
  head:{
    title: 'Login Page'
  },
  data() {
    return {
      inputID : '',
      inputPW : ''
    }
  },
  methods:{
    loginPost(){
      console.log('inputid : ' + this.inputID);
      console.log('inputpw : ' + this.inputPW);
      axios({
          method: 'post',
          url:'/oauth/token',
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
          auth: {
            username:'client_test1',
            password:'pengsu'
          },
          data: qs.stringify({
            'grant_type': 'password',
            'client_id' : 'client_test1',
            'username'  : this.inputID,
            'password'  : this.inputPW,
            'scope'     : 'read'
          })
          })
           .then(
              (Response)=>{
                console.log(Response);
                createCookie(Response.data.access_token);
                alert("로그인 되었습니다")
                this.$router.push('/');
              })
           .catch((err)=>{console.log(err);});
    }
  } 
}

function createCookie(token){
  var date = new Date();
  date.setDate(date.getDate()+1);

  var willCookie = "";
  willCookie += "oauthtoken="+token;
  willCookie += "expires="+date.toUTCString();
  document.cookie = willCookie;
}

</script>

<style>

</style>