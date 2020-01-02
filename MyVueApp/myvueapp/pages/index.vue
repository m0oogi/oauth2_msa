<template>
  <div>
    <h1>Main Page</h1>
    <NLink to="/loginForm">
      Login Page
    </NLink>
    <br/>
    <NLink to="/joinForm">
      User Join Page
    </NLink>
  </div>
</template>

<script>
export default {
  head: {
    title: 'Home page'
  }
}
</script>
