import { Button, TextField, Typography, Grid } from "@mui/material";
import React, { useState } from "react";
import { addHotelAPI } from "../../../Services/HotelService";
import { useNavigate } from "react-router-dom";

const AddHotel = () => {
  let navigate = useNavigate();
  const [hotelData, sethotelData] = useState({
    city: "",
    hotel_name: "",
    address: "",
    description: "",
    avg_rate_per_day: "",
    email: "",
    phone1: "",
    phone2: "",
    website: "",
    roomDetailsList: [],
  });
  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function addHotel() {
    let error = {};
    if (!hotelData.city) {
      error["cityError"] = "City can't be empty";
    }
    if (!hotelData.hotel_name) {
      error["hotelnameError"] = "HotelName can't be empty";
    }
    if (!hotelData.address) {
      error["addressError"] = "Address can't be empty";
    }
    if (!hotelData.description) {
      error["descriptionError"] = "Description can't be empty";
    }
    if (!hotelData.avg_rate_per_day) {
      error["rateError"] = "Average Rate Per Day can't be empty";
    }
    if (!hotelData.email) {
      error["emailError"] = "Email can't be empty";
    }
    if (!hotelData.phone1) {
      error["phone1Error"] = "Mobile No can't be empty";
    }
    if (hotelData.phone1.length !== 10) {
      error["phone1Error"] = "invalid mobile number";
    }
    if (!hotelData.phone2) {
      error["phone2Error"] = "Mobile No can't be empty";
    }
    if (hotelData.phone2.length !== 10) {
      error["phone2Error"] = "invalid mobile number";
    }
    if (!hotelData.website) {
      error["websiteError"] = "Website can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await addHotelAPI(hotelData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            navigate("/admin_dashboard/view_hotel");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <div>
      Add Hotel
      <div style={{ maxWidth: "800px", marginBottom: "32px" }}>
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
              label="Hotel-Name"
              size="small"
              variant="outlined"
              error={formValidation.hotelnameError}
              helperText={formValidation.hotelnameError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.hotel_name}
              onChange={(e) => {
                sethotelData({ ...hotelData, hotel_name: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Description"
              size="small"
              variant="outlined"
              error={formValidation.descriptionError}
              helperText={formValidation.descriptionError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.description}
              onChange={(e) => {
                sethotelData({ ...hotelData, description: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="City"
              size="small"
              variant="outlined"
              error={formValidation.cityError}
              helperText={formValidation.cityError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.city}
              onChange={(e) => {
                sethotelData({ ...hotelData, city: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Address"
              size="small"
              variant="outlined"
              error={formValidation.addressError}
              helperText={formValidation.addressError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.address}
              onChange={(e) => {
                sethotelData({ ...hotelData, address: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Email"
              size="small"
              variant="outlined"
              error={formValidation.emailError}
              helperText={formValidation.emailError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.email}
              onChange={(e) => {
                sethotelData({ ...hotelData, email: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Website"
              size="small"
              variant="outlined"
              error={formValidation.websiteError}
              helperText={formValidation.websiteError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.website}
              onChange={(e) => {
                sethotelData({ ...hotelData, website: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Phone1"
              size="small"
              variant="outlined"
              error={formValidation.phone1Error}
              helperText={formValidation.phone1Error}
              sx={{ backgroundColor: "white" }}
              value={hotelData.phone1}
              onChange={(e) => {
                sethotelData({ ...hotelData, phone1: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Phone2"
              size="small"
              variant="outlined"
              error={formValidation.phone2Error}
              helperText={formValidation.phone2Error}
              sx={{ backgroundColor: "white" }}
              value={hotelData.phone2}
              onChange={(e) => {
                sethotelData({ ...hotelData, phone2: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <TextField
              fullWidth
              label="Average Rate per Day"
              size="small"
              variant="outlined"
              error={formValidation.rateError}
              helperText={formValidation.rateError}
              sx={{ backgroundColor: "white" }}
              value={hotelData.avg_rate_per_day}
              onChange={(e) => {
                sethotelData({
                  ...hotelData,
                  avg_rate_per_day: e.target.value,
                });
              }}
            />
          </Grid>
          <Grid item md={6}>
            <Button
              onClick={addHotel}
              variant="contained"
              color="success"
              size="medium"
              fullWidth
            >
              Add Hotel
            </Button>
          </Grid>
        </Grid>
      </div>
    </div>
  );
};

export default AddHotel;
