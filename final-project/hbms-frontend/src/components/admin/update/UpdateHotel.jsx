import { Button, TextField, Typography, Grid } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { updateHotelAPI } from "../../../Services/HotelService";

const UpdateHotel = () => {
  const navigate = useNavigate();
  const data = JSON.parse(localStorage.getItem("update-hotel"));

  const [updatehotelData, setupdatehotelData] = useState({
    hotel_id: data.hotel_id,
    city: data.city,
    hotel_name: data.hotel_name,
    address: data.address,
    description: data.description,
    avg_rate_per_day: data.avg_rate_per_day,
    email: data.email,
    phone1: data.phone1,
    phone2: data.phone2,
    website: data.website,
  });
  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function updateHotel() {
    let error = {};
    if (!updatehotelData.hotel_id) {
      error["hotelidError"] = "Hotel ID can't be empty";
    }
    if (!updatehotelData.city) {
      error["cityError"] = "City can't be empty";
    }
    if (!updatehotelData.hotel_name) {
      error["hotelnameError"] = "HotelName can't be empty";
    }
    if (!updatehotelData.address) {
      error["addressError"] = "Address can't be empty";
    }
    if (!updatehotelData.description) {
      error["descriptionError"] = "Description can't be empty";
    }
    if (!updatehotelData.avg_rate_per_day) {
      error["rateError"] = "Average Rate Per Day can't be empty";
    }
    if (!updatehotelData.email) {
      error["emailError"] = "Email can't be empty";
    }
    if (!updatehotelData.phone1) {
      error["phone1Error"] = "Mobile No can't be empty";
    }
    if (updatehotelData.phone1.length !== 10) {
      error["phone1Error"] = "invalid mobile number";
    }
    if (!updatehotelData.phone2) {
      error["phone2Error"] = "Mobile No can't be empty";
    }
    if (updatehotelData.phone2.length !== 10) {
      error["phone2Error"] = "invalid mobile number";
    }
    if (!updatehotelData.website) {
      error["websiteError"] = "Website can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await updateHotelAPI(updatehotelData)
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
      Update Hotel
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
              disabled="true"
              label="Hotel ID"
              size="small"
              variant="outlined"
              error={formValidation.hotelidError}
              helperText={formValidation.hotelidError}
              sx={{ backgroundColor: "white" }}
              value={updatehotelData.hotel_id}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  hotel_id: e.target.value,
                });
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
              value={updatehotelData.city}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  city: e.target.value,
                });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="HotelName"
              size="small"
              variant="outlined"
              error={formValidation.hotelnameError}
              helperText={formValidation.hotelnameError}
              sx={{ backgroundColor: "white" }}
              value={updatehotelData.hotel_name}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  hotel_name: e.target.value,
                });
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
              value={updatehotelData.address}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  address: e.target.value,
                });
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
              value={updatehotelData.description}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  description: e.target.value,
                });
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
              value={updatehotelData.avg_rate_per_day}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  avg_rate_per_day: e.target.value,
                });
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
              value={updatehotelData.email}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  email: e.target.value,
                });
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
              value={updatehotelData.phone1}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  phone1: e.target.value,
                });
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
              value={updatehotelData.phone2}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  phone2: e.target.value,
                });
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
              value={updatehotelData.website}
              onChange={(e) => {
                setupdatehotelData({
                  ...updatehotelData,
                  website: e.target.value,
                });
              }}
            />
          </Grid>
          <Grid item md={6}></Grid>

          <Grid item md={6}>
            {" "}
            <Button
              onClick={updateHotel}
              fullWidth
              size="medium"
              color={"warning"}
              variant="contained"
            >
              Update Hotel
            </Button>
          </Grid>
        </Grid>
      </div>
    </div>
  );
};

export default UpdateHotel;
