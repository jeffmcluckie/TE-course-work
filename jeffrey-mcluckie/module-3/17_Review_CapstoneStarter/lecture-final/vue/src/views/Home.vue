<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <message />
  </div>
</template>

<script>
import Message from '@/components/Message';

export default {
  name: "home",
  components: {
    Message
  }
};
</script>
