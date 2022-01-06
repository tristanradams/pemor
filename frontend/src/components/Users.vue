<template>
  <h2>Fetched Users</h2>
  <div v-for="user in users" :key="user.id" style="border: medium black solid;">
    <h3>{{ user.username }}</h3>
    <h4>Pets:</h4>

    <div v-if="user.pets.length === 0">
      <li>
        No pets added yet
      </li>
    </div>
    <div v-else v-for="pet in user.pets" :key="pet.id">
      <ul>
        <li>
          {{ pet.name }}, {{ pet.type }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Users',
  data() {
    return {
      users: [],
      pets: [],
    }
  },
  mounted() {
    fetch("/api/users")
        .then((response) => response.json())
        .then((data) => {
          console.log("users response: " + JSON.stringify(data, null, 2))
          this.users = data;
        })
    fetch("/api/pets")
        .then((response) => response.json())
        .then((data) => {
          this.pets = data;
          const originalUsers = this.users
          const refactoredUsers = originalUsers.map(user => {
                const pets = data.filter(pet => {
                  if (pet.userId === user.id) {
                    return pet
                  }
                })

                return {...user, pets: pets}
              }
          )

          console.log("users after manipulation: " + JSON.stringify(refactoredUsers, null, 2))
          this.pets = data;
          this.users = refactoredUsers;
        })
  }
}
</script>
