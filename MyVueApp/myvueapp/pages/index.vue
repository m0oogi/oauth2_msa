<template>
  <div>
    <h1>Home Page</h1>
    <NLink to="/loginForm">
      Login Page
    </NLink>
    <br/>
    <NLink to="/joinForm">
      User Join Page
    </NLink>
    <br/>
    <button v-on:click="toDataPage">DataPage</button>
    <br/>
    <button v-on:click="ckToken">토큰확인</button>
    <br/>
    <button v-on:click="deleteCookie">쿠키삭제</button>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  head: {
    title: 'Home page'
  },
  methods:{
    ckToken(){
        axios({
            method: 'get',
            url:'/members',
            headers: {
              'Authorization' : 'bearer ' + getCookie('oauthtoken')
            }
        })
        .then((Response)=>{
            console.log(Response);
        })
        .catch((err)=>{console.log(err);});
    },
    toDataPage(){
        location.href="/toDataPage?access_token=" + getCookie('oauthtoken');
    },
    deleteCookie(){
        var expireDate = new Date();
        expireDate.setDate( expireDate.getDate() - 1 );
        document.cookie = "oauthtoken= " + "; expires=" + expireDate.toGMTString() + "; path=/";
    }
  }
}//export default

function getCookie(cookie_name) {
  var x, y;
  var val = document.cookie.split(';');

  for (var i = 0; i < val.length; i++) {
    x = val[i].substr(0, val[i].indexOf('='));
    y = val[i].substr(val[i].indexOf('=')+1,val[i].indexOf('expires')-11);
    if (x == cookie_name) {
      return y;
    }
  }
}//getCookie


</script>
