
// let sumNumbers = (number1, number2) => {
//     return number1 + number2;
// }

// Definition below and the one above are the same.
// When there is just one line in the function that returns a value, the 
// {} and the word return are left off and assumed.
let sumNumbers = (number1, number2) => number1 + number2;


// Function declaration for arrow function above
function sumNumbersDeclared(num1, num2) {
    return num1 + num2;
}

console.log("Use arrow function to sum 1, 2: ", sumNumbers(1, 2));
console.log("Use declared function to sum 1, 2: ", sumNumbersDeclared(1, 2));

// let timesTwo = (num) => {
//     return num * 2;
// }

// If there is only 1 input, the () are also left off
let timesTwo = num => num * 2;



// ********************* Array Map *************************
let names = ["Jordan", "Ryan", "Carly", "Nicholas"];
console.log(`Names are: `, names );

let hellos = names.map( item => `Hello, ${item}. Welcome to map!`);
console.log('Hellos are: ', hellos);

hellos = names.map( (item, index) => `Hello, ${item}. You are person ${index}. Welcome to map!`);
console.log('Hellos are: ', hellos);