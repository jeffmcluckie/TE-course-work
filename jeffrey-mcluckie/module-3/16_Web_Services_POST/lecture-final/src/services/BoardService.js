import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return http.post('/cards', card);
  },

  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);
  },

  /* Added service methods to add & delete a board */
  addBoard(board) {
    // To test service method failures, you can just use incorrect URLs to get a 404 error
    // This let's you check your messages & the styling & presentation of those messages to the user
    // return http.post('/boardsBLAH', board)
    return http.post('/boards', board);
  },

  deleteBoard(boardID) {
    return http.delete(`/boards/${boardID}`);
  }

}
