import { render, screen } from '@testing-library/react';
import React from 'react'
import SearchFilter from '../searchFilter';

it('Component should mount ', () => {
  render(<SearchFilter 
    locationsSensors={{
      location:["New York"], 
      sensorType: ["Humidity"]}} 
    />);
const linkedElement = screen.getByText(/New York/i);
expect(linkedElement).toBeInTheDocument();

});