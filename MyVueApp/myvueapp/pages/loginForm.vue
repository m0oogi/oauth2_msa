<template>
  <div>
    <h1>Login Page</h1>
    <p>Hi from {{ name }}</p>
    <table>
      <tr>
        <td><span>ID: </span></td>
        <td><input type="text" /></td>
      </tr>
      <tr>
        <td><span>PW: </span></td>
        <td><input type="password" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><button>로그인</button></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><NLink to="/">Go Home</NLink></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  asyncData () {
    return {
      name: process.static ? 'static' : (process.server ? 'server' : 'client')
    }
  },
  head: {
    title: 'Login Page'
  }
}

</script>

<style>

</style>