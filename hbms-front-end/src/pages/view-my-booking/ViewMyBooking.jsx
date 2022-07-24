import React, { useEffect, useState } from "react";
import { viewAllHotelAPI } from "../../Services/HotelService";
import { viewUserByIdAPI } from "../../Services/UserService";
import VBTable from "../../components/VBTable";
import NavBar from "../../components/navbar/NavBar";
import BreadCrumbs from "../../components/BreadCrumb";
import { NavLink, useNavigate, Outlet } from "react-router-dom";
import PageNotFound from "../../components/page-not-found/PageNotFound";
import { Button } from "@mui/material";
import RefreshRoundedIcon from "@mui/icons-material/RefreshRounded";
import "./ViewBooking.css";
const ViewBooking = () => {
  const navigate = useNavigate();
  const [bookingList, setBookingList] = useState([]);
  const user = JSON.parse(localStorage.getItem("User-Data"));
  const bcList = [
    {
      link: "/view_bookings",
      text: "View Bookings",
    },
  ];
  async function getBookings() {
    await viewUserByIdAPI(user.user_id)
      .then((resp) => {
        setBookingList(resp.data.bookingDetails);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getBookings();
  }, []);

  return (
    <>
      {user === null ? (
        <PageNotFound />
      ) : (
        <div className="view-booking">
          <NavBar />
          <div className="container">
            <BreadCrumbs list={bcList} />{" "}
            <Button onClick={getBookings} color={"success"}>
              <RefreshRoundedIcon />
            </Button>
          </div>
          <div className="table-cont">
            <div className="table">
              <VBTable bookingList={bookingList} />
              <Outlet />
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default ViewBooking;
