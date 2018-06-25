import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

class App extends Component {
  // фаза, когда компонент примонтировался. Выполняет AJAX-запрос на получение списка
  componentDidMount() {
  }

  // рендеринг компонента
  render() {

    return (
      <div>
        Hello!
      </div>
    );
  }
}

// связывания свойств и состояний в store
function mapStateToProps (state) {
  return {
  };
};

// подключение компонента к store
export default connect (mapStateToProps)(App);
