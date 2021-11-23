console.log('Hello Java Green!');

let favColors = [
    {
        name: 'Yuki',
        color: 'blue',
        items: 4
    },
    {
        name: 'Shigure',
        color: 'purple',
        items: 6
    },
    {
        name: 'Kyo',
        color: 'orange',
        items: 3
    },
    {
        name: 'Tohru',
        color: 'pink',
        items: 5
    }
];

console.log('Fav colors is', favColors);

/*************************Get existing stuff on the DOM ******************* */

displayData();

let button = document.getElementById('btn-add');
button.addEventListener('click', (event) => {
    //Stop page refresh on submit
    event.preventDefault();

    //Get data from form inputs and build object
    let newItem = {
        name: document.getElementById('first-name').value,
        color: document.getElementById('color').value,
        items: document.getElementById('items').value
    }

    //Put new item into array
    favColors.push(newItem);
    displayItem(newItem);

    //reset form
    resetForm();
})

let tableBody = document.getElementById('color-data')
tableBody.addEventListener('click', (event) => {
    if(event.target.classList.contains('delete')){
        //make row go away
        let button = event.target;
        let target = button.parentElement.parentElement;
        target.remove();
    }
    console.log('Clicked?', target);
})

function resetForm(){
    document.querySelectorAll('input').forEach(element => element.value = '');
}

function displayData(){
    favColors.forEach(item => displayItem(item));
}

function displayItem(item){
    let newElement = buildNewElement(item);

        // Append that item to the DOM
        let target = document.getElementById('color-data');
        target.insertAdjacentElement('beforeend', newElement);
}

function buildNewElement(favColorObject) {
    // make table row
    let tableRow = document.createElement('tr');
    // make name cell and add to row
    let nameCell = document.createElement('td');
    nameCell.innerText = favColorObject.name;
    tableRow.appendChild(nameCell);
    // color cell
    let colorCell = document.createElement('td');
    colorCell.innerText = favColorObject.color;
    tableRow.appendChild(colorCell);
    // item cell
    let itemsCell = document.createElement('td');
    itemsCell.innerText = favColorObject.items;
    tableRow.appendChild(itemsCell);
    // delete button
    let buttonCell = document.createElement('td');
    let button = document.createElement('button');
    button.innerText = 'Delete';
    button.classList.add('delete');
    buttonCell.appendChild(button);
    tableRow.appendChild(buttonCell);


    //give back tablerow
    return tableRow;
}