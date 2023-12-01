import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Footer from './layout/Footer';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import ViewUser from "./users/ViewUser";
import Login from './pages/Login';
import React,{useState} from 'react';


function App() {

  const[isAuth,setAuth]=useState(!!window.localStorage.getItem("anyUser"));

  return (
    <div className="App">
     <Router>

     {/* <Navbar/> */}
     {isAuth && <Navbar/>}

     <Routes>
        <Route exact path="/" element={<Login setAuth={setAuth}/>}/>
        {isAuth && <Route exact path="/home/:id" element={<Home/>}>
          <Route path="*" element={<Home/>}></Route>
          </Route>}
        {isAuth && <Route exact path="/viewuser/:id" element={<ViewUser />} />}
        <Route path="*" element={<Login setAuth={setAuth}/>}/>
     </Routes>
    <Footer/>
     </Router>
    </div>
  );
}

export default App;
