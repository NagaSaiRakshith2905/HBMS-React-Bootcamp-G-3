import React, { useEffect, useState } from "react";
import "./SearchHotel.css";
import NavBar from "../../components/navbar/NavBar";
import BreadCrumbs from "../../components/BreadCrumb";
import { viewAllHotelAPI } from "../../Services/HotelService";
import HotelImage from "../../image/hotel_image.jpg";
import { NavLink, useNavigate } from "react-router-dom";
import PageNotFound from "../../components/page-not-found/PageNotFound";

const SearchHotel = () => {
  const navigate = useNavigate();
  const bcList = [
    {
      link: "/search_hotel",
      text: "Available Hotels",
    },
  ];
  const user = JSON.parse(localStorage.getItem("User-Data"));
  const [hotelsList, setHotelsList] = useState([]);
  async function getHotels() {
    await viewAllHotelAPI()
      .then((resp) => {
        setHotelsList(resp.data);
        console.log(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }
  useEffect(() => {
    user !== null && getHotels();
  }, []);
  return (
    <>
      {user === null ? (
        <PageNotFound />
      ) : (
        <div className="search-hotel">
          <NavBar />
          <div className="container">
            <BreadCrumbs list={bcList} />{" "}
          </div>
          <div className="hotel-cont">
            <div className="hotel-list">
              {hotelsList.map((hotel) => {
                return (
                  <NavLink
                    to={"/search_hotel/view_hotel/id=" + hotel.hotel_id}
                    key={hotel.hotel_id}
                  >
                    <div className="card">
                      <img src={HotelImage} alt="" />
                      <h4>{hotel.hotel_name}</h4>
                      <p>{hotel.city}</p>
                      <p>{hotel.description}</p>
                      <h5>view details</h5>
                    </div>
                  </NavLink>
                );
              })}
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default SearchHotel;
