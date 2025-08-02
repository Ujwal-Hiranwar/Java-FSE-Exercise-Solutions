import React from 'react'
function FlightDetails(props) {
    const flightdata = [
        {id : 1, route : 'Delhi to Mumbai', time : '10:00 AM'},
        {id : 2, route : 'Pune to Bangalore', time : '1:00 PM'},
        {id : 3, route : 'Kolkata to Chennai', time : '4:00 PM'}
    ]
        
    
  return (
    <div>
      <h3>Flight Details</h3>
      <ul>

        {flightdata.map((flight) => (
          <li key={flight.id} >
            <span className='flight'>
            Flight {flight.id}: {flight.route} - {flight.time}
            </span>
            {props.isLoggedIn && <button onClick={() => alert('Ticket Booked Successfully')}>Book Now</button>}
          </li>
        ))}
        
      </ul>
    </div>
  );
}

export default FlightDetails;
