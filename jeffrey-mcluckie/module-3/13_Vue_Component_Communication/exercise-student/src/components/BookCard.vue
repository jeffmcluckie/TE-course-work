<template>
  <div class="card">
      <div class="book-title">{{book.title}}</div>
      <div class="book-author">{{book.author}}</div>

    <div class="cover">
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    </div>
    <button v-bind:class="classChange" v-on:click="onReadChange">{{buttonDisplay}}</button>
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        onReadChange(){
            this.$store.commit("FLIP_READ", this.book);
        }
    },
    computed: {
        classChange(){
            if(this.book.read === true){
                return "mark-unread";
            }
            return "mark-read";
        },
        buttonDisplay(){
            if(this.book.read === true){
                return "Mark Unread";
            }
            return "Mark Read";
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>