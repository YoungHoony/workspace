import React, {useState} from 'react';

function Prac1() {

  const [test, setTest] = useState('가')

  const handler = () => {
   if(test === '가') setTest('나');
   else setTest('가'); 

  }

  return (
    <>
    
    
    <h1>test : {test} </h1>
    <button onClick={handler}>change </button>

    </>
    



  );
}

export default Prac1;