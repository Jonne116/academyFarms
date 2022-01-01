import React, { useState, useEffect } from 'react';
import { getFarmData, getLocationsSensors } from './services/apiService';
import SearchFilter from './components/searchFilter';
import DataView from './components/dataView';
import Background from './components/backgroud';

const App = () => {
  const [locationsSensors, setLocationsSensors] = useState({});
  const [dateObj,setDateObj] = useState([new Date('2018-12-31T22:00:00.000Z'),
    new Date('2019-01-01T22:00:00.000Z')]);
  const [location, setLocation] = useState([]);
  const [sensorType, setSensorType] = useState([]);
  const [farmData, setFarmData] = useState([]);
  
  useEffect( async ()=>{
    setLocationsSensors(await getLocationsSensors());
    const dateMax = new Date(dateObj[1]).toISOString();
    const dateMin = new Date(dateObj[0]).toISOString();
    setFarmData(await getFarmData({dateMax, dateMin, location, sensorType}));
    
  }, [dateObj, setLocationsSensors, setFarmData, location, sensorType]);

  return(    
    <div className='appWrap'>
      <Background />
      <div className='dataText'>
        <h1>Solita dev academy 2022</h1>
        <h4>-Farm data exercise-</h4>
        <div>
          <SearchFilter 
            setDateObj={setDateObj} 
            dateObj={dateObj}
            locationsSensors= {locationsSensors}
            setLocation={setLocation}
            setSensorType={setSensorType}/>
        </div>
        <DataView farmData={farmData} />
        
      </div>
      
    </div>
  );

};

export default App;