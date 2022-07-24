import React from "react";
import Logo from "../../image/logo.svg";
import "./NavBar.css";
import { NavLink, useNavigate } from "react-router-dom";
import { Button } from "@mui/material";

const NavBar = () => {
  const navigate = useNavigate();
  function logout() {
    const user = JSON.parse(localStorage.getItem("User-Data"));
    if (user !== null) {
      localStorage.removeItem("User-Data");
      navigate("/");
    }
  }
  let activeStyle = {
    fontSize: "14px",
    transition: "ease-out 200ms",
    color: "var(--text-primary)",
  };
  let noActiveStyle = {
    fontSize: "14px",
    transition: "ease-out 200ms",
    color: "var(--text-secondary)",
  };
  return (
    <div className="nav-bar">
      <nav>
        <NavLink to={"/search_hotel"}>
          <img src={Logo} alt="" />
        </NavLink>
        <div className="nav-links">
          <ul className="nav-items">
            <NavLink
              to={"/search_hotel"}
              style={({ isActive }) => (isActive ? activeStyle : noActiveStyle)}
            >
              Search-Hotel
            </NavLink>
            <NavLink
              to={"/view_bookings"}
              style={({ isActive }) => (isActive ? activeStyle : noActiveStyle)}
            >
              View-My-Bookings
            </NavLink>
            <NavLink
              to={"/profile"}
              style={({ isActive }) => (isActive ? activeStyle : noActiveStyle)}
            >
              Profile
            </NavLink>
          </ul>
        </div>
        <Button
          style={{
            textTransform: "capitalize",
            background: "var(--orange)",
            borderRadius: "16px",
            height: "24px",
            boxShadow: "none",
            padding: "0 16px",
            fontSize: "12px",
          }}
          variant={"contained"}
          size={"small"}
          color={"warning"}
          onClick={logout}
        >
          Logout
        </Button>
      </nav>
    </div>
  );
};

export default NavBar;
