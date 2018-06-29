import React, { Component } from 'react';
import { connect } from 'react-redux';

import { clearError, clearMessage, getData, getMessage } from '../actions/DataActions';

const CHECK_FOLDER = 'check_folder';
const GET_DISK_LIST = 'get_disk_list';
const DISK_LIST_NAME = 'diskList';

class Nav extends Component {
  constructor(props) {
    super(props);

    this.state = {
      warning: ''
    }

    this.folderInput = React.createRef();

    this.handleAlertClose = this.handleAlertClose.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    const store = Cookies.get('store');
    if (store) {
      this.folderInput.current.value = store;
      this.props.dispatch(getMessage(CHECK_FOLDER, {folder: store}));
    }
  }
  
  componentWillReceiveProps(nextProps) {
    if (!nextProps.process) {
      const { data, dispatch } = this.props;
      if (data[DISK_LIST_NAME] === undefined)
        this.props.dispatch(getData(GET_DISK_LIST, DISK_LIST_NAME));
    }
    if (nextProps.message == 'OK') {
      const value = this.folderInput.current.value;
      if (value)
        Cookies.set('store', value, { expires: 365 });
    } else if (nextProps.message != '') {
      this.setState({warning: nextProps.message});
    }
  }

  handleAlertClose(e) {
    if (e.target.id == 'error')
      this.props.dispatch((clearError()));
    else {
      this.props.dispatch((clearMessage()));
      this.setState({warning: ''});
    }
  }

  handleClick(e) {
    e.preventDefault();
    const value = this.folderInput.current.value;
    if (value)
      this.props.dispatch((getMessage(CHECK_FOLDER, {folder: value})));
  }

  // рендеринг компонента
  render() {
    const  { data, error } = this.props;
    const  { warning } = this.state;

    let errorComponent = null;
    if (error)
      errorComponent = (
        <div className="alert alert-danger">
          <a id="error" className="close" onClick={this.handleAlertClose}>&times;</a>
          <strong>Ошибка!</strong> {error}
        </div>
      );
    let messageComponent = null;
    if (warning)
      messageComponent = (
        <div className="alert alert-info">
          <a id="message" className="close" onClick={this.handleAlertClose}>&times;</a>
          <strong>Внимание!</strong> {warning}
        </div>
      );
    
    let diskComponent = null;
    
    if (data[DISK_LIST_NAME] == undefined) {
      diskComponent = (
        <ul className="nav navbar-nav">
          <li className="dropdown">
            <a className="dropdown-toggle" data-toggle="dropdown" href="#">Диск<span className="caret"></span></a>
            <ul className="dropdown-menu">
            </ul>
          </li>
        </ul>
      );
    } else {
      const diskList = data[DISK_LIST_NAME].map(function(item, index) {
        return (
          <li key={index}><a href="#">{item.name}</a></li>
        );
      });
      diskComponent = (
        <ul className="nav navbar-nav">
          <li className="dropdown">
            <a className="dropdown-toggle" data-toggle="dropdown" href="#">Диск<span className="caret"></span></a>
            <ul className="dropdown-menu">
              {diskList}
            </ul>
          </li>
        </ul>
      );
    }

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
          {diskComponent}
        </div>
        {errorComponent}
        {messageComponent}
      </nav>
    );
  }
}

function mapStateToProps (state) {
  return {
    data: state.DataReducer.data,
    error: state.DataReducer.error,
    message: state.DataReducer.message,
    process: state.DataReducer.process
  };
};

export default connect (mapStateToProps)(Nav);
