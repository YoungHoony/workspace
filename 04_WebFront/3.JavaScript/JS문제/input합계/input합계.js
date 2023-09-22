const input1 = document.querySelector("#input1");
const btn1 = document.querySelector("#btn1");
const btn2 = document.querySelector("#btn2");
const result = document.querySelector("#result");
const input2 = document.querySelector("#input2");

btn1.addEventListener("click", () => {
    input2.innerHTML = '';

    for(let i=0; i <input1.value; i++) {
     input2.innerHTML += '<input type="number" class="list-input"> <br>';
    }
});

btn2.addEventListener("click", () => {
    const inputList = document.getElementsByClassName("list-input");

    let sum = 0;

    for(let i=0; i < inputList.length ; i++) {

        if(inputList[i].value == ""){
            alert("입력되지 않은 input이 있습니다. ")
        
        inputList[i].focus();
            return;
        }
        sum += Number(inputList[i].value);
    }

    result.innerText = sum;

});