<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <h1>HOME</h1>
    <h2>isAuthenticated: {{ this.isAuthenticated }}</h2>
    <div v-if="isAuthenticated">
      <h2>Welcome {{ this.currentUser.username }}!</h2>
    </div>
    <button v-on:click="click">test</button>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  components: {},
  data() {
    return {
      isAuthenticated: this.$store.state.isAuthenticated,
      currentUser: this.$store.state.currentUser,
    };
  },
  methods: {
    click() {
      this.$store.commit("increment");
      console.log(JSON.stringify(this.$store, null, 2));
      console.log(this.$store.state.count);
    },
  },
};
</script>
