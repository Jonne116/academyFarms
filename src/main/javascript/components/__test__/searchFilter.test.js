import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import React from 'react';
import SearchFilter from '../searchFilter';



it('Component should mount', () => {
  render(<SearchFilter 
    locationsSensors={{
      location:["New York"], 
      sensorType: ["Humidity"]}} 
    />);
  const linkedElement = screen.getByText(/New York/i);
  expect(linkedElement).toBeInTheDocument();
});

it('Locations filter should be checked when clicked', () => {
  const setSensorType = jest.fn();
  const setLocation = jest.fn();

  render(<SearchFilter 
    locationsSensors={{
      location:["New York"], 
      sensorType: ["Humidity"]}} 
      setSensorType={setSensorType}
      setLocation={setLocation}
    />);
  const checkBox = screen.getByRole('checkbox', { name: "New York"});
  userEvent.click(checkBox);
  expect(checkBox).toBeChecked();
});