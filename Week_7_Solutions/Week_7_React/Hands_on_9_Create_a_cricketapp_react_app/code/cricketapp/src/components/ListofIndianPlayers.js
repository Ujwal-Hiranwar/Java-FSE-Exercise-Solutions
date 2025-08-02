import React from 'react';


const ListofIndianPlayers = ({IndianPlayers}) => {
  return (
    <div>
      <ul>
        {IndianPlayers.map((player) => (
          <li>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofIndianPlayers;
