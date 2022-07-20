import { Breadcrumbs, Link } from "@mui/material";
import React from "react";
import { NavLink } from "react-router-dom";

const BreadCrumbs = () => {
  return (
    <div>
      <Breadcrumbs aria-label="breadcrumb">
      <NavLink to={"/"}>
                Search-Hotel
              </NavLink>
              <NavLink to={"/view_bookings"}>
                View-My-Bookings
              </NavLink>
              <NavLink to={"/profile"}>
                Profile
              </NavLink>
      </Breadcrumbs>
    </div>
  );
};

export default BreadCrumbs;
