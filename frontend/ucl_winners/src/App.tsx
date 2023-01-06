import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Datatable from './Datatable';
import LoginButton from './LoginButton';
import Profile from './Profile';


function App() {
  return (
    <Router>  
      <Routes>
        <Route path="/profile" element={<Profile/>}></Route>
        <Route path="/" element={<div>
                                  <LoginButton></LoginButton>
                                  <div></div>
                                  <Datatable/>
                                </div>}>
        </Route>
      </Routes>
    </Router>
)
}

export default App;
