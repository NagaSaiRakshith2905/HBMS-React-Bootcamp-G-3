import React from "react";

import { Breadcrumbs, Link } from "@mui/material";
import { NavLink } from "react-router-dom";

const BreadCrumbs = ({ list }) => {
  return (
    <div>
      <Breadcrumbs aria-label="breadcrumb">
        {list.map((item) => {
          return (
            <NavLink to={item.link}>
              <p style={{ color: "rgba(60, 60, 67, 0.6)" }}>{item.text}</p>
            </NavLink>
          );
        })}
      </Breadcrumbs>
    </div>
  );
};

export default BreadCrumbs;
