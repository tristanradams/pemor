import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import { Store } from "vuex";
import createPersistedState from "vuex-persistedstate";

const store = new Store({
  plugins: [createPersistedState({ storage: window.sessionStorage })],
  state: {
    count: 0,
    isAuthenticated: false,
    currentUser: {
      username: "",
      userId: "",
    },
  },
  mutations: {
    increment(state, test) {
      console.log(test);
      state.count++;
    },
    login(state, username) {
      state.isAuthenticated = true;
      state.currentUser.username = username;
    },
    logout(state) {
      state.isAuthenticated = false;
      state.currentUser.username = "";
    },
  },
});

createApp(App).use(router).use(store).mount("#app");
export default store;
