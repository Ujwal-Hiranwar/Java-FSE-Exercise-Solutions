import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const numericAmount = parseFloat(amount);
    

    if (currency.toLowerCase() === 'rupee') {
      const result = numericAmount / 80;
      alert(`Converting Rupee to Euro. Amount is ${result.toFixed(2)}`);
    } else if (currency.toLowerCase() === 'euro') {
      const result = numericAmount * 80;
      alert(`Converting Euro to Rupee. Amount is ${result.toFixed(2)}`);
    } else {
      alert("Unsupported currency! Please enter 'rupee' or 'euro'");
    }
  };

  return (
    <div className='container'>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <div >
          <label>Amount: </label>
          <input 
          type="number"
          value={amount}
          onChange={((e)=>{
            setAmount(e.target.value);
          })} />

        </div>
        <div>
          <label>Currency: </label>
          <textarea
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default CurrencyConvertor;
