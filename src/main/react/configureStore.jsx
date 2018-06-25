import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import { createStore, applyMiddleware } from 'redux';
// импорт корневого редюсера
import rootReducer from './reducers';

// default - экспортируется только одна функция configureStore
export default function configureStore() {
  // создание хранилища на основе корневого редюсера
  // расширение через applyMiddleware, thunk для асинхронного взаимодействия
  return createStore(
    rootReducer,
    composeWithDevTools(applyMiddleware(thunk))
  );
};
