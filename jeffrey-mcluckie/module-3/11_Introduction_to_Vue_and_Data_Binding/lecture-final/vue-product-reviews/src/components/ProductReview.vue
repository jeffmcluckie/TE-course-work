<template>
  <div class="main">
    <h2>Product Reviews for {{name}}</h2>
    <p class="description">{{description}}</p>
    <!-- Aggregate data for all the reviews -->
    <div class="well-display">
      <div class="well">
        <span class="amount">{{averageRating}}</span>
        Average Rating
      </div>
      <div class="well">
        <span class="amount">{{countOfOneStarReviews}}</span>
        1 Star Review{{countOfOneStarReviews === 1 ? '' : 's'}}
      </div>
      <div class="well">
        <span class="amount">{{countOfTwoStarReviews}}</span>
        2 Star Review{{countOfTwoStarReviews === 1 ? '' : 's'}}
      </div>
      <div class="well">
        <span class="amount">{{countOfThreeStarReviews}}</span>
        3 Star Review{{countOfThreeStarReviews === 1 ? '' : 's'}}
      </div>
      <div class="well">
        <span class="amount">{{countOfFourStarReviews}}</span>
        4 Star Review{{countOfFourStarReviews === 1 ? '' : 's'}}
      </div>
      <div class="well">
        <span class="amount">{{countOfFiveStarReviews}}</span>
        5 Star Review{{countOfFiveStarReviews === 1 ? '' : 's'}}
      </div>
    </div>
    <!-- Review data - will get a div for each item in the reviews array -->
    <div class="review" v-bind:class="{isFavorite: review.favorited}"  v-for="review in reviews" v-bind:key="review.id">
      <h4>{{review.reviewer}}</h4>
      <div class="rating" v-bind:title="review.rating + ' Star Review'" >
        <img src="../assets/star.png" v-for="n in review.rating" v-bind:key="n" />
      </div>
      <h3>{{review.title}}</h3>
      <p>{{review.review}}</p>
      <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
    </div>
  </div>
</template>

<script>
export default {
  // A name for the component itself
  name: 'ProductReview',
  // Data sets up variables for each instance of this compenent
  // This function MUST return an object
  data() {
    return {
      name: 'Cigar Parties for Dummies',
      description: 'Host an plan the perfect cigar party for all of your squirrelly friends.',
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false
        }
      ],
    }
  },
  computed: {
    averageRating() {
      let sum = this.reviews.reduce( (currentSum, review) => currentSum + review.rating, 0 );
      let average = sum / this.reviews.length;
      console.log('Sum is', sum, 'Average is', average);
      return average;
    },
    countOfOneStarReviews() {
      let count = this.reviews.reduce( (total, review) => total + (review.rating === 1), 0 );
      return count;
    },
    countOfTwoStarReviews() {
      let count = this.reviews.reduce( (total, review) => total + (review.rating === 2), 0 );
      return count;
    },
    countOfThreeStarReviews() {
      let count = this.reviews.reduce( (total, review) => total + (review.rating === 3), 0 );
      return count;
    },
    countOfFourStarReviews() {
      let count = this.reviews.reduce( (total, review) => total + (review.rating === 4), 0 );
      return count;
    },
    countOfFiveStarReviews() {
      let count = this.reviews.reduce( (total, review) => total + (review.rating === 5), 0 );
      return count;
    },
  }
}
</script>

<style>
div.review.isFavorite {
    background-color: lightyellow;
}

div.main div.well-display {
    display: flex;
    justify-content: space-around;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 0 0.5rem;
  vertical-align: top; /* TODO - This doesn't seem to align text to top of star?! */
}
div.rating {
  height: 2rem;
  display: inline-block;
  margin: 0 0.5rem;
}
div.rating img {
  height: 100%;
}
div.review h3 {
  display: inline-block;
  margin: 0;
}
</style>