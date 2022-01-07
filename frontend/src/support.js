import store from "@/main";

function checkAuth(to, from, next) {
  console.log(
    "in the beforeEnter, current state is: " + store.state.isAuthenticated
  );
  if (!store.state.isAuthenticated) {
    next(false);
  } else {
    next();
  }
}

export default checkAuth;
