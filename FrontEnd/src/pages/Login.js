import React, { useState } from 'react'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';


export default function Login() {
    let navigate=useNavigate()

    // const [user,setUser]=useState({
    //   name:"",
    //   username:"",
    //   email:""
    // })

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
    //     // await axios.post("http://localhost:8080/user",user)
    //     navigate("/home")
    // };

    const onSubmit= async (e)=>{
      e.preventDefault();

      try{
        const response = await axios.post("http://localhost:8080/login",loginData);
        setMsg(response.data.message);
        setLoginstatus(response.data.status);
        if(loginstatus===true)
        {
            navigate("/home")
        }
        else
        {
          alert(`wrong pass : ${msg}`);
          navigate("/")
        }
      }
      catch(error){
        alert(`login failed bro:${error}`);
        navigate("/")
      }
      
    };

  return (
    <div className="conatianer">
        <div className='row'>
          <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
            <h2 className='text-center m-4'>Log in Employee</h2>
            <form onSubmit={(e)=>onSubmit(e)}>
        
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
              type={"text"}
              className="form-control"
              placeholder='Enter your password'
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              />
            </div>

            <button type="submit" className='btn btn-outline-primary'>Submit</button>
            {/* <Link type="submit" className='btn btn-outline-danger mx-2' to="/">Cancel</Link> */}
            </form>
          </div>
        </div>
    </div>
  )
}