import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import LogoutButton from './components/LogoutButton';
import Greeting from './components/Greeting';
import FlightDetails from './components/FlightDetails';
import LoginButton from './components/LoginButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

 const handleLoginClick = () => {
    setIsLoggedIn(true);
  }
  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  }

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      <Greeting isLoggedIn={isLoggedIn} />
      {isLoggedIn ? 
        <LogoutButton onClick={handleLogoutClick} />
        : 
        <LoginButton onClick={handleLoginClick} />
        }
      
      <FlightDetails isLoggedIn={isLoggedIn}/>
    </div>
  );
}

export default App;
