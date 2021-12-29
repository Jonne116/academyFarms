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

export { getLocationsSensors };