/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

// Write to the console
// Strings can go in either single or double quotes
console.log('Hello, Java-Green!'); // Best practice is single over double
console.log("Woot! Isn't this cool!");

// Format strings w/ template literal strings, allows you to plug in variables ${}
let message = 'Hello';
console.log(`This allows you to plug in variables. The message is: ${message}`);
console.log('Can also concatenate with ' + 'the + operator.');

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const ANSWER_TO_LIFE_UNIVERSE_EVERYTHING = 42;
  // Declares a variable those value can be changed
  let changeableValue = 32;
  // Declares a variable that will always be an array
  // This is a constant whose value never changes - 
  const instructors = ['Mary', 'Katie', 'Kevin', 'Christopher'];
  console.log(`The array of instructors is: ${instructors}`);

  // Can change the values in the array, even though it is declared as a const
  instructors.push('Kyo');
  console.log(`The array of instructors is: ${instructors}`);

  // BUT CANNOT reassign to a new array 
  //instructors = []; // This breaks the code - runtime error "Assignment to constant variable"

  // Old way to make variable was using var
  // It's old and does weird stuff w/ scope
  // var blah = 'Blah!';
  // console.log(blah);

  // Can make a variable without a keyword BUT DON'T (makes them similar to var)
  // newVariable = 'Boo!';
  // console.log(newVariable);

  // Variables don't have a type, so it can change
  let myVariable = 42;
  myVariable = 'Woot!';
  myVariable = [ 2, 3, 4 , 6 ];
  myVariable = variables;
  console.log('The value of myVariable is:', myVariable);
}

// Must call a function for it to run
variables();


/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

//Call the function printParameters
printParameters(1, 2);
printParameters('Hello', 'Java Green');
printParameters([1, 2, 4], 'Hello');

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true -- double = will coerce types to be the same if it can
  console.log(`x === y : ${x === y}`); // false -- triple equals will never change/coerce types
  // Using === is considered a best practice
}

equality(3, '3');

// Functions - do you have to declare functions before you can use them...
console.log('Calling function before it is declared...');
falsy('Hello');

// This DOES NOT WORK - have to do it after the variable assignment to the function
// myFunction('Hello');

// Can also name a function this way as opposed to the typical function declaration we saw above
// Cannot call this function until after 
const myFunction = function (str) {
  console.log('Hello, my string is ' + str);
}

// This works fine, just like calling any other function.
myFunction('Hello');


/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
// function falsy(x) {
//   if (x) {
//     console.log(`${x} is truthy`);
//   } else {
//     console.log(`${x} is falsy`);
//   }
// }

// Probably better for function above to return a value

function falsy(x) {
  if (x) {
    return `${x} is truthy`;
  } else {
   return `${x} is falsy`;
  }
}

let result = falsy(null);
// TODO - console.log('Is null falsy? (expect true)', result);

// If a value (like a return from a function that doesn't return anything) is unassigned, 
// it's value is undefined
// show the return value of something that doesn't have a return
result = objects();
console.log('If the function does not have a return it returns ' + result + ' automatically.');

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    sayHello: function () { console.log('Hello') }
  };

  // Log the object - Bill Lumbergh
  console.log(person);

  // Log the first and last name
  console.log(person.firstName + ' ' + person.lastName);
  console.log(person.sayHello());

  // Log each employee
  console.log('***** Log each employee *******');
  // for (let emp of person.employees){
  //   console.log(emp);
  // }
  for (let i=0; i<person.employees.length; i++) {
    console.log( person.employees[i] );
  }

  // If we want to access person outside the scope of our function, 
  // we need to return it
  return person;
}

// TODO - how do I log Bill Lumbergh here ?
// Can't do this, person is not defined
// console.log(person);

// To get something out, return it then you can log it or do something else
let returnedPerson = objects();
console.log('The returned person is ', returnedPerson);
console.log('The returned person is ', objects()); // This works the same way
console.log(`The returned person is ${returnedPerson}`);
console.log('The returned person is ' + returnedPerson);




/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are over written and the most recent one will be used.
*/

function add(num1, num2) {
  return num1 + num2;
}

function add(num1, num2, num3) {
  return num1 + num2 + num3;
}

// Need to pass all the values to get a number BUT JS will "Make things work" when you
//  - don't provide enough input parameters
//  - provide too many input parameters
let sum = add(2, 4, 6);
console.log(`Trying to add(num1, num2, num3) but with all 3 inputs: result is ${sum}`);

// There isn't a 3rd input, so it is undefined. It doesn't know how to add 1 + 2 + undefined
sum = add(1, 2); 
console.log(`Trying to add(num1, num2, num3) but with only 2 inputs: result is ${sum}`);

// Do too many it will ignore all the extras
sum = add(1, 2, 5, 6);
console.log(`Trying to add(num1, num2, num3) but with extra 4 inputs: result is ${sum}`);

sum = add( 1, 2, 'hello');
console.log(`Trying to add(num1, num2, num3) but with a string input: result is ${sum}`);

sum = add( 'hello', 1, 2);
console.log(`Trying to add(num1, num2, num3) but with a string input: result is ${sum}`);

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
