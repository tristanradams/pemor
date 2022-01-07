<template>
  <div class="login">
    <img alt="Vue logo" src="../assets/logo.png" />
    <div>
      <h1>Login</h1>
      <input
        type="text"
        name="username"
        v-model="input.username"
        placeholder="Username"
      />
      <input
        type="text"
        name="password"
        v-model="input.password"
        placeholder="Password"
      />
      <button type="button" v-on:click="submit">login</button>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Login",
  components: {},
  data() {
    return {
      input: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    submit() {
      console.log(
        "submitting: " + this.input.username + " " + this.input.password
      );
      fetch("/api/users/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: this.input.username,
          password: this.input.password,
        }),
      })
        .catch((response) => {
          console.log(response);
        })
        .then((response) => response.status)
        .then((status) => {
          if (status === 200) {
            this.$store.commit("login", this.input.username);
            console.log(
              "Changed the isAuthenticated, current state is: " +
                this.$store.state.isAuthenticated
            );
          } else {
            this.$router.replace({ name: "Home" });
          }
        });
    },
  },
};
</script>
