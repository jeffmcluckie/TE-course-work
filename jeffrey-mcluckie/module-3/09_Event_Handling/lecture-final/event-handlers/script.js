console.log('Hello');

let button = document.getElementById('btn-click-me');

// ************ Event Handling with named function *****************/
// button.addEventListener('click', sayHello);

// function sayHello() {
//     console.log('Hello. Thank you for clicking me');
// }

// ************ Event Handling with anonymous function *****************/
button.addEventListener('click', () => {
    console.log('Hello. Thank you for clicking me');
});


// This also makes an anonymous function BUT
//   you don't see this much now that we have arrow functions
// button.addEventListener('click', function () { 
//     console.log('Hello. Thank you for clicking me');
// });

//*********************** Colors & Event Delegation ***********************/

// TODO - add an event handler to the add orange button to 
//       console.log it was clicked
document.getElementById('btn-add-orange').addEventListener('click', 
    () => {
        console.log('Clicked Orange');
        let list = document.getElementById('ul-colors');
        let orange = document.createElement('li');
        orange.innerText = 'Orange';
        list.appendChild(orange);
    })

// Make the color list items change background color when clicked

// Can get the event object from the event listener/handler
let changeColor = (event) => {
    console.log('Clicked color list');
    // event target is the DOM element that the event happened on
    let li = event.target;
    let colorText = li.innerText;
    li.style.backgroundColor = colorText;
}

let removeColor = (event) => {
    console.log('Clicked color list');
    let li = event.target;
    li.style.backgroundColor = 'white';
}


// This added event listeners to the li's individually BUT when we
// add new li's to the list, they do not get the event listener.

// document.querySelectorAll('li').forEach(
//     item => {
//         item.addEventListener('click', changeColor)
//         item.addEventListener('dblclick', removeColor)
//     }
// );

// BETTER PRACTICE - put the event listener on the parent
let colorList = document.getElementById('ul-colors');
colorList.addEventListener('click', (event) => {
    // Checking first that the event target is a li before doing stuff
    if (event.target.nodeName.toLowerCase() == 'li') {
        changeColor(event);
    }
});
colorList.addEventListener('dblclick', (event) => {
    // Checking first that the event target is a li before doing stuff
    if (event.target.nodeName.toLowerCase() == 'li') {
        removeColor(event);
    }
});