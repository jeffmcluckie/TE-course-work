const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 * 
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

// Set the product reviews page title.
setPageTitle();
// Set the product reviews page description.
setPageDescription();
// Display all of the product reviews on our page.
displayReviews();

// Make the edit box for the description show when someone clicks on the description
let descriptionText = document.querySelector('.description');
descriptionText.addEventListener('click', (event) => {
  let descElement = event.target;
  // The toggle function expects us to pass in the description element, NOT an event
  toggleDescriptionEdit(descElement);
});


/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = description;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

// Make the description edit box save on enter key press BUT cancel on anything else
let descInput = document.getElementById('inputDesc');
descInput.addEventListener('keyup', (event) => {
  // default to not saving text
  let save = false;
  if (event.key === 'Enter') {
    save = true;
    exitDescriptionEdit(event.target, save);
  } 
  if (event.key === 'Escape') {
    exitDescriptionEdit(event.target, save);
  }
})

// Don't save if we just click out of the box.
// Blur means the input has lost focus (ie clicked somewhere else)
descInput.addEventListener('blur', (event) => {
  exitDescriptionEdit(event.target, false);
})

let formButton = document.getElementById('btnToggleForm');
formButton.addEventListener('click', showHideForm)

/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    description = textBox.value;
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

// Make the save button call the saveReview function
document.getElementById('btnSaveReview').addEventListener('click', (event) => {
  // Default form behavior on submit is to refresh the page. 
  // We don't want that to happen, so we prevent the default behavior
  event.preventDefault();
  saveReview();
});

/**
 * Save the review that was added using the add review form.
 */
function saveReview() {
  console.log('Saving review');

  // Grab my input fields
  // input fields have value not innerText
  const name = document.getElementById('name').value;
  const title = document.getElementById('title').value;
  const review = document.getElementById('review').value;
  const rating = document.getElementById('rating').value;

  let newReview = {
    reviewer: name,
    title: title,
    review: review,
    rating: rating
  };

  reviews.push(newReview);
  displayReview(newReview);
  showHideForm();
}
