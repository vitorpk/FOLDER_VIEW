var axios = require('axios');
var babelcore = require('@babel/core');
var babelloader = require('babel-loader');
var babelpolyfill = require("babel-polyfill");
var babelpresetenv = require('@babel/preset-env');
var babelpresetreact = require('@babel/preset-react');
var cssloader = require('css-loader');
var jquery = require('jquery');
var path = require('path');
var proptypes = require('prop-types');
var qs = require('qs');
var react = require('react');
var reactdom = require('react-dom');
var reactredux = require('react-redux');
var reactrouter = require('react-router');
var routerredux = require('react-router-redux');
var redux = require('redux');
var reduxdevtoolsextension = require('redux-devtools-extension');
var reduxthunk = require('redux-thunk');
var styleloader = require('style-loader');
var webpack = require('webpack');

const NODE_ENV = process.env.NODE_ENV || 'development';

module.exports = {
	entry: './src/main/react/index',
	output: {
		path: path.join(__dirname, 'src/main/webapp/static/js'),
		filename: 'bundle.js'
	},
	resolve: {
		extensions: ['.js', '.jsx'],
    modules: [
      path.join(__dirname, 'src/main/react'),
      'node_modules'
    ]
	},
	plugins: [
		new webpack.NoEmitOnErrorsPlugin(),
    new webpack.DefinePlugin({
      NODE_ENV: JSON.stringify(NODE_ENV),
      DEBUG: false
    })
	],
	module: {
		rules: [
			{
				test: /\.jsx$/,
				include: [
					path.resolve(__dirname, 'src'),
				],
				exclude: /(node_modules)/,
				use:
					{ loader: 'babel-loader',
						options: {
							presets: ['@babel/preset-env']
						}
					}
			},
			{
				test: /\.css$/,
				use: [
					{ loader: "style-loader" },
					{ loader: "css-loader" }
					]
			}
		]
	},
	watch: NODE_ENV == 'development',
  devtool: (NODE_ENV == 'development' ? 'cheap-inline-module-source-map' : false)
}

if (NODE_ENV == 'production') {
  module.exports.plugins.push (
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false,
        drop_console: true
      }
    })
  )
}
