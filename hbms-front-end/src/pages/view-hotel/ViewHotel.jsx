import React, { useEffect, useState } from "react";
import "./ViewHotel.css";
import NavBar from "../../components/navbar/NavBar";
import BreadCrumbs from "../../components/BreadCrumb";
import { useParams } from "react-router-dom";
import { NavLink, useNavigate } from "react-router-dom";
import PageNotFound from "../../components/page-not-found/PageNotFound";
import { Button, Divider } from "@mui/material";
import { viewHotelAPI } from "../../Services/HotelService";
import ChevronRightRoundedIcon from "@mui/icons-material/ChevronRightRounded";
const ViewHotel = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [hotelData, setHotelData] = useState({});
  const bcList = [
    {
      link: "/search_hotel",
      text: "Available Hotels",
    },
    {
      link: "/search_hotel/view_hotel/id=" + id,
      text: `${hotelData ? hotelData.hotel_name : "view_hotel"}`,
    },
  ];
  const user = JSON.parse(localStorage.getItem("User-Data"));
  useEffect(() => {
    console.log(id);
    getHotel();
  }, []);

  async function getHotel() {
    await viewHotelAPI(id)
      .then((resp) => {
        setHotelData(resp.data);
        console.log(resp.data.roomDetailsList[0].room_no);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <>
      {user === null ? (
        <PageNotFound />
      ) : (
        <div className="view-hotel">
          <NavBar />
          <div className="container">
            <BreadCrumbs list={bcList} />{" "}
          </div>
          <div className="view-cont">
            <div className="hotel-data">
              <h2>{hotelData.hotel_name}</h2>
              <Divider
                sx={{ width: "100%", backgroundColor: "rgba(60, 60, 67, 0.1)" }}
              />
              <h5>
                <span>Address: </span>
                {hotelData.address}
              </h5>
              <h5>
                <span>Description: </span>
                {hotelData.description}
              </h5>
              <h5>
                <span>Average Cost/day: </span>
                Rs {hotelData.avg_rate_per_day}/-
              </h5>
              <h5>
                <span>Contact Details: </span>
              </h5>
              <h5>
                <span>-Email-ID: </span>
                {hotelData.email}
              </h5>
              <h5>
                <span>-Website: </span>
                {hotelData.website}
              </h5>
              <h5>
                <span>-Mobile Number(s): </span>
                {hotelData.phone1}
                <span> / </span>
                {hotelData.phone2}
              </h5>

              <h5>
                <span>Room Details: </span>
              </h5>
              {hotelData.roomDetailsList &&
                hotelData.roomDetailsList.map((room) => {
                  return (
                    <div className="room-data">
                      <h5>
                        <span>-Room No.: </span>
                        {room.room_no} <span>/ Room Type: </span>
                        {room.room_type} <span>/ Available: </span>
                        {room.available ? "Yes" : "No"}
                      </h5>
                    </div>
                  );
                })}
              <Button
                fullWidth
                variant={"contained"}
                color={"success"}
                size={"small"}
                style={{
                  marginTop: "16px",
                  background: "var(--green)",
                  boxShadow: "none",
                  fontWeight: "600",
                }}
                endIcon={<ChevronRightRoundedIcon />}
                onClick={(e) => {
                  navigate(
                    "/search_hotel/view_hotel/booking_room/id=" +
                      hotelData.hotel_id +
                      "&name=" +
                      hotelData.hotel_name
                  );
                }}
              >
                Continue to book
              </Button>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default ViewHotel;
