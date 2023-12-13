import React, { useState, createContext, useContext} from 'react';

/* 1. Context 객체 생성 */
const TestContext = createContext();

/* 4. 손주 (2단계 하위) 컴포넌트 */
const GrandChild = () => {
  // {"number" : number, "setNumber" : setNumber} 
  const {number, setNumber} = useContext(TestContext);

  return(
    <>
      <h3>GrandChild Component</h3>

      <input type='number' onChange={ (e) => { setNumber(e.target.value) } } value={number}
      
      />
    </>

  );

};

/* 3. 자식 (1단계 하위) 컴포넌트 */
const Child = () => {
  return (

    <>
      <h2>Child Component</h2>
      <GrandChild/>
    </>
  )

};

/*  2. 부모 컴포넌트 */
const Parent = () => {

  // 상태 변수 선언
  const [number, setNumber] = useState(0);


  return(
    /*  Context에 추가해서 하위 컴포넌트에게 제공 */
    /* 자바스크립트는 객체나 배열로만 묶을수 있다.  */
    // {"number" : number, "setNumber" : setNumber} 
    // 자바스크립트에서만 이렇게 만들어줌. 자바에선 안됨
    <TestContext.Provider value={ {number, setNumber} }>
      <h1>Parent Component</h1>

      <h1>
        GrandChild에서 전달된 값 
        <span className='color-red'>{number}</span>
      </h1>

      <Child/>


    </TestContext.Provider>
  );



};

export default Parent;

