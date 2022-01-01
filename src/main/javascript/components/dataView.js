import React from 'react';
import PropTypes from 'prop-types';


const DataView = ({farmData}) => {
 
  return(
    <div>
      <table>
        <thead>
          <tr>
            <th>Location</th>
            <th>Time</th>
            <th>Sensor</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          {farmData.map(element => {
            return (
              <tr key={element.id}>
                <td>{element.location}</td>
                <td>{new Date(element.dateTime).toLocaleString()}</td>
                <td>{element.sensorType}</td>
                <td>{element.value}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

DataView.propTypes = {
  farmData: PropTypes.array.isRequired
};

export default DataView;