import { Button, TextField, Typography, Grid } from "@mui/material";
import { NavLink, useNavigate } from "react-router-dom";
import React, { useState } from "react";
import { updateBookingDetails } from "../Services/BookingDetailsService";

const VBUpdateBooking = () => {
  let navigate = useNavigate();
  const data = JSON.parse(localStorage.getItem("update-booking"));
  const [updatebookingData, setupdatebookingData] = useState({
    booking_id: data.booking_id,
    booked_from: data.booked_from,
    booked_to: data.booked_to,
    no_of_adults: data.no_of_adults,
    no_of_children: data.no_of_children,
    amount: data.amount,
  });

  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function updateBooking() {
    let error = {};
    if (!updatebookingData.booking_id) {
      error["bookingidError"] = "Booking-id can't be empty";
    }
    if (!updatebookingData.booked_from) {
      error["bookedfromError"] = "Booked-from can't be empty";
    }
    if (!updatebookingData.booked_to) {
      error["bookedtoError"] = "booked-to can't be empty";
    }
    if (!updatebookingData.no_of_adults) {
      error["noofadultsError"] = "No_of_adults can't be empty";
    }
    if (!updatebookingData.no_of_children) {
      error["noofchildrenError"] = "No_of_children can't be empty";
    }
    if (!updatebookingData.amount) {
      error["amountError"] = "Amount can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await updateBookingDetails(updatebookingData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            localStorage.removeItem("update-booking");
            navigate("/view_bookings");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }
  return (
    <div style={{ marginTop: "32px", marginBottom: "32px" }}>
      Update Booking Details of ID: {data.booking_id}
      <Grid container rowSpacing={2} columnSpacing={2}>
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
            label="BookingID"
            size="small"
            variant="outlined"
            error={formValidation.bookingidError}
            helperText={formValidation.bookingidError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.booking_id}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                booking_id: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}>
          <TextField
            fullWidth
            type={"date"}
            label="BookedFrom"
            size="small"
            variant="outlined"
            error={formValidation.bookedfromError}
            helperText={formValidation.bookedfromError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.booked_from}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                booked_from: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}>
          <TextField
            fullWidth
            type={"date"}
            label="BookedTo"
            size="small"
            variant="outlined"
            error={formValidation.bookedtoError}
            helperText={formValidation.bookedtoError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.booked_to}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                booked_to: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}>
          <TextField
            fullWidth
            label="NoofAdults"
            size="small"
            variant="outlined"
            error={formValidation.noofadultsError}
            helperText={formValidation.noofadultsError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.no_of_adults}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                no_of_adults: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}>
          <TextField
            fullWidth
            label="NoofChildren"
            size="small"
            variant="outlined"
            error={formValidation.noofchildrenError}
            helperText={formValidation.noofchildrenError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.no_of_children}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                no_of_children: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}>
          <TextField
            fullWidth
            label="Amount"
            size="small"
            variant="outlined"
            error={formValidation.amountError}
            helperText={formValidation.amountError}
            sx={{ backgroundColor: "white" }}
            value={updatebookingData.amount}
            onChange={(e) => {
              setupdatebookingData({
                ...updatebookingData,
                amount: e.target.value,
              });
            }}
          />
        </Grid>
        <Grid item md={6}></Grid>
        <Grid item md={6}>
          <Button
            onClick={updateBooking}
            size={"medium"}
            fullWidth
            color={"warning"}
            variant="contained"
          >
            Update Booking
          </Button>
        </Grid>
      </Grid>
    </div>
  );
};

export default VBUpdateBooking;
