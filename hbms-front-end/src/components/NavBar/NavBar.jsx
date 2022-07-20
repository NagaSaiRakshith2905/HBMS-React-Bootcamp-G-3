import { Button } from "@mui/material";
import React from "react";
import { NavLink } from "react-router-dom";
import Logo from "../../asset/image/logo.svg";
import "./NavBar.css";

const NavBar = () => {
  return (
    <div>
      <div className="nav-bar">
        <div className="nav-container">
          <div className="logo">
            <NavLink to={"/"}>
              <img src={Logo} alt="logo" />
            </NavLink>
          </div>
          <div>
            <ul className="nav-items">
              <NavLink to={"/"}>
                <li>Search-Hotel</li>
              </NavLink>
              <NavLink to={"/view_bookings"}>
                <li>View-My-Bookings</li>
              </NavLink>
              <NavLink to={"/profile"}>
                <li>Profile</li>
              </NavLink>
            </ul>
          </div>
          <Button
            style={{ textTransform: "capitalize", background: "var(--orange)" }}
            variant="contained"
            size="small"
            color="warning"
          >
            Logout
          </Button>
        </div>
      </div>
    </div>
  );
};

export default NavBar;
