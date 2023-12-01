import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {

  // const logout = () => {

  //   setAuth(false);
  //   window.sessionStorage.setItem('anyLoggedIn', false);
  // };
  const [user, setUser] = useState([[]])

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8090/studentcourses/all/${id}`);
    setUser(result.data);
    console.log(JSON.stringify(user));
  };

  const logout = () => {
    window.localStorage.setItem("anyUser",false);
  };

  return (
    <div className='container'>
        <div className='py-4'>
        <h1 className="viewh">Details Of Students For This Course</h1>
        <table className="table border shadow">
  <thead>
    <tr>
      <th scop="col">Index</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Roll No</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    {
        user.map((user,index)=>(
        <tr>
        <th scope="row" key={index}>{index+1}</th>
        <td>{user[0]}</td>
        <td>{user[1]}</td>
        <td>{user[2]}</td>
        <td>{user[3]}</td>
        <td>
        </td>
        </tr>
        ))}
    
  
  </tbody>
</table>
          <div>
            <Link type="submit" className='btn btn-dark mx-2' to="/" onClick={logout}>LOGOUT</Link>
          </div>
        </div>
    </div>
  );
}