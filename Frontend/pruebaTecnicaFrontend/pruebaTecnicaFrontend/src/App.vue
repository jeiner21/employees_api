<script setup lang="ts">
import Navbar from './components/Navbar.vue';
</script>

<template>

  <Navbar />

  <router-view />

</template>

<style scoped>
.navbar {
  background: #1976d2;
  padding: 15px;
  display: flex;
  gap: 20px;
}

.navbar a {
  color: white;
  text-decoration: none;
  font-weight: bold;
}

.navbar a.router-link-active {
  text-decoration: underline;
}
</style>
