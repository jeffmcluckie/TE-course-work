import axios from 'axios';

export default {

  getMessage() {
    return axios.get('/message');
  }
}