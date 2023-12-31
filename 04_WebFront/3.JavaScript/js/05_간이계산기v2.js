const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");

// 연산자 버튼 클릭 시 동작
// 매개 변수 op : +  - * / % 기호
function calc(op) {
    
    // 입력된 값을 number 타입으로 변환하여 저장
    v1 = Number(num1.value);
    v2 = Number(num2.value);

    let res; //  결과 저장

    // switch문을 이용해 op 매개 변수 값에 따라 결과 도출 
    switch(op) {
        case '+' : res = v1 + v2; break;
        case '-' : res = v1 - v2; break;
        case '*' : res = v1 * v2; break;
        case '/' : res = v1 / v2; break;
        case '%' : res = v1 % v2; break;
    }

    //결과 출력
    result.innerText = res;
    
}