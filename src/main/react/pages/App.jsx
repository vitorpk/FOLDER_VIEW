import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import Nav from '../containers/Nav';

class App extends Component {
  // фаза, когда компонент примонтировался. Выполняет AJAX-запрос на получение списка
  componentDidMount() {
  }

  // рендеринг компонента
  render() {

    return (
      <div>
        <Nav />
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
