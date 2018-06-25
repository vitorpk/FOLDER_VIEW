import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';
// импорт редюсеров
import DataReducer from './DataReducer';

// корневой редюсер из других редюсеров
// routerReducer для постраничной навигации
const rootReducer = combineReducers({
  routing: routerReducer,
  DataReducer
});

// экспорт корневой редюсера
export default rootReducer;
