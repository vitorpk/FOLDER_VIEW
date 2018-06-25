import axios from 'axios';

export const CLEAR_DATA = 'CLEAR_DATA';
export const GET_DATA = 'GET_DATA';
export const INIT_DATA = 'INIT_DATA';
export const PROCESS_DATA = 'PROCESS_DATA';
export const SAVED_DATA = 'SAVED_DATA';

import { PATH } from '../Constants';

export function clearData() {
  return ( dispatch ) => {
    return dispatch( { type: CLEAR_DATA } );
  }
};

export function getData(path, id) {
  return dispatch => {
    axios.get( PATH + path, {
      params: {
        id: id
      }
    } )
    .then( result => {
      dispatch( { type: GET_DATA, data: result.data } );
    } )
    .catch( error => {
    } );
  };
}

export function initData(data) {
  return dispatch => {
    dispatch( { type: INIT_DATA, data: data } );
  };
}

export function updateData(path, data) {
  var qs = require('qs');
  const csrfToken = document.getElementById('csrf-token').innerHTML;

  return dispatch => {
    dispatch( { type: PROCESS_DATA } );

    axios.post( PATH + path, qs.stringify({
        data: JSON.stringify(data),
        _csrf: csrfToken
    }) )
    .then( result => {
      dispatch( { type: PROCESS_DATA, processing: false } );
      dispatch( { type: SAVED_DATA, response: result.data } );
    } )
    .catch( error => {
    } );
  };
}