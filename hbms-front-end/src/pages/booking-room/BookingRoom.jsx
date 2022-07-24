import React, { useEffect, useState } from "react";
import "./BookingRoom.css";
import NavBar from "../../components/navbar/NavBar";
import BreadCrumbs from "../../components/BreadCrumb";
import { useParams } from "react-router-dom";
import { NavLink, useNavigate } from "react-router-dom";
import PageNotFound from "../../components/page-not-found/PageNotFound";
import { viewHotelAPI } from "../../Services/HotelService";
import { addBookingDetails } from "../../Services/BookingDetailsService";
import ChevronRightRoundedIcon from "@mui/icons-material/ChevronRightRounded";
import Payment from "../../components/Payment";

import {
  Button,
  Divider,
  Grid,
  Typography,
  TextField,
  Autocomplete,
} from "@mui/material";

const web = ["html", "js", "css", "react"];

const BookingRoom = () => {
  const navigate = useNavigate();
  let { id, name } = useParams();
  const user = JSON.parse(localStorage.getItem("User-Data"));
  const [roomList, setRoomList] = useState(["select"]);
  const [roomAvailable, setRoomAvailable] = useState(["false"]);
  const [bookingData, setbookingData] = useState({
    booked_from: "",
    booked_to: "",
    no_of_adults: "",
    no_of_children: "",
    amount: 0,
    hotel_id: id,
    room_id: [],
    user_id: user.user_id,
  });
  const bcList = [
    {
      link: "/search_hotel",
      text: "Available Hotels",
    },
    {
      link: "/search_hotel/view_hotel/id=" + id,
      text: `${name ? name : "view_hotel"}`,
    },
    {
      link: "/search_hotel/view_hotel/booking_room/id=" + id + "&name=" + name,
      text: "Book Room(s)",
    },
  ];

  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");
  const [open, setOpen] = useState(false);

  useEffect(() => {
    console.log(id);
    getHotel();
  }, []);
  async function getHotel() {
    await viewHotelAPI(id)
      .then((resp) => {
        const size = resp.data.roomDetailsList.length;
        const rooms = ["room-id:"];
        const available = [false];
        for (let i = 0; i < size; i++) {
          const room = resp.data.roomDetailsList[i].room_id;
          const a = resp.data.roomDetailsList[i].available;
          rooms.push(room);
          available.push(a);
        }
        setRoomList(rooms);
        setRoomAvailable(available);
        console.log(roomList, roomAvailable);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  async function addBooking() {
    let error = {};
    if (!bookingData.booked_from) {
      error["bookedfromError"] = "Booked-from can't be empty";
    }
    if (!bookingData.booked_to) {
      error["bookedtoError"] = "booked-to can't be empty";
    }
    if (!bookingData.no_of_adults) {
      error["noofadultsError"] = "No_of_adults can't be empty";
    }
    if (!bookingData.no_of_children) {
      error["noofchildrenError"] = "No_of_children can't be empty";
    }
    if (bookingData.amount <= 0) {
      error["amountError"] = "Amount can't be 0";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      console.log(bookingData);
      await addBookingDetails(bookingData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            localStorage.removeItem("Booking-Data");
            localStorage.setItem("Booking-Data", JSON.stringify(resp.data));
            setOpen(true);
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <>
      {user === null ? (
        <PageNotFound />
      ) : (
        <div className="book-room">
          <NavBar />
          <div className="container">
            <BreadCrumbs list={bcList} />{" "}
          </div>

          <div className="book-room-cont">
            <div className="book-data">
              <Grid container rowSpacing={1} columnSpacing={2}>
                <Grid item md={12}>
                  <h2>{name}</h2>
                </Grid>
                <Grid item md={12}>
                  <Divider
                    sx={{
                      width: "100%",
                      backgroundColor: "rgba(60, 60, 67, 0.1)",
                    }}
                  />
                </Grid>
                <Grid item md={12}>
                  <Typography
                    align={"center"}
                    textAlign={"center"}
                    variant="subtitle2"
                    component={"subtitle2"}
                    color={"red"}
                  >
                    {authError}
                  </Typography>
                </Grid>
                <Grid item md={6}>
                  <TextField
                    fullWidth
                    type={"date"}
                    label="Booking From"
                    size="small"
                    variant="outlined"
                    error={formValidation.bookedfromError}
                    helperText={formValidation.bookedfromError}
                    sx={{ backgroundColor: "white" }}
                    value={bookingData.booked_from}
                    onChange={(e) => {
                      setbookingData({
                        ...bookingData,
                        booked_from: e.target.value,
                      });
                    }}
                  />
                </Grid>
                <Grid item md={6}>
                  <TextField
                    fullWidth
                    type={"date"}
                    label="Booking To"
                    size="small"
                    variant="outlined"
                    error={formValidation.bookedtoError}
                    helperText={formValidation.bookedtoError}
                    sx={{ backgroundColor: "white" }}
                    value={bookingData.booked_to}
                    onChange={(e) => {
                      setbookingData({
                        ...bookingData,
                        booked_to: e.target.value,
                      });
                    }}
                  />
                </Grid>
                <Grid item md={6}>
                  <TextField
                    fullWidth
                    label="No.of Adults"
                    size="small"
                    type={"number"}
                    variant="outlined"
                    error={formValidation.noofadultsError}
                    helperText={formValidation.noofadultsError}
                    sx={{ backgroundColor: "white" }}
                    value={bookingData.no_of_adults}
                    onChange={(e) => {
                      setbookingData({
                        ...bookingData,
                        no_of_adults: e.target.value,
                      });
                    }}
                  />
                </Grid>
                <Grid item md={6}>
                  <TextField
                    fullWidth
                    label="No.of Children"
                    size="small"
                    type={"number"}
                    variant="outlined"
                    error={formValidation.noofchildrenError}
                    helperText={formValidation.noofchildrenError}
                    sx={{ backgroundColor: "white" }}
                    value={bookingData.no_of_children}
                    onChange={(e) => {
                      setbookingData({
                        ...bookingData,
                        no_of_children: e.target.value,
                      });
                    }}
                  />
                </Grid>
                <Grid item md={12}>
                  <Autocomplete
                    multiple
                    options={roomList}
                    getOptionDisabled={(option) =>
                      !roomAvailable[roomList.indexOf(option)]
                    }
                    onChange={(event, newValue) => {
                      console.log(newValue);
                      setbookingData({
                        ...bookingData,
                        room_id: newValue,
                      });
                    }}
                    renderInput={(params) => (
                      <TextField
                        {...params}
                        variant={"outlined"}
                        label="Select Rooms"
                        sx={{
                          backgroundColor: "white",
                        }}
                        size={"small"}
                        placeholder="Room numbers"
                      />
                    )}
                  />
                </Grid>
                <Grid item md={6}>
                  <TextField
                    fullWidth
                    label="Amount"
                    size="small"
                    type={"number"}
                    variant="outlined"
                    error={formValidation.amountError}
                    helperText={formValidation.amountError}
                    sx={{ backgroundColor: "white" }}
                    value={bookingData.amount}
                    onChange={(e) => {
                      setbookingData({
                        ...bookingData,
                        amount: e.target.value,
                      });
                    }}
                  />
                </Grid>
                <Grid item md={6}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"success"}
                    size={"medium"}
                    style={{
                      background: "var(--green)",
                      boxShadow: "none",
                      fontWeight: "600",
                    }}
                    endIcon={<ChevronRightRoundedIcon />}
                    onClick={addBooking}
                  >
                    Continue to book
                  </Button>
                </Grid>
              </Grid>
            </div>
          </div>
          <Payment open={open} setOpen={setOpen} amount={bookingData.amount} />
        </div>
      )}
    </>
  );
};

export default BookingRoom;
