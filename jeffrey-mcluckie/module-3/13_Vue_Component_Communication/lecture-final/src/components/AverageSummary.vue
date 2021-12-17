<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  methods: {
    updateFilter() {
      // the filter is in the store, so we use mutations to change that value
      // the mutation setup for the filter is UPDATE_FILTER & we send 0 as the payload
      this.$store.commit("UPDATE_FILTER", 0);
    }
  },
  computed: {
    averageRating() {
      // Accessing the store to see the reviews which are in state
      const reviews = this.$store.state.reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>
