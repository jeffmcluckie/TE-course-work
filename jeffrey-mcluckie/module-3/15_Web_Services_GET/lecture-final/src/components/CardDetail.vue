<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{card.title}}</h1>
      <p>{{card.description}}</p>
      <comments-list v-bind:comments="card.comments" />
    </div>
  </div>
</template>

<script>
import boardService from '../services/BoardService';
import CommentsList from '@/components/CommentsList';

export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data() {
    return {
      isLoading: true,
      card: {
        title: '',
        description: '',
        status: '',
        comments: []
      }
    }
  },
  created() {
    let boardId = this.$route.params.boardID;
    let cardId = this.$route.params.cardID;
    boardService.getCard(boardId, cardId)
      .then( response => {
        // Don't need response.data here because it is already handled in the service code
        this.card = response; 
        this.isLoading = false;
      })
  }
};
</script>
