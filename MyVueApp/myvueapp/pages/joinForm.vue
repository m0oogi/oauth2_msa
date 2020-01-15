<template>
  <div>
    <h1>User Join Page</h1>
    <table>
      <tr>
        <td><span>ID: </span></td>
        <td><input name="" type="text" /></td>
      </tr>
      <tr>
        <td><span>PW: </span></td>
        <td><input name="" type="password" /></td>
      </tr>
      <tr>
        <td><span>name: </span></td>
        <td><input name="" type="password" /></td>
      </tr>
      <tr>
        <td><span>remark: </span></td>
        <td><input name="" type="password" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><button>가입하기</button></td>
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
    title: 'Join Page'
  }
}

</script>

<style>

</style>