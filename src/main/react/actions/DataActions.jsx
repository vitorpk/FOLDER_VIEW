import axios from 'axios';

// export const CLEAR_DATA = 'CLEAR_DATA';
// export const GET_DATA = 'GET_DATA';
// export const INIT_DATA = 'INIT_DATA';
// export const PROCESS_DATA = 'PROCESS_DATA';
// export const SAVED_DATA = 'SAVED_DATA';

export const CLEAR_MESSAGE = 'CLEAR_MESSAGE';
export const CLEAR_ERROR = 'CLEAR_ERROR';
export const SET_DATA = 'SET_DATA';
export const SET_ERROR = 'SET_ERROR';
export const SET_MESSAGE = 'SET_MESSAGE';
export const SET_PROCESS = 'SET_PROCESS';

import { PATH } from '../Constants';

// export function clearData() {
//   return ( dispatch ) => {
//     return dispatch( { type: CLEAR_DATA } );
//   }
// };

export function clearError() {
  return ( dispatch ) => {
    return dispatch( { type: CLEAR_ERROR } );
  }
};

export function clearMessage() {
  return ( dispatch ) => {
    return dispatch( { type: CLEAR_MESSAGE } );
  }
};

export function getData(path, params) {
  return dispatch => {
    dispatch( { type: SET_PROCESS } );

    axios.get( PATH + path, {
      params: params
    } )
    .then( result => {
      dispatch( { type: SET_DATA, data: result.data } );
    } )
    .catch( error => {
      dispatch( { type: SET_ERROR, error: error } );
    } );
  };
}

export function getMessage(path, params) {
  return dispatch => {
    dispatch( { type: SET_PROCESS } );

    axios.get( PATH + path, {
      params: params
    } )
    .then( result => {
      dispatch( { type: SET_MESSAGE, message: result.data } );
    } )
    .catch( error => {
      dispatch( { type: SET_ERROR, error: error } );
    } );
  };
}

// export function initData(data) {
//   return dispatch => {
//     dispatch( { type: INIT_DATA, data: data } );
//   };
// }

// export function updateData(path, data) {
//   var qs = require('qs');
//   const csrfToken = document.getElementById('csrf-token').innerHTML;

//   return dispatch => {
//     dispatch( { type: PROCESS_DATA } );

//     axios.post( PATH + path, qs.stringify({
//         data: JSON.stringify(data),
//         _csrf: csrfToken
//     }) )
//     .then( result => {
//       dispatch( { type: PROCESS_DATA, processing: false } );
//       dispatch( { type: SAVED_DATA, response: result.data } );
//     } )
//     .catch( error => {
//     } );
//   };
// }