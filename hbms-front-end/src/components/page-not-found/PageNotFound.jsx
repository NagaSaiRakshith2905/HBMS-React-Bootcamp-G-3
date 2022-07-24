import React from "react";
import "./PageNotFound.css";
import { NavLink, useNavigate } from "react-router-dom";
import image from "../../image/page_not_found.jpg";
import { Button } from "@mui/material";

const PageNotFound = () => {
  let navigate = useNavigate();
  return (
    <div className="page-not-found">
      <img src={image} alt="" />
      <Button
        variant={"contained"}
        onClick={(e) => {
          navigate("/");
        }}
        color={"error"}
        size={"small"}
      >
        please login
      </Button>
    </div>
  );
};

export default PageNotFound;
