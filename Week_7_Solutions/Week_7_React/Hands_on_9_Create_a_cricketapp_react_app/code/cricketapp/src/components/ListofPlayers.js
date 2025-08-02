import React from 'react';
const ListofPlayers = ({players}) => {

  return (
    <div>
      <ul>
        {players.map((item) => (
          <li>
            Mr. {item.name} <span> {item.score}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
