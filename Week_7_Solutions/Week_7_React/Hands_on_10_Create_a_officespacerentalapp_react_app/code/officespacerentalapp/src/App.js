import logo from './logo.svg';
import './App.css';
import dbs from "../src/images/DBS office.jpg";
import wework from "../src/images/We Work.jpg"
import regus from "../src/images/Regus.jpg"

function App() {
  const element = "Office Space";

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      img: dbs ,
    },
    {
      Name: "WeWork",
      Rent: 80000,
      Address: "Bangalore",
      img: wework,
    },
    {
      Name: "Regus",
      Rent: 45000,
      Address: "Hyderabad",
      img: regus,
    },
  ];

  return (
    <div style={{ padding: "20px" }} >
      <h1>{element} , at Affordable Range</h1>
<div className="container">
      {officeList.map((office, index) => {
        let colors = [];
        if (office.Rent <= 60000) {
          colors.push("textRed");
        } else {
          colors.push("textGreen");
        }
        let rentClass = colors[0];

        return (
          <div key={index} >
            <img
              src={office.img}
              width="100%"
              height="25%"
              alt="Office Space"
            />
            <h2>Name: {office.Name}</h2>
            <h3 className={rentClass}>Rent: Rs. {office.Rent}</h3>
            <h3>Address: {office.Address}</h3>
          </div>
        );
      })}
      </div>
    </div>
  );
}

export default App;
