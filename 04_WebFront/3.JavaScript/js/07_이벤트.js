/* 인라인 이벤트 모델*/
function inlineEventModel(btn) {
    console.log(btn); // 클릭 이벤트가 발생한 요소(버튼)

    console.log(btn.style.backgroundColor); //클릭한 요소의 배경색 얻어오기

    if(btn.style.backgroundColor != "pink") {
    btn.style.backgroundColor ="pink"; //클릭한 요소의 배경색으로 pink 추가
    
    } else {
        // Attribute : 속성
        btn.removeAttribute("style"); // style 속성 제거
    }
}

/* 고전 이벤트 모델 */

// 아이디가 test2-1인 요소를 선택해 변수에 저장
const a = document.getElementById("test2-1");

// 요소.이벤트리스너 = 이벤트 핸들러 
a.onclick = function(){ 
    // function(){} : 익명 함수(이벤트 핸들러로 많이 사용)
    alert("test2-1 클릭")
}

// 이벤트 제거
// #test2-2 클릭 시 #test2-1의 클릭 이벤트 제거
const b = document.querySelector("#test2-2");

b.onclick = function() {
    // a == #test2-1

    // #test2-1의 onclick 속성에 null을 대입해서 덮어쓰기
    a.onclick = null; 
    alert("#test2-1 이벤트 제거")
}

// 고전 이벤트 이벤트 모델 단점
// -> 한 요소의 같은 이벤트 리스너에 여러 이벤트 핸들러를 대입할 수 없다. 
// 여러개를 적어도 마지막 한개만 적용된다. 

const c = document.querySelector("#test2-3");

// #test2-3 클릭 시 버튼의 배경색을 yellow로 변경 
c.onclick = function(){
    c.style.backgroundColor = "yellow";
}


// #test2-3 클릭 시 버튼의 글자 크기를 30px로 변경 
c.onclick = function() {
    c.style.fontSize = '30px';
}


// ----------------------------------------------------------------

/* ***** 표준 이벤트 모델 ***** */

/* [작성법]
    요소.addEventListener("click", function(){}); 
                         이벤트명   이벤트 핸들러
*/
                         
// 아이디가 test3인 요소에 click 했을 때에 대한 동작을 추가
document.getElementById("test3").addEventListener("click", function(){

    //클릭된 요소의 너비가 10px 증가

    // 고전/표준 이벤트 핸들러 내부에서 this : 이벤트가 발생한 요소를 나타냄. 
    console.log(this);
    
    // 요소.clientWidth : 요소의 너비(테두리 제외)
    // -> css/style 속성으로 지정된 너비를 얻어올 때 사용을 한다. 
    console.log(this.clientWidth);

    // this는 getter용으로 사용하는 것이기 때문에, 얻어오는 것이다. 
    // this.clientWidth = '300px';

    // 요소.style.width : 요소의 style 속성 중 width 값을 얻어옴 
    // -> 요소 자체에 작성된 style 속성의 값을 얻어올 때 사용. 
    //console.log(this.style.width);

    this.style.width = '300px'; // 현재 요소 너비 변경 
    this.style.width  = this.clientWidth + 10 + 'px';

})

// #test3 요소에 click 이벤트 리스너를 또 추가 
document.getElementById("test3").addEventListener("click", function(e) {

    // 이벤트 핸들러 매겨 변수 e 또는 event 
    // -> 이벤트 객체(이벤트 관련 정보가 담긴 객체)가 전달됨. 

    // e.target : 이벤트가 발생한 요소

    console.log(e);
    console.log(e.target);

    // 현재 요소의 높이를 변경 
    e.target.style.height = e.target.clientHeight + 10 + 'px'

})


// 입력한 색상으로 배경색 변경(표준 이벤트 모델)
const btn4 = document.getElementById('btn4');
const box4 = document.getElementById('box4');
const input4 = document.getElementById('input4');

btn4.addEventListener("click", function() {
    box4.style.backgroundColor= input4.value ;
})

// input 태그에서 엔터 입력 시 배경색 변경
input4.addEventListener("keyup", function(e) {
    // e : 이벤트 객체 
    // e.key : 입력한 키 (키 관련 이벤트 객체만 확인 가능)
    // e.target : 이벤트가 발생한 요소 (여기서는 #input4)
    // console.log(e.key);
    if(e.key == "Enter") { 
        box4.style.backgroundColor = e.target.value;
    }
});


/* a태그 기본 이벤트 제거 */
document.getElementById('move').addEventListener("click", function(e){ 
    
    // e : 이벤트 객체
    // prevent : 하지 못하게 막다
    // default : 기본

    e.preventDefault(); // HTML 요소의 기본 이벤트 막음(제거)
})

/* form 태그 기본 이벤트 제거 */

// ****(많이 쓰임)방법 1. e.preventDefault()
// form태그가 제출 되었을 때
document.getElementById("login").addEventListener("submit", function(e) {

    // alert("제출 되었습니다.");

    e.preventDefault();
});

// 방법 2. 인라인 이벤트 모델 onsubmit 이용
function testFn(){
    const id = document.getElementById("input-id");
    const pw = document.getElementById("input-pw");

    //아이디 또는 비밀번호를 입력하지 않았을 때
    if(id.value.trim().length == 0 || pw.value.trim().length ==0) {
     return false;
    }

    // 둘 다 입력한 경우
    return true;
  
};

// ****(많이 쓰임)방법 3. 일반 버튼 클릭으로 제출을 막음. 
// #login-btn2 버튼이 클릭 되었을 때
const loginBtn2 = document.querySelector("#login-btn2");
loginBtn2.addEventListener("click", function(){

    const id = document.getElementById("input-id");
    const pw = document.getElementById("input-pw");

    //아이디, 비밀번호를 둘다 입력했을 때
    if(id.value.trim().length != 0 && pw.value.trim().length != 0) {
     
        /* document.form태그name속성 == 해당 form 요소 선택 (다른 div.. 바로 작성이 안된다) */
        /* form요소.submit() : form 제출 */
        // 문서 내에서 name 속성 값이 loginForm인 form 태그를 제출 시킴
        document.loginForm.submit();
    }

});

const btn = document.getElementById("create-btn");
const input = document.getElementById("count-input");
const ul = document.getElementById("list");
const calc = document.getElementById("calc");
const result = document.getElementById("calc-result");
const avgResult = document.getElementById("calc-avg");


btn.addEventListener("click", function(){
    //input.value;

    if(input.value <= 0 || input.value > 10) {
        alert("1~10 숫자를 입력 해주세요.");
        return;
    }

    // list 내부 요소 삭제
    ul.innerHTML = '';

        for(let i=0; i <input.value; i++) {
         ul.innerHTML += '<li> <input type="number" class="list-input"> </li>'; 
    }

});

input.addEventListener("keyup", function(e) {

    if(e.key == "Enter") { 
        if(input.value <= 0 || input.value > 10) {
            alert("1~10 숫자를 입력 해주세요.");
            return;
        }
    
        // list 내부 요소 삭제
        ul.innerHTML = '';
    
            for(let i=0; i <input.value; i++) {
             ul.innerHTML += '<li> <input type="number" class="list-input"> </li>'; 
        }
    
    }
});


// 계산 하기 버튼 클릭 시
calc.addEventListener("click",function() {

    //계산하기 버튼 클릭 시점에
    // 문서에 존재하는 .list-input을 모두 읽어와 배열로 반환
    const inputList = document.getElementsByClassName("list-input");
    //console.log(inputList);
    
    let sum = 0;
    let avg = 0;

    for(let i=0; i < inputList.length; i++) {
        // inputList[i] : 각각의 input 요소
        // inputList[i].value : 각각의 input 요소에 작성된 값 얻어오기
        // -> input에서 얻어온 값은 기본적으로 string

        // -> 아무 값도 입력되지 않으면 빈칸("". '')
        //console.log(inputList[i].value == "");

        // 아무것도 입력되지 않은 input이 있으면
        if(inputList[i].value == ""){
            alert("입력되지 않은 input이 있습니다."); 

        // 입력되지 않은 input으로 초점 이동
        inputList[i].focus();
            return; // 함수(이벤트 핸들러) 종료
        }

        sum += Number(inputList[i].value); // 숫자로 변환해서 누적
        avg = sum/(inputList.length);
    }
    //console.log(sum);

    // #calc-result 요소의 내용으로 합계(sum) 대입(출력)
    result.innerText = sum;
    avgResult.innerText = avg;

});

const keys = document.getElementsByClassName("key");

// 문서 내에서 키다운 이벤트가 발생했을 때
document.addEventListener("keydown", function(e){
  let index = 0;

  // e.key : 입력한 키
  // 문자열.toLowerCase() : 소문자로
  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  default: return;
  }

  keys[index].style.backgroundColor = "skyblue";
})

document.addEventListener("keyup", function(e){

  let index = 0;

  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  }

  keys[index].style.backgroundColor = "white";
})







