<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <h1 v-if="msg.length > 0">
      {{msg}}
    </h1>
    <p v-else>
      no text
    </p>
    <input type="text" v-model="msg">
    <button @click="hello()">hello</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      msg: 'helloworld!'
    }
  },
  methods: {
    hello () {
      axios.get('http://localhost:8080/hello')
        .then(response => {
          this.msg = response.data
       })
        .catch(err => {
         this.msg = err;
      })
    }
  },
  headers: {
    'Content-Type': 'application/json;charset=UTF-8',
    'Access-Control-Allow-Origin': '*',
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
