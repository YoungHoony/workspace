import React from 'react';
// react 관련된 모든 것들을 가져와 쓰겠다라는 뜻. node_modules

//변수 형태로 function을 만든다. (JavaScript의 특징)

/* 컴포넌트 함수명, 변수명은 대문자로 시작 */
const PropsEx1 = (props) => {
  
  console.log(props);

  return(
    /* fragment(조각) : 감싸는 용도, 렌더링 시 사라짐 */
    /* 컴포넌트 함수는 하나의 요소만 리턴 가능! (태그 하나만 리턴 가능)
       여러개를 반환하고 싶으면 큰거 하나만 하면 된다
    */
    <> 
    {/* 부모 컴포넌트로부터 전달 받은 값(props)를 이용해서 자식 컴포넌트 만들기  */}
     <h3>번호 : {props.num} / 이름 : {props.name} </h3>

    
    
    </>
  );

};

// 외부에서 import 시 PropsEx1 함수(컴포넌트)를 기본값으로 내보냄
export default PropsEx1;
