<template>
  <header>
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>
  </header>
</template>

<script>
export default {
  name: 'header',
  props: {
    name: {
      type: String,
      required: true
    },
    description: String
  }
}
</script>

<style>

</style>