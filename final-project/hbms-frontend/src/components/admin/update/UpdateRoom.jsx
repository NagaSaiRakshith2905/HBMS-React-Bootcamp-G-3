import { Button, TextField, Typography, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import React, { useState } from "react";
import { updateRoomAPI } from "../../../Services/RoomManagementService";

const UpdateRoom = () => {
  const navigate = useNavigate();
  const data = JSON.parse(localStorage.getItem("update-room"));
  const [updateroomData, setupdateroomData] = useState({
    room_id: data.room_id,
    room_no: data.room_no,
    room_type: data.room_type,
    rate_per_day: data.rate_per_day,
    photo: data.photo,
    available: data.available,
  });

  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function updateRoom() {
    let error = {};
    if (!updateroomData.room_no) {
      error["roomidError"] = "Room-id can't be empty";
    }
    if (!updateroomData.room_no) {
      error["roomnoError"] = "Room-no can't be empty";
    }
    if (!updateroomData.room_type) {
      error["roomtypeError"] = "Room-type can't be empty";
    }
    if (!updateroomData.rate_per_day) {
      error["rateperdayError"] = "Rate-per-day can't be empty";
    }
    if (!updateroomData.photo) {
      error["photoError"] = "Photo can't be empty";
    }
    if (!updateroomData.available) {
      error["availableError"] = "Available can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await updateRoomAPI(updateroomData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            localStorage.removeItem("update-room");
            navigate("/admin_dashboard/view_room");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <div>
      Update Room
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
              label="Room-ID"
              size="small"
              variant="outlined"
              error={formValidation.roomidError}
              helperText={formValidation.roomidError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.room_id}
              onChange={(e) => {
                setupdateroomData({
                  ...updateroomData,
                  room_id: e.target.value,
                });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Room No"
              size="small"
              variant="outlined"
              error={formValidation.roomnoError}
              helperText={formValidation.roomnoError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.room_no}
              onChange={(e) => {
                setupdateroomData({
                  ...updateroomData,
                  room_no: e.target.value,
                });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="RoomType"
              size="small"
              variant="outlined"
              error={formValidation.roomtypeError}
              helperText={formValidation.roomtypeError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.room_type}
              onChange={(e) => {
                setupdateroomData({
                  ...updateroomData,
                  room_type: e.target.value,
                });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Rate-Per-Day"
              size="small"
              variant="outlined"
              error={formValidation.rateperdayError}
              helperText={formValidation.rateperdayError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.rate_per_day}
              onChange={(e) => {
                setupdateroomData({
                  ...updateroomData,
                  rate_per_day: e.target.value,
                });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Photo"
              size="small"
              variant="outlined"
              error={formValidation.photoError}
              helperText={formValidation.photoError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.photo}
              onChange={(e) => {
                setupdateroomData({ ...updateroomData, photo: e.target.value });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Available"
              size="small"
              variant="outlined"
              error={formValidation.availableError}
              helperText={formValidation.availableError}
              sx={{ backgroundColor: "white" }}
              value={updateroomData.available}
              onChange={(e) => {
                setupdateroomData({
                  ...updateroomData,
                  available: e.target.value,
                });
              }}
            />
          </Grid>
          <Grid item md={6}></Grid>
          <Grid item md={6}>
            <Button
              onClick={updateRoom}
              size={"medium"}
              color={"warning"}
              fullWidth
              variant="contained"
            >
              Update Room
            </Button>
          </Grid>
        </Grid>
      </div>
    </div>
  );
};

export default UpdateRoom;
