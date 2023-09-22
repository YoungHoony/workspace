const checkList = document.querySelectorAll(".check");
const input = document.querySelector(".input");
const result = document.querySelector("#result");
const count = document.querySelector("#btn");

count.addEventListener("click",() => {

    const checkOn = document.querySelectorAll(".check:checked");

    sum = 0;
    final = "";

    for(let checkOne of checkOn){

        const price = checkOne.value;
        const fruit = checkOne.nextElementSibling.innerText;
        const amount = checkOne.nextElementSibling.nextElementSibling.value;

        sum += price*amount;

        final += `${fruit} ${amount}개 `;
    }

    final += `총합 ${sum}원`;

    result.innerText = final;

});


