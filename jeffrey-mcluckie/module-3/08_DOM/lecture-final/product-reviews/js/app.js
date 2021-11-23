const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  console.log('Setting page title');
  // document is a variable setup by the browser to access the DOM
  let pageTitle = document.getElementById('page-title');
  // using pageTitle here (not document) restricts the search to just that element
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  // Can use querySelector on the entire DOM document too...
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  // Select the element to put the reviews into
  let main = document.getElementById('main');

  reviews.forEach( review => {
    // Create the div to add for a review
    let reviewDiv = document.createElement('div');
    // Add style class onto the div (can be used to add any attribute)
    reviewDiv.setAttribute('class', 'review');
    addReviewer(reviewDiv, review.reviewer);
    addRating(reviewDiv, review.rating);
    addTitle(reviewDiv, review.title);
    addReview(reviewDiv, review.review);

    // Add the div as the last child of the element with the main id
    main.insertAdjacentElement('beforeend', reviewDiv);
  });


}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  console.log('Element to add to:', parent, 'Name of reviewer', name);
  let reviewerHeading = document.createElement('h4');
  // Put the text into the element
  reviewerHeading.innerText = name;
  // Another way to add a child element to the DOM
  parent.appendChild(reviewerHeading);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  let ratingDiv = document.createElement('div');
  ratingDiv.setAttribute('class', 'rating'); 
  // make the correct number Of Stars to add to the rating div 
  for (let count = 0; count < numberOfStars; count++) {
    let star = document.createElement('img');
    // set the src & class attributes
    star.setAttribute('src', 'img/star.png'); 
    star.setAttribute('class', 'ratingStar');
    // add the star to the rating div
    ratingDiv.appendChild(star);
  }
  // add the rating div to the parent
  parent.appendChild(ratingDiv);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  let titleElement = document.createElement('h3');
  titleElement.innerText = title;
  parent.appendChild(titleElement);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  let paragraph = document.createElement('p');
  paragraph.innerText = review;
  parent.appendChild(paragraph);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
