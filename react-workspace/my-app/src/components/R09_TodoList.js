import React, { useState } from 'react';

/* -----useState 복습----- */

/* 함수형 컴포넌트 */
const InputName = () => {
  
  // 상태(State) : 컴포넌트의 변수
  // -> 변수 값이 변하면 컴포넌트가 reRendering (화면에서 지워졌다가 다시 만들어짐)
  // name : 상태 변수명

  // setName() : 함수, name 상태 변수 값을 변경하는 setter
  // useState('') : name을 상태 변수 지정 + 초기값('') 
  const [name, setName] = useState('');

  return(
    /* jsx(JavaScript XML) : JS 내부에서 HTML같은 마크업 언어 작성하는 문법 (태그로 기록하는 파일: 마크업) */
    <div>
      <p>이름을 입력하세요</p>
      
      <input type='text' onChange={(e) => { setName(e.target.value)}} />
      
      {/* reRendering이 되는 부분 */}
      <h3>{name}</h3>

    </div>
  );

}

/* 함수형 컴포넌트 */
const TodoList = () => {

  /* TodoList (할일 목록) 만들기 */

  /* 할 일 목록을 저장할 객체 배열을 상태 변수 선언 */

  const [todos, setTodos] = useState([
    {text : '프로젝트', completed : false},
    {text : '점심 먹기', completed : false},
    {text : '출석하기', completed : true} // 성공 : true
  ]);

  /* 채크박스 체크 변경 시 수행할 함수(이벤트 핸들러) */
  const todoChange = (index) => {
    // todos[index].completed = true;
    // 동작은 하는데 화면이 변하지 않음
    // todos 깊은 복사 후, 지정된 index의 completed 값을 변경 
    // -> setTodos(복사한 객체 배열) -> 컴포넌트 리랜더링
    
    // ... (나열/전개 연산자) : 배열 또는 객체의 가장 바깥쪽 괄호를 푸는 것 
    const newTodos = [...todos]; // 깊은 복사

    // 지정된 index의 completed 값을 변경

    newTodos[index].completed = !newTodos[index].completed;

    setTodos(newTodos);


  };


  /* todos에 새로운 할 일 추가 */
  const InputTodo = () => {

    const [inputText, setInputText] = useState('');

    /* 추가하기 버튼 클릭 시 todos에 할 일 추가하는 함수(이벤트 핸들러) */
    const addTodo = () => {

      // todos 배열 요소와 같은 모양의 객체 준비
      const todo = {text : inputText, completed : false};

      // 깊은 복사 + todo 추가
      const newTodos = [...todos, todo];

      // 상태 변수 변경 -> 리랜더링 
      setTodos(newTodos);
      setInputText(''); // 이전 입력한 할 일 지우기 

    }

    return ( 
      <div>
        <h4>할 일 추가</h4>
        
        <input type='text' onChange={ (e) => {setInputText(e.target.value)} }/>
        
        <button onClick={ addTodo }>추가하기</button>
      </div>

    );
  }


  return (
    <> 
    {/* <> 감싸는 용도, 해석은 안됨 */}
      <h2>State 복습</h2>
      <InputName/>
      <hr/>

      {/* 할일 추가 */}
      <InputTodo/>

      {/* 할일 목록 */}
      
      {/* 기존 배열.map( (배열요소, 인덱스)=>{return 값;} ) 
      
        - 기존 배열의 요소를 순차 접근(향상된 for문)
          -> 매개변수 중 배열 요소에 기존 배열의 요소가 하나씩 대입

        - return 되는 값들을 모아서 새로운 배열을 반환   
      */}
      <ul>
        {todos.map( (item, index) => { return(
          <li>
            <input type='checkbox' 
                   checked={item.completed}
                   onChange={ () => { todoChange(index) } } />
            {/* <span className={ 조건식 ? 참:거짓}>{item.text}</span> */}
            <span className={ item.completed ? 'completed': ''}>{item.text}</span>
          </li>
        );} )}


      </ul>

      

    </>
  );
}

export default TodoList;
