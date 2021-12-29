import React, { useState, useEffect } from 'react';
import { getLocationsSensors } from './services/apiService';
import SearchFilter from './components/searchFilter';

const App = () => {
  const [locationsSensors, setLocationsSensors] = useState({});
  const [dateMin,setDateMin] = useState();
  const [dateMax,setDateMax] = useState();

  const searchParameters = {dateMin: dateMin, dateMax: dateMax};
  const setSearchParameters = {setDateMin: setDateMin, setDateMax: setDateMax};
  
  useEffect( async ()=>{
    setLocationsSensors(await getLocationsSensors());
  }, [searchParameters, setLocationsSensors]);

  return(
    <div >
      <SearchFilter setSearchParameters={setSearchParameters} 
        searchParameters={searchParameters}
        locationsSensors= {locationsSensors}/>
    </div>
  );

};

export default App;