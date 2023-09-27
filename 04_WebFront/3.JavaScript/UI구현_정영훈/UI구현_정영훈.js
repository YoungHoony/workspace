
const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwRe = document.getElementById("input-pwRe");



/* 아이디 작성 */

inputId.addEventListener("input", e=> {
    const idVal = inputId.value.trim();
    const span = e.target.nextElementSibling.nextElementSibling;
  
    inputId.value = idVal;

    if(idVal.length === 0) {
        span.innerText = "필수 입력 항목입니다.";
        span.classList.remove("check");
        span.classList.remove("error");

    } else {
        span.classList.add("check"); 
        span.classList.remove("error");
    }

});




/* 비밀번호 작성 */
inputPw.addEventListener("input" , e => {
    const val = inputPw.value.trim();
    const span = e.target.nextElementSibling.nextElementSibling;

    const val2 = inputId.nextElementSibling.nextElementSibling;
    const span2 = e.target.previousElementSibling.previousElementSibling;


    e.target.value = val;

    if(val.length === 0) {
     span.innerText = "필수 입력 항목 입니다";
     span.classList.remove("check");
     span.classList.remove("error");

    }

    if(!val2.classList.contains("check")) {
        span2.innerText = "필수 입력입니다";
        span2.classList.add("error");
        span2.classList.remove("check");
}});


inputPw.addEventListener("click", e => {

   
    const span = e.target.nextElementSibling.nextElementSibling;
     const val2 = inputId.nextElementSibling.nextSibling;
    const span2 = inputId.nextElementSibling;

    span.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8~32자를 입력하세요"
  

    if(!val2.classList.contains("check")){
        span2.innerText = "필수 입력 항목입니다.";
        span2.classList.add("error");
        span2.classList.remove("check");
    }


});



/* 비밀번호 확인 */
inputPwRe.addEventListener("input", e => {
    const pwSpan = inputPw.nextElementSibling.nextElementSibling;
    const span = e.target.previousElementSibling.previousElementSibling;
    const span2 = e.target.nextElementSibling.nextElementSibling;


    if(!pwSpan.classList.contains("check")) {
    span.innerText = "필수 입력입니다.";
    span.classList.add("error");
    span.classList.remove("check");

    const val = e.target.value.trim();
    e.target.value = val;

    if(val.length === 0) { 
        span2.innerText = "필수 입력입니다.";
        span2.classList.remove("check");
        span2.classList.remove("error");

    }
}

});









