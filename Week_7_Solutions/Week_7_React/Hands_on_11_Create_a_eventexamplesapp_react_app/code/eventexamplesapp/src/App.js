import { useState } from 'react';
import './App.css';
import CurrencyConvertor from './components/CurrencyConverter';

function App() {
  const [count, setCount] = useState(0);
  const increment = ()=>{
    setCount(count+1);
  }
  const decrement = ()=>{
    setCount(count-1);
  }
  const sayHello = ()=>{
    alert("Hello Member!! The value is incremented");
  }
    const sayWelcome = (message) => {
    alert(message);
  }

  const onPress = () => {
    alert("I was clicked");
  }
  return (
    <div >
      {count}
     <br /><button onClick={()=>{
      increment();
      sayHello();
     }}>increment</button><br/>
     <button onClick={decrement}>decrement</button><br/>
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button><br/>
      <button onClick={onPress}>Click on me</button>
     <CurrencyConvertor />
    </div>
  );
}

export default App;
