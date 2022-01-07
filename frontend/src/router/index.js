import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login";
import About from "../views/About";
import checkAuth from "@/support";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: About,
    beforeEnter: checkAuth,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
