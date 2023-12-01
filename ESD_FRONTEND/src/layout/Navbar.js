import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  
  return (
    <div>
      <nav className="navbar navbar-dark bg-dark">
        <div className="container-fluid">
          <Link className="navbar-brand mx-auto text-center" to="/">
           Welcome To Academia Portal
          </Link>
        </div>
      </nav>
    </div>
  );
}