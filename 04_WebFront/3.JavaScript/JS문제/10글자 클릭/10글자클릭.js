const inputList = document.querySelectorAll(".num1");
const result = document.querySelector("#result");
const reset = document.querySelector("#reset");

for(let input of inputList){
    input.addEventListener("click", e=>{
        // console.log(e.target.innerText);
        
        if(result.innerText.length >= 10) {
            alert("10자까지만 입력하세요.");
            return;
        }

        result.innerText += e.target.innerText;

    })
}

reset.addEventListener("click", () =>{
    result.innerText ="";

});

