<template>
    <div>
        <p v-if="isLoading">Loading...</p>
        <p v-else>Message: "{{message.text}}" recieved on {{formattedDate}}</p>
    </div>
</template>

<script>
import messageService from '../services/MessageService';
import moment from 'moment';

export default {
    name: 'message',
    data() {
        return {
            message: {
                text: '',
                date: ''
            },
            isLoading: true
        }
    },
    computed: {
        formattedDate() {
            return moment(this.message.date).format('MMM Do YYYY');
        }
    },
    created() {
        messageService.getMessage()
            .then( response => {
                this.message = response.data;
                this.isLoading = false;
            })
            .catch( error => {
                // Don't do this in your app end-state, you wanna show an error message on the screen.
                console.log('Opps... An error occurred: ', error);
                this.isLoading = false;
            })
    }
}
</script>

<style>

</style>