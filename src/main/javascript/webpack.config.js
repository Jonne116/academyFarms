const path = require('path');
require('dotenv').config({ path: '../../../.env' });

module.exports = {
  performance : {
    hints : false
  },        
  entry: path.resolve(__dirname, 'index.js'),
  output: {
    path: path.resolve(__dirname, './build/'),
    filename: 'bundle.js'
  },
  devServer: {
    port: process.env.PORT_WEBPACK || 3003,
    proxy: [
      {
        context: ['/api'],
        target: `http://localhost:${process.env.SPRING_DOCKER_PORT || 8080}`,
      }]
  },
  module: {
    rules: [
      {
        test: /\.(jsx|js)$/,
        include: path.resolve(__dirname),
        exclude: /node_modules/,
        use: [{
          loader: 'babel-loader',
          options: {
            presets: [
              ['@babel/preset-env', {
                'targets': { 'esmodules': true }
              }],
              '@babel/preset-react'
            ]
          }
        }]
      },
      {
        test: /\.css$/,  
        use: [
          'style-loader',
          'css-loader'
        ]
      }
    ]
  }
};