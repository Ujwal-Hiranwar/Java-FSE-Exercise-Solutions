import React from 'react';

const Scorebelow70 = ({players}) => {
  const players70 = [];

  players.map((item) => {
    if (item.score <= 70) {
      players70.push(item);
    }
    return null; 
  });

  return (
    <div>
      <ul>
        {players70.map((player) => (
          <li>
            Mr. {player.name} <span>{player.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Scorebelow70;
