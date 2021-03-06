/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

 function isAdmitted(gpa,satScore,recommendation){
     if(gpa > 4.0 || satScore > 1300 || (gpa > 3.0 && recommendation == true) || (satScore > 1200 && recommendation == true)){
         return true;
     }
     else return false;
     }

/**
 * Write a function called useParameterToFilterArray that takes an anonymous
 * function and uses that in the `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];

function useParameterToFilterArray(filterFunction){
    return unfilteredArray.filter(filterFunction);
}

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

 function makeNumber(first,second){
     number = first + second;
     return parseInt(number);
 }

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

 function addAll(num){
     result = 0;
     for(let i = 0; i<arguments.length; i++){
            result += arguments[i];
     }
     return result;

 }

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
/**
 * @param {string[]} words
 */
 function makeHappy(words){
        return words.map((word) => {return "Happy " + word;});
         }

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
/**
 * 
 * @param {string[]} array will turn into js objects
 */
function getFullAddressesOfProperties(array){
    return array.map((item) => {
         return  item.streetNumber + " " + item.streetName + " " + item.streetType + " " + item.city + " " + item.state + " " + item.zip ;
    } );
}

/*
 * Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 */
/**
 * 
 * @param {number[]} input to find the largest element
 */
function findLargest(input) {
    let largest = input[0];
  
     input.forEach(element => {
       if (largest < element) {
         largest = element;
       }
     });
  
     return largest;
   }

/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */

/**
 * Takes an array of arrays, adds up all sub values, and returns
 * the sum.
 * 
 * @param {number[]} arrays 
 * @return {number} returns the sum
 */
function getSumOfSubArrayValues(arrays = 0) {
    let sum = 0;
    if (arrays != 0) {
        return arrays.reduce((acc, current) => {
            return (acc += current.reduce((prev, next) => {
                return prev += next;
            }, 0));
        }, 0);
    }
    return sum;
}
