<template>
  <div style="border: black solid 2px; margin: auto; width: 50%; padding: 10px;">
    <h2>Featured User:</h2>
    <h3>{{ featuredUsername }}</h3>
    <h4>Their pets:</h4>
    <ul>
      <li v-for="pet in featuredPets" :key="pet.id">{{ pet.name }} the {{ pet.type }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'FeaturedUser',
  data() {
    return {
      featuredUser: null,
      featuredUserId: null,
      featuredUsername: null,
      featuredPets: null,
    }
  },
  mounted() {
    fetch("/api/users/featured")
        .then((response) => response.json())
        .then((data) => {
          console.log("featured user response: " + JSON.stringify(data, null, 2))
          this.featuredUser = data;
          this.featuredUsername = this.featuredUser.username
          this.featuredUserId = this.featuredUser.id
        })
        .then(() => {
          fetch(`/api/pets/find?id=${this.featuredUserId}`)
              .then(response => response.json())
              .then(data => {
                console.log("featured pets response: " + JSON.stringify(data, null, 2))
                this.featuredPets = data
              })
        })

  }
}
</script>
