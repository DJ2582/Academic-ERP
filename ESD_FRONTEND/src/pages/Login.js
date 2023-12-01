import React, { useState } from 'react'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';
import './login.css';
import Swal from 'sweetalert2';
import toast from 'react-hot-toast';
import img from './back.jpg';

export default function Login({setAuth}) {
    let navigate=useNavigate()

    const [loginData,setLoginData]=useState({
      email:"",
      password:""
    })
  
    // const{name,username,email} = user

    const{email,password}=loginData

    const [loginstatus,setLoginstatus]=useState(false);

    // const onInputChange=(e)=>{
    //   setUser({...user,[e.target.name]:e.target.value})
    // };

    const onInputChange=(e)=>{
      setLoginData({...loginData,[e.target.name]:e.target.value})
    }

    const [msg,setMsg] = useState("");
    
    // const onSubmit= async (e)=>{
    //     e.preventDefault();
    //     // await axios.post("http://localhost:8090/user",user)
    //     navigate("/home")
    // };

    const onSubmit= async (e)=>{
      e.preventDefault();

      try{
        const response = await axios.post("http://localhost:8090/login",loginData);
        // setMsg(response.data.message);
        // setLoginstatus(response.data.status);
        if(response.data.status===true)
        {
          setAuth(true);
          window.localStorage.setItem('anyUser',true);
          Swal.fire({
            title: "Successfully Login!",
            text: "Press Ok to continue",
            icon: "success"
          });
            navigate(`/home/${response.data.id}`)
        }
        else
        {
          // alert(`Sorry : ${response.data.message}`);
          // toast.error("Email Or Password Not Match");
          Swal.fire({
            title: "Erron in Login!",
            text: "Wrong Password or Email!",
            icon: "error"
          });
          navigate("/")
        }
      }
      catch(error){
        alert(`login failed bro:${error}`);
        navigate("/")
      }
      
    };

  return (
    // <div style={{ backgroundImage: `url(${img})`, backgroundSize: 'cover', backgroundPosition: 'center', minHeight:'100vh' }}>
    <div className="container">
        <div className='row'>
          <div className='col-md-6 offset-md-3 border rounded p-4 mt-3 shad'>
            <h2 className='text-center m-4'>Welcome To Employee Portal</h2>
            <form className="login-form" onSubmit={(e)=>onSubmit(e)}>
        
            <div className='mb-3'>
              <label htmlFor='Email' className='form-label'>
                Enter Your Email
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder='Enter your Email'
              name="email"
              value={email}             
              onChange={(e)=>onInputChange(e)}
              />
            </div>

            <div className='mb-3'>
              <label htmlFor='Password' className='form-label'>
                Enter Password
              </label>
              <input
              type={"password"}
              className="form-control"
              placeholder='Enter your password'
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              />
            </div>
            <button type="submit" className='btn btn-dark'>Submit</button>
            {/* <h2>Go to Employee TimeTable</h2> */}
            {/* <Link type="submit" className='btn btn-outline-danger mx-2' to="/">Cancel</Link> */}
            </form>
          </div>
        </div>
    </div>
  // </div>
  )
}