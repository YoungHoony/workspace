/*  문자열 관련 함수 */

document.getElementById("btn1").addEventListener("click", () => {

    /* 문자열.indexof(찾을문자열) */
    const str1 = "Hello World 입니다";

    console.log(str1.indexOf("World"));
    console.log(str1.indexOf("입니다"));
    console.log(str1.indexOf("배고파"));

    /* 문자열.substring(시작, 종료(미포함)) */
    const str2 = "Javascript 하는 중..."

    console.log(str2.substring(0,4)); // "Java"
    console.log(str2.substring(4,10)); // "script만"

    //문자열.length : 문자열 길이
    // console.log("script".length);
    const start = str2.indexOf("script"); //시작 인덱스
    const end = start + "script".length; // 종료 인덱스(미포함)
    console.log(str2.substring(start,end));

    /* 문자열.split("구분자") */
    const str3 = "중고거래 / 쇼핑몰 / SNS / 블로그 / 웹게임";
    const arr = str3.split(" / ");

    for(let i=0; i<arr.length ;i++){
        console.log(arr[i]);
    }

});

/* 숫자 관련 리터럴/함수 */
document.querySelector("#btn2").addEventListener("click", (e) =>{

    // Infinity 확인
    console.log("5 / 0 = " + (5/0));

    // NaN(Not a Number)
    console.log("aaa" * 100);

    // 연산 결과가 NaN인 경우 alert("계산 불가") 출력
    // -> isNaN(값)을 사용해야 한다!
    //  -> 값이 NaN이면 true 반환
    if(isNaN("aaa" * 100)){
        alert("계산 불가");
    }

    /* toFixed() 확인 */
    console.log((3.45).toFixed(1)); // 3.5 (소수첫째짜리까지 나타내기 == 둘째자리에서 반올림)


    /* Math.random() 확인 */
    // 버튼의 배경색을 랜덤하게 변경(rgb, 0~255)

    const red = Math.floor(Math.random() * 256);
    const green = Math.floor(Math.random() * 256);
    const blue = Math.floor(Math.random() * 256);

    /* ***** 백틱(``)을 이용한 문자열 생성 방법 ***** */
    e.target.style.backgroundColor = `rgb(${red},${green},${blue})`;

    console.log('rgb(${red},${green},${blue})');

});

document.querySelector("#btn3").addEventListener("click", () => {
   
    // typeof 값 : 값의 자료형을 반환
    const num ="1.234";

    console.log(`${num}의 자료형 : ${typeof num}`); // string
    
    console.log(`${Number(num)}의 자료형 : ${typeof Number(num)}`); // number
    
    console.log(`${parseFloat(num)}의 자료형 : ${typeof parseFloat(num)}`); // number
    
    console.log(`${parseInt(num)}의 자료형 : ${typeof parseInt(num)}`); //number
});

document.querySelector("#btn4").addEventListener("click", () =>{
    /* 동등 */
    console.log(`1 == "1" -> ${1 == "1"}`); // true
    console.log(`1 == true -> ${1 == true}`); // true
    /* 동일 */
    console.log(`1 === "1" -> ${1 === "1"}`); // false (자료형이 다르니까)
    console.log(`1 === true -> ${1 === true}`); // false (자료형이 다르니까)
    
    console.log(`1 === 1 -> ${1 === 1}`); // true

});










