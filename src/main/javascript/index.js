import 'file-loader?name=[name].[ext]!./index.html';
import 'file-loader?name=[name].[ext]!./fonts/Roboto-Medium.ttf';
import './style.css';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './app';

ReactDOM.render(
  <App />,
  document.getElementById('root')
);