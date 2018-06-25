import {
  CLEAR_DATA,
  // DELETE_DATA,
  GET_DATA,
  INIT_DATA,
  PROCESS_DATA,
  SAVED_DATA
} from '../actions/DataActions';

import { updateObject } from './Lib';

const initialState = {
  data: {},
  processing: false,
  reload: false,
  saved: false,
  response: ''
};

export default function ( state = initialState, action ) {
  let list = [];

  switch ( action.type ) {
    case CLEAR_DATA:
      return updateObject(state, {data: {}, processing: false, saved: false});
    // case CLEAR_LIST:
    //   return updateObject(state, {list: []});
    // case CLEAR_RESPONSE:
    //   list = state.list;
    //   list[action.index].response = '';
    //   return updateObject(state, {list: list});
    // case DELETE_DATA:
    //   list = state.list;
    //   if (action.response === 'OK') {
    //     list[action.index].response = '';
    //     list[action.index].remove = false;
    //     list[action.index].deleted = true;
    //   } else {
    //     list[action.index].response = action.response;
    //   }
    //   return updateObject(state, {list: list, response: action.response, processing: false});
    case GET_DATA:
      return updateObject(state, {data: action.data});
    // case GET_LIST:
    //   return updateObject(state, {list: action.list});
    case INIT_DATA:
      let dataNew = action.data;
      return updateObject(state, {data: dataNew});
    case PROCESS_DATA:
      let processing = action.processing;
      if (processing === undefined)
        processing = true;
      response = processing ? '' : state.response;
      return updateObject(state, {processing: processing, response: response});
    // case RELOAD_DATA:
    //   return updateObject(state, {reload: !state.reload});
    case SAVED_DATA:
      let response;
      let saved;
      if (action.response === 'OK') {
        response = '';
        saved = true;
      } else {
        response = action.response;
        saved = false;
      }
      return updateObject(state, {saved: saved, response: response});
    // case TOGGLE_REMOVE_DATA:
    //   list = state.list;
    //   let remove = list[action.index].remove;
    //   if (remove === undefined)
    //     remove = true;
    //   else
    //     remove = !remove;
    //     list[action.index].remove = remove;

    //   return updateObject(state, {list: list});
    default:
      return state;
  };
};