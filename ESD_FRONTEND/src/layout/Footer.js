import React from 'react'

const footerStyle = {
    position: 'fixed',
    bottom: 0,
    left: 0,
    width: '100%',
  };

export default function Footer() {
  return (
    <div class="card text-center bg-dark text-white" style={footerStyle}>
    <div class="card-header">
      IIITB
    </div>
    <div class="card-body">
      <h5 class="card-title">Academia Portal @COPYRIGHT,2023</h5>
      <p class="card-text">Designed By Darshit Jakhaniya</p>
      {/* <a href="#" class="btn btn-primary">Go somewhere</a> */}
    </div>
    <div class="card-footer text-body-secondary">
    </div>
  </div>
  );
}
