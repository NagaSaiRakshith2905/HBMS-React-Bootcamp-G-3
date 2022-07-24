import React from "react";
import "./Profile.css";
import PageNotFound from "../../components/page-not-found/PageNotFound";
import NavBar from "../../components/navbar/NavBar";
import BreadCrumb from "../../components/BreadCrumb";
import { Button } from "@mui/material";
import { Outlet } from "react-router-dom";
import { useNavigate } from "react-router-dom";

const Profile = () => {
  let navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem("User-Data"));
  const bcList = [
    {
      link: "/profile",
      text: "My Profile",
    },
  ];
  return (
    <>
      {user === null ? (
        <PageNotFound />
      ) : (
        <div className="profile">
          <NavBar />
          <div className="bread-crumbs">
            <BreadCrumb list={bcList} />
            <div className="buttons">
              <Button
                variant={"contained"}
                size={"small"}
                color={"success"}
                onClick={(e) => {
                  navigate("/profile/view");
                }}
              >
                View
              </Button>
              <Button
                variant={"contained"}
                size={"small"}
                color={"warning"}
                onClick={(e) => {
                  navigate("/profile/update");
                }}
              >
                update
              </Button>
              <Button
                variant={"contained"}
                size={"small"}
                color={"error"}
                onClick={(e) => {
                  navigate("/profile/delete");
                }}
              >
                delete
              </Button>
            </div>
          </div>
          <div className="profile-cont">
            <div className="data">
              <Outlet />
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Profile;
