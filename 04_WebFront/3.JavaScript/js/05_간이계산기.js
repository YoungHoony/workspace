
// 더하기 버튼
function plus() {
    // 입력요소.value : 입력 요소에 작성된 값 반환(string)
    // console.log(input1.value);
    // console.log(input2.value);
    
    // // // Number("123") == 123 (숫자로 변환)
    // console.log(Number(input1.value) + Number(input2.value));
    
    //입력 요소 값 두개 다 읽어오기
    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");
    
    // 두 값 더하기
    const result = Number(input1.value) + Number(input2.value) ;
    // result.innerText = Number(input1.value) + Number(input2.value);
    // 화면에 출력하기

    document.getElementById("result").innerText=result;
}

// 빼기 버튼
function minus() {

    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");

    const result = Number(input1.value) - Number(input2.value);

    document.getElementById("result").innerText=result;
}

// 곱하기 버튼
function multiply() {

    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");

    const result = Number(input1.value) * Number(input2.value);

    document.getElementById("result").innerText=result;
}

// 나누기 버튼
function divide() {
    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");

    const result = Number(input1.value) / Number(input2.value);

    document.getElementById("result").innerText=result;
}

// 나머지 버튼
function mod() {
    const input1 = document.getElementById("input1");
    const input2 = document.getElementById("input2");

    const result = Number(input1.value) % Number(input2.value);

    document.getElementById("result").innerText=result;

}