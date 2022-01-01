import React from 'react';
import DateTimeRangePicker from '@wojtekmaj/react-datetimerange-picker';
import PropTypes from 'prop-types';

const SearchFilter = ({
  dateObj, 
  setDateObj, 
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
    <>
      <h2> Filter: </h2>
      <div id='filterWrap'>
    
        <div>
          <h4>Locations</h4>
          {locations}
        </div>
        <div>
          <h4>Sensors</h4>
          {sensors}
        </div>
        <div className='dateTimeWrap'>
          <div>
            <h4>Date range</h4>
            <DateTimeRangePicker
              onChange={setDateObj}
              value={dateObj}
              disableClock={true}
              maxDetail="minute"
              clearIcon={null}
              calendarIcon={null}
            />
          </div>
        </div>
      </div>
    </>
  );
};

SearchFilter.propTypes = {
  locationsSensors: PropTypes.object.isRequired,
  dateObj: PropTypes.object,
  setDateObj: PropTypes.func.isRequired,
  setLocation: PropTypes.func.isRequired,
  setSensorType: PropTypes.func.isRequired
};

export default SearchFilter;