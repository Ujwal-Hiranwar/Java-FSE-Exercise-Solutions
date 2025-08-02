import './App.css';
import ListofPlayers from './components/ListofPlayers';
import ScoreBelow70 from './components/ScoreBelow70';
import { OddPlayers } from './components/OddPlayers';
import { EvenPlayers } from './components/EvenPlayers';
import ListofIndianPlayers from './components/ListofIndianPlayers';

function App() {
  var flag=false;
  const players = [
  { name: "Virat Kohli", score: 82 },{ name: "Steve Smith", score: 68 },
  { name: "Rohit Sharma", score: 54 },{ name: "Kane Williamson", score: 72 },
  { name: "Ben Stokes", score: 61 },{ name: "Shubman Gill", score: 49 },
  { name: "Babar Azam", score: 71 },{ name: "Hardik Pandya", score: 40 },
  { name: "David Warner", score: 58 },{ name: "Ravindra Jadeja", score: 30 },
  { name: "Jos Buttler", score: 75 }
];
const IndianTeam = ["Virat Kohli", "Rohit Sharma", "Shubman Gill", "KL Rahul", "Hardik Pandya", "Ravindra Jadeja"];
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

if(flag===true){
return (
    <div className="App">
      <h1 >List of Players</h1>
      <ListofPlayers players={players} />
      <hr />
      <h1 >List of Players having Scores less than 70</h1>
      <ScoreBelow70 players={players} />
    </div>
  );
}
else{
  return (
    <div className="App">
      <h1 >Odd Players</h1>
       {OddPlayers(IndianTeam)}
      <hr />
      <h1>Even Players</h1>
      {EvenPlayers(IndianTeam)}
      <hr />
      <h1>List of Indian Players Merged:</h1>
      <ListofIndianPlayers IndianPlayers={IndianPlayers} />
      
    </div>
  );
}
  
}

export default App;
