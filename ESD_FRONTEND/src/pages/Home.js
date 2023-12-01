import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { Link, useParams } from "react-router-dom";

export default function Home() {


    const [users,setUsers]=useState([[]])

    const { id } = useParams();


    useEffect(()=>{
        loadUsers();
        // console.log("1230");
    },[]);

    const loadUsers = async ()=>{
        const result = await axios.get(`http://localhost:8090/courseschedule/course/${id}`);
        setUsers(result.data);
        console.log(users);
    };

    // const deleteUser = async (id) => {
    //   await axios.delete(`http://localhost:8090/user/${id}`);
    //   loadUsers();
    // };
  
  return (
    <div className='container'>
        <div className='py-4'>
        <h1 className='fach'>Faculty TimeTable</h1>
        <table className="table border shadow">
  <thead>
    <tr>
      <th scop="col">Index</th>
      <th scope="col">Course Name</th>
      <th scope="col">Time</th>
      <th scope="col">Room</th>
      <th scope="col">Day</th>
      <th scope="col">Specialization</th>
      <th scope="col"> Enrolled Students</th>
    </tr>
  </thead>
  <tbody>
    {
        users.map((user,index)=>(
        <tr>
        <th scope="row" key={index}>{index+1}</th>
        <td>{user[0]}</td>
        <td>{user[1]}</td>
        <td>{user[2]}</td>
        <td>{user[3]}</td>
        <td>{user[4]}</td>
        <td>

        <Link
          className="btn btn-primary mx-2"
          to={`/viewuser/${user[5]}`}
        >
          View
        </Link>
        </td>
        </tr>
        ))}
    
  
  </tbody>
</table>

        </div>
    </div>
  );
}
