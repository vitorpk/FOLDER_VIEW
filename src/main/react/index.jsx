// подключаем модули для работы с react и redux
import 'babel-polyfill';
import React from 'react';
import ReactDOM from 'react-dom';
import { Provider} from 'react-redux';
import { Router, Route, browserHistory } from 'react-router';
import { syncHistoryWithStore } from 'react-router-redux';
// импорт русской локали для дат
// import moment from 'moment';
// import 'moment/locale/ru';

// импорт функции configureStore для настройки хранилища
import configureStore from './configureStore'
// импорт компонентов
import App from './pages/App';

import { PATH } from './Constants';

// настройка хранилища (store) через вызов функции configureStore
const store = configureStore();
// синхронизация истории браузера и хранилища
const history = syncHistoryWithStore(browserHistory, store);
// подключение русской локали для дат
//moment.locale('ru');

ReactDOM.render(
  // роутеры нужны для того, чтобы обеспечить постраничную навигацию
  // в зависимости от пути будет открываться нужный компонент
  <Provider store={store}>
    <Router history={history}>
      <div>
        <Route exact path={PATH} component={App} />
      </div>
    </Router>
  </Provider>,
  // рендеринг в div с id = "ida"
  document.getElementById('root')
);
