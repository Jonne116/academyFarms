import axios from 'axios';

const getLocationsSensors = async () => {
  try{
    const response = await axios.get('/api/farm/list');
    return response.data;
  }
  catch(err) {
    console.log(err);
    return [];
  }
};

const getFarmData = async (searchParameters) => {
  try {
    let queryString = '/api/farm';

    if (searchParameters) {
      queryString += '?';

      for (const parameter in searchParameters) {
       
        if (searchParameters[parameter].length !== 0) {
          const parameterString = `${parameter}=${searchParameters[parameter].toString()}&`;
          queryString += parameterString;
        }
      }
      const response = await axios.get(queryString);
      return response.data;
    }
    else {
      const response = await axios.get(queryString);
      return response.data;
    }
  }
  catch(err) {
    console.log(err);
    return [];
  }

};

export { getLocationsSensors, getFarmData };