<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <!-- This works, BUT is not the best practice. Should use the route name not path -->
      <!-- <router-link to="/">Back to Products</router-link>&nbsp;| -->
      <!-- Best Practice is to use the route name not the path: -->
      <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>&nbsp;|
      <router-link v-bind:to="{ name: 'add-review' }">Add Review</router-link>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import ReviewList from '@/components/ReviewList';

export default {
  name: 'product-detail',
  components: {
    AverageSummary,
    StarSummary,
    ReviewList
  },
  /* This is a Vue life-cycle hook (see references in the z_notes.md). It is setting the 
     active product id from the vue route parameter. */
  created() {
    const activeProductId = this.$route.params.id;
    this.$store.commit("SET_ACTIVE_PRODUCT", activeProductId);
  },
  /* This determines the product to display from the active product id in the vuex store. 
     (Searches through all the products to find the one with the matching id.) */
  computed: {
    product() {
      return this.$store.state.products.find(
        item => item.id == this.$store.state.activeProduct
      )
    }
  }
}
</script>

<style>

</style>