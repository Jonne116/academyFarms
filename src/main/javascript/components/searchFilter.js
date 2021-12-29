import React from 'react';
import DateTimePicker from 'react-datetime-picker';
import PropTypes from 'prop-types';

const SearchFilter = ({searchParameters, setSearchParameters, locationsSensors}) => {

  

  const locations = locationsSensors.location?.map(location => {
    return (
    <div key={location}>
      <input type="checkbox" id={location} name={location} value={location} />
      <label htmlFor={location}> {location}</label><br></br>
    </div>
    )
  });

  const sensors = locationsSensors.sensorType?.map(sensor => {
    return (
    <div key={sensor}>
      <input type="checkbox" id={sensor} name={sensor} value={sensor} />
      <label htmlFor={sensor}> {sensor}</label><br></br>
    </div>
    )
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
        onChange={setSearchParameters.setDateMin}
        value={searchParameters.dateMin}
        disableClock={true}
        maxDetail="hour"
        clearIcon={null}
        className="datePick"
      />
      <h4>End date</h4>
      <DateTimePicker
        onChange={setSearchParameters.setDateMax}
        value={searchParameters.dateMax}
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
  searchParameters: PropTypes.object.isRequired,
  setSearchParameters: PropTypes.object.isRequired,
};

export default SearchFilter;