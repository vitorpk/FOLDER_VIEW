import React, { Component } from 'react';
import { connect } from 'react-redux';

import { clearError, clearMessage, getMessage } from '../actions/DataActions';

const CHECK_FOLDER = 'check_folder';

class Nav extends Component {
  constructor(props) {
    super(props);

    this.folderInput = React.createRef();

    this.handleAlertClose = this.handleAlertClose.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    const store = Cookies.get('store');
    if (store) {
      this.folderInput.current.value = store;
      this.props.dispatch((getMessage(CHECK_FOLDER, {folder: store})));
    }
  }
  
  componentWillReceiveProps(nextProps) {
    if (nextProps.message == 'OK') {
      const value = this.folderInput.current.value;
      if (value)
        Cookies.set('store', value, { expires: 365 });
    }
  }

  handleAlertClose(e) {
    if (e.target.id == 'error')
      this.props.dispatch((clearError()));
    else
      this.props.dispatch((clearMessage()));
  }

  handleClick(e) {
    e.preventDefault();
    const value = this.folderInput.current.value;
    if (value)
      this.props.dispatch((getMessage(CHECK_FOLDER, {folder: value})));
  }

  // рендеринг компонента
  render() {
    const  { error, message } = this.props;

    let errorComponent = null;
    if (error)
      errorComponent = (
        <div className="alert alert-danger">
          <a id="error" className="close" onClick={this.handleAlertClose}>&times;</a>
          <strong>Ошибка!</strong> {error}
        </div>
      );
    
    let messageComponent = null;
    if (message && message != 'OK')
      messageComponent = (
        <div className="alert alert-info">
          <a id="message" className="close" onClick={this.handleAlertClose}>&times;</a>
          <strong>Внимание!</strong> {message}
        </div>
      );

    return (
      <nav className="navbar navbar-inverse">
        <div className="container-fluid">
          <div className="navbar-header navbar-brand">
            Просмотр каталогов
          </div>
          <form className="navbar-form navbar-left form-inline" action="/action_page.php">
            <div className="input-group">
              <input type="text" className="form-control" placeholder="Место хранения" ref={this.folderInput} />
              <div className="input-group-btn">
                <button className="btn btn-default" type="submit" onClick={this.handleClick}>
                <i className="fas fa-search"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
        {errorComponent}
        {messageComponent}
      </nav>
    );
  }
}

function mapStateToProps (state) {
  return {
    error: state.DataReducer.error,
    message: state.DataReducer.message,
    process: state.DataReducer.process
  };
};

export default connect (mapStateToProps)(Nav);
