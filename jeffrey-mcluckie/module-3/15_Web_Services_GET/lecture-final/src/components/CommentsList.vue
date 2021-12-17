<template>
  <div class="comments">
    <h2>Comments</h2>
    <div v-for="comment in comments" v-bind:key="comment.id" >
      <comment v-bind:comment="comment" />
    </div>
  </div>
</template>

<script>
import Comment from '@/components/Comment';

export default {
  name: "comments-list",
  components: {
    Comment
  },
  props: ['comments']
};
</script>

<style scoped>
.comments {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 10px 20px 20px 20px;
}
.comments h2 {
  margin: 0 0 30px 0;
}
</style>
