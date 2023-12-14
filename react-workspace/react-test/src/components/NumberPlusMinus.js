import React, { useState } from 'react';

function NumberPlusMinus() {
  const [count, setCount] = useState(0);

  const minusHandler = () => {
    setCount(() => count-1);

  }

  const plusHandler = () => {
    setCount( () => count+1);
  }

  return (
    <div>
      <button className="minusBtn" onClick={minusHandler}>-</button>
      {count}
      <button className="plusBtn" onClick={plusHandler}>+</button>
    </div>


  );

}

export default NumberPlusMinus;