/* 배열 생성 및 기초 사용 방법 */

document.querySelector("#btn1").addEventListener("click", () => {
    const arr1 = new Array();
    const arr2 = new Array(3);
    const arr3 = [];
    const arr4 = ["사과","바나나","복숭아"];

    console.log(arr1);  // [] length = 0
    console.log(arr2);  // (3) [빈 x3]
    console.log(arr3);  // []
    console.log(arr4);  // (3) ['사과','바나나','복숭아']

    /* JS 배열 기초 사용법 */

    // -- 배열에 요소를 추가하는 방법 --
    // * 요소를 지정된 인덱스에 추가할 수 있다!
    //   -> 중간에 인덱스를 건너 뛰면 건너 뛴 인덱스 부분에 비어있는 요소를 자동 추가 
    
    arr1[0] = "가나다";
    arr1[3] = 100; // 자료형 제한 X

    console.log(arr1);
});

/* 배열 함수 */
const btn2 = document.querySelector("#btn2");
btn2.addEventListener("click", () => {

    // 비어있는 배열 생성
    const arr = [];

    // push() : 마지막 요소로 추가
    arr.push("돌솥비빔밥");
    arr.push("라면");
    arr.push("샌드위치");
    arr.push("순대국밥");

    // unshift() : 첫번째 요소로 추가
    arr.unshift("스팸볶음밥");
    arr.unshift("햄버거");

    console.log(arr);

    // pop() : 마지막 요소 꺼내기
    let temp = arr.pop();
    console.log(arr);
    console.log(`꺼내진 요소 : ${temp}`);
    
    // shift() : 첫 번째 요소 꺼내기
    temp = arr.shift();
    console.log(arr);
    console.log(`꺼내진 요소 : ${temp}`);
    
    // sort() : 정렬(오름차순)
    console.log(arr);
    arr.sort();
    console.log(arr);

    /* sort() 사용 시 주의 사항  
      -> 문자열 순서대로 오름차순 정렬(숫자 크기 x)

      해결 방법 : 정렬 기준 함수를 매개변수로 추가
        (a,b) => a-b  (오름차순)
        (a,b) => b-a  (내림차순) // 화살표 함수 규칙에 의해서 {return}이 없어짐
    */
    const arr2 = [5,3,2,10,1];

    console.log(arr2.sort()); 
    // 예상 : 1, 2, 3, 5, 10
    // 결과 : 1, 10, 2, 3 , 5
    
    console.log(arr2.sort((a,b) => a-b)); // 오름 // 1,2,3,5,10
    console.log(arr2.sort((a,b) => b-a)); // 내림 // 10,5,3,2,1

    /* toString() : 배열 -> 문자열(구분자 ,) */
    console.log(arr.toString());

    /* join("구분자") : 배열 -> 문자열(지정된 구분자) */
    console.log(arr.join(" 또는 "));

});


function testFn(callback){
    return callback(10,20) + 30;

}

function sum(a,b) {
    return a+b;
}

/* 배열명.forEach() */
const forEachBtn = document.querySelector("#forEach-btn");
forEachBtn.addEventListener("click", () => {
    const arr = [10, 20, 30, 40, 50];

    // arr의 모든 요소의 값을 *2한 결과를 출력
    arr.forEach( (item, index) => {
        console.log(`${index} : ${item} * 2 = ${item * 2}`);
    } );
});

/* 배열명.map() */
const mapBtn = document.getElementById("map-btn");
mapBtn.addEventListener("click", () => {
    const arr = [10, 20, 30, 40, 50];

    const resultArr = arr.map(item => item*2);
    // const resultArr = arr.map((item) => {return item*2;});

    console.log(arr);
    console.log(resultArr);

});

/* for((item) of (배열명)) */
const forOfBtn = document.getElementById("for-of");
forOfBtn.addEventListener("click", () =>{

    // .test 모두 얻어오기
    const arr = document.querySelectorAll(".test");

    for(let li of arr) {
        console.log(li);
        li.innerText = "for of 테스트 중...";

    }

}); 




