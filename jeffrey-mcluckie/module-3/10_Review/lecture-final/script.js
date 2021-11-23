console.log('Hello Java Green!');

let idCounter = 5; // We already have 4 in the array

let favColors = [
    {
        id: 1,
        name: 'Yuki',
        color: 'blue',
        items: 4
    },
    {
        id: 2,
        name: 'Shigure',
        color: 'purple',
        items: 6
    },
    {
        id: 3,
        name: 'Kyo',
        color: 'orange',
        items: 3
    },
    {
        id: 4,
        name: 'Tohru',
        color: 'pink',
        items: 5
    }
];

console.log('Fav colors is', favColors);

/************************* Get existing stuff on the DOM ****************************/

displayData();


/************************* Setting up the form submit ****************************/
let form = document.getElementById('form-add');
form.addEventListener('submit', (event) => {
    // Stop page refresh on submit
    event.preventDefault();

    // Get data from form inputs & build new JS Object
    let newItem = {
        id: idCounter,
        name: document.getElementById('first-name').value,
        color: document.getElementById('color').value,
        items: document.getElementById('items').value
    }
    idCounter += 1;

    // Do validation to make sure the value is between 0 and 10
    // if (newItem.items < 0 || newItem.items > 10) {
    //     alert('The number of items must be between 0 and 10');
    // }

    // Put the new item into the array of data
    favColors.push(newItem);
    displayItem(newItem);

    // Clear the form inputs to reset the form
    resetAddForm();
});

/************************* Setting up the listener for the delete button ****************************/

let tableBody = document.getElementById('color-data');
tableBody.addEventListener('click', (event) => {
    // If the thing we clicked on has the delete class, then do the thing
    if ( event.target.classList.contains('delete') ) {
        let button = event.target;
        console.log('Clicked Delete');
        // Take the row off the DOM - the row is the grandparent of the button (so 2 parents up)
        button.parentElement.parentElement.remove();
        // Take the item out of the array
        let id = button.getAttribute('data');
        removeItem(id);
    }
})




/************************* functions used above ****************************/
/*
  itemId = 2
  indexToRemove = 1
  i = 1
  item = 2nd object
*/


function removeItem( itemId ){
    console.log('Removing item', itemId);

    let indexToRemove = -1;
    for(let i=0; i<favColors.length; i++){
        let item = favColors[i];
        if (item.id === Number(itemId)) {
            indexToRemove = i;
            break;
        }
    }

    //Make sure something was found
    if (indexToRemove >= 0){
        favColors.splice(indexToRemove, 1);
    }
}

function resetAddForm() {
    // Select all the text inputs and clear the value (set to empty string)
    document.querySelectorAll('input:text').forEach(element => element.value = '');
}


function displayData(){
    favColors.forEach( item => displayItem(item) )
}

function displayItem(item){
    // Create new HTML element from the array item
    let newElement = buildNewElement(item);

    // Append that item to the DOM
    let target = document.getElementById('color-data');
    target.insertAdjacentElement('beforeend', newElement);
}

// TODO - consider refactoring to avoid duplicate code for creating TD's
function buildNewElement(favColorObject) {
    // Make the table row
    let tableRow = document.createElement('tr');
    // Make the name cell & add to the row
    let nameCell = document.createElement('td');
    nameCell.innerText = favColorObject.name;
    tableRow.appendChild(nameCell);
    // Make the color cell & add to the row
    let colorCell = document.createElement('td');
    colorCell.innerText = favColorObject.color;
    tableRow.appendChild(colorCell);
    // Make the items cell & add to the row
    let itemCell = document.createElement('td');
    itemCell.innerText = favColorObject.items;
    tableRow.appendChild(itemCell);
    // Make a button cell w/ a delete button & add to the row
    let buttonCell = document.createElement('td');
    let button = document.createElement('button');
    button.innerText = 'Delete';
    button.classList.add('delete');
    buttonCell.appendChild(button);
    tableRow.appendChild(buttonCell);

    // Add a data attribute to the button to make deleting the element from the array easier
    button.setAttribute('data', favColorObject.id);

    // Give back the new element
    return tableRow;
}




