<template>
  <div class="comment">
    <h3>{{comment.author}}</h3>
    <p class="postedOn">{{comment.postedOn}}</p>
    <p>{{comment.body}}</p>
  </div>
</template>

<script>
export default {
  name: "comment",
  props: ['comment']
};
</script>

<style>
.comment {
  margin: 20px 0;
  border-bottom: 1px solid rgb(180, 180, 180);
}
.comment:last-child {
  border-bottom: none;
}
.comment h3 {
  margin-bottom: 0;
}
.postedOn {
  margin-top: 4px;
  font-size: 0.75rem;
}
</style>