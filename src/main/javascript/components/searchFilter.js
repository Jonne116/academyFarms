import React from 'react';
import DateTimePicker from 'react-datetime-picker';
import PropTypes from 'prop-types';

const SearchFilter = ({
  dateMax, 
  dateMin, 
  setDateMax, 
  setDateMin, 
  locationsSensors,
  setSensorType,
  setLocation
}) => {

  const handleChange = () => {
    let locationArray = [];
    let sensorArray = [];
    document.querySelectorAll('.location:checked')
      .forEach(value => {
        locationArray.push(value.value);
      });
    document.querySelectorAll('.sensorType:checked')
      .forEach(value => {
        sensorArray.push(value.value);
      });
  
    setSensorType(sensorArray);
    setLocation(locationArray);
  };

  const locations = locationsSensors.location?.map(location => {
    return(
      <div key={location}>
        <input type="checkbox" id={location} onChange={handleChange} className='location' value={location} />
        <label htmlFor={location}> {location}</label><br></br>
      </div>
    );
  });

  const sensors = locationsSensors.sensorType?.map(sensor => {
    return(
      <div key={sensor}>
        <input type="checkbox" id={sensor} onChange={handleChange} className='sensorType' value={sensor} />
        <label htmlFor={sensor}> {sensor}</label><br></br>
      </div>
    );
  });
 
  return(
    <div>
      <div>
        <h4>Locations</h4>
        {locations}
        <h4>Sensors</h4>
        {sensors}
      </div>
      <h4>Start date</h4>
      <DateTimePicker
        onChange={setDateMin}
        value={dateMin}
        disableClock={true}
        maxDetail="hour"
        clearIcon={null}
        className="datePick"
      />
      <h4>End date</h4>
      <DateTimePicker
        onChange={setDateMax}
        value={dateMax}
        disableClock={true}
        maxDetail="second"
        clearIcon={null}
        className="datePick"
      />
    </div>
  );
};

SearchFilter.propTypes = {
  locationsSensors: PropTypes.object.isRequired,
  dateMax: PropTypes.string.isRequired,
  dateMin: PropTypes.string.isRequired,
  setDateMax: PropTypes.func.isRequired,
  setDateMin: PropTypes.func.isRequired,
  setLocation: PropTypes.func.isRequired,
  setSensorType: PropTypes.func.isRequired
};

export default SearchFilter;