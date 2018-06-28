import {
  CLEAR_ERROR,
  CLEAR_MESSAGE,
  SET_DATA,
  SET_ERROR,
  SET_MESSAGE,
  SET_PROCESS
} from '../actions/DataActions';

import { updateObject } from './Lib';

const initialState = {
  data: {},
  process: false,
  error: '',
  message: ''
};

export default function ( state = initialState, action ) {
  let list = [];

  switch ( action.type ) {
    case CLEAR_ERROR:
    return updateObject(state, {error: '' });
    case CLEAR_MESSAGE:
      return updateObject(state, {message: '' });
    case SET_DATA:
      return updateObject(state, {data: action.data, process: false});
    case SET_ERROR:
    const { error } = action;
    if (error.response.status === 400)
      return updateObject(state, {error: error.message + ': ' + error.response.data + ' (' + error.response.status + ')' });
    else
      return updateObject(state, {error: error.message + ': ' + error.response.statusText + ' (' + error.response.status + ')' });
    case SET_MESSAGE:
      return updateObject(state, {message: action.message, process: false});
    case SET_PROCESS:
      return updateObject(state, {process: false, error: '', message: '', status: 0, statusText: ''});
    // case CLEAR_DATA:
    //   return updateObject(state, {data: {}, processing: false, saved: false});
    // case GET_DATA:
    //   return updateObject(state, {data: action.data});
    // case INIT_DATA:
    //   let dataNew = action.data;
    //   return updateObject(state, {data: dataNew});
    // case PROCESS_DATA:
    //   let processing = action.processing;
    //   if (processing === undefined)
    //     processing = true;
    //   response = processing ? '' : state.response;
    //   return updateObject(state, {processing: processing, response: response});
    // case SAVED_DATA:
    //   let response;
    //   let saved;
    //   if (action.response === 'OK') {
    //     response = '';
    //     saved = true;
    //   } else {
    //     response = action.response;
    //     saved = false;
    //   }
    //   return updateObject(state, {saved: saved, response: response});
    default:
      return state;
  };
};