import React, { useState, useEffect } from 'react';
import { getFarmData, getLocationsSensors } from './services/apiService';
import SearchFilter from './components/searchFilter';
import DataView from './components/dataView';

const App = () => {
  const [locationsSensors, setLocationsSensors] = useState({});
  const [dateMin,setDateMin] = useState('2019-01-01T22:00:00Z');
  const [dateMax,setDateMax] = useState('2019-01-10T22:00:00Z');
  const [location, setLocation] = useState([]);
  const [sensorType, setSensorType] = useState([]);
  const [farmData, setFarmData] = useState([]);
  
  useEffect( async ()=>{
    setLocationsSensors(await getLocationsSensors());
    setFarmData(await getFarmData({dateMax, dateMin, location, sensorType}));
    
  }, [dateMax, dateMin, setLocationsSensors, setFarmData, location, sensorType]);

  return(
    <div >
      <SearchFilter setDateMax={setDateMax} 
        dateMax={dateMax}
        setDateMin={setDateMin} 
        dateMin={dateMin}
        locationsSensors= {locationsSensors}
        setLocation={setLocation}
        setSensorType={setSensorType}/>
      <DataView farmData={farmData}/>
    </div>
  );

};

export default App;