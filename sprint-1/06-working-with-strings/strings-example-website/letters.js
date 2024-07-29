
// document.addEventListener('DOMContentLoaded', function() {
//     let sentences = document.querySelectorAll('.split-letters ');
//     sentences.forEach((sentence) => {
//         let letters = sentence.innerText.split("");
//         let newContent = '';
//         letters.forEach((letter) => {
//             newContent += `<div class="new-character">${letter}</div>`;
//         });
//         sentence.innerHTML = newContent;
//     });
// });

function splitText(value)
{
    const newContent = document.getElementById('new-content');

    let letters = value.split("");
    let newText = '';
    let highlighted = "";

    letters.forEach((letter) => {
        if (letter === '*') {
            highlighted = " highlighted";
        }
        else{
            newText += `<div class="new-character ${highlighted}">${letter}</div>`;
            highlighted = "";
        }
    });

    newContent.innerHTML = newText;
}