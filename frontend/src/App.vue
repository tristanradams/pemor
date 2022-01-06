<template>
  <HelloWorld/>

  <FeaturedUser/>
  <div class="alert alert-success alert-dismissible fade show" role="alert">
    With Bootstrap!!!
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
<!--  <Users/>-->
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
// import Users from './components/Users.vue'
import FeaturedUser from "./components/FeaturedUser";

export default {
  name: 'App',
  components: {
    HelloWorld, FeaturedUser
  }
}
</script>

<style>

</style>
