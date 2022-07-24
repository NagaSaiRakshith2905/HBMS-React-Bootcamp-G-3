import { Button, TextField, Typography, Grid } from "@mui/material";
import { useNavigate } from "react-router-dom";
import React, { useState } from "react";
import { addRoomAPI } from "../../../Services/RoomManagementService";

const AddRoom = () => {
  const navigate = useNavigate();
  const [roomData, setroomData] = useState({
    room_no: "",
    room_type: "",
    rate_per_day: "",
    photo: "",
    hotel_id: "",
    available: "",
  });

  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function addRoom() {
    let error = {};
    if (!roomData.room_no) {
      error["roomnoError"] = "Room-no can't be empty";
    }
    if (!roomData.room_type) {
      error["roomtypeError"] = "Room-type can't be empty";
    }
    if (!roomData.rate_per_day) {
      error["rateperdayError"] = "Rate-per-day can't be empty";
    }
    if (!roomData.photo) {
      error["photoError"] = "Photo can't be empty";
    }
    if (!roomData.hotel_id) {
      error["hotelidError"] = "Hotel-id can't be empty";
    }
    if (!roomData.available) {
      error["availableError"] = "Available can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await addRoomAPI(roomData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            navigate("/admin_dashboard/view_room");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <div>
      Add Room
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
              label="Room No"
              size="small"
              variant="outlined"
              error={formValidation.roomnoError}
              helperText={formValidation.roomnoError}
              sx={{ backgroundColor: "white" }}
              value={roomData.room_no}
              onChange={(e) => {
                setroomData({ ...roomData, room_no: e.target.value });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Room Type"
              size="small"
              variant="outlined"
              error={formValidation.roomtypeError}
              helperText={formValidation.roomtypeError}
              sx={{ backgroundColor: "white" }}
              value={roomData.room_type}
              onChange={(e) => {
                setroomData({ ...roomData, room_type: e.target.value });
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
              value={roomData.rate_per_day}
              onChange={(e) => {
                setroomData({ ...roomData, rate_per_day: e.target.value });
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
              value={roomData.photo}
              onChange={(e) => {
                setroomData({ ...roomData, photo: e.target.value });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Hotel-Id"
              size="small"
              variant="outlined"
              error={formValidation.hotelidError}
              helperText={formValidation.hotelidError}
              sx={{ backgroundColor: "white" }}
              value={roomData.hotel_id}
              onChange={(e) => {
                setroomData({ ...roomData, hotel_id: e.target.value });
              }}
            />
          </Grid>

          <Grid item md={6}>
            <TextField
              fullWidth
              label="Is-Available"
              size="small"
              variant="outlined"
              error={formValidation.availableError}
              helperText={formValidation.availableError}
              sx={{ backgroundColor: "white" }}
              value={roomData.available}
              onChange={(e) => {
                setroomData({ ...roomData, available: e.target.value });
              }}
            />
          </Grid>
          <Grid item md={6}></Grid>
          <Grid item md={6}>
            <Button
              onClick={addRoom}
              variant="contained"
              color="success"
              size="medium"
              fullWidth
            >
              Add Room
            </Button>
          </Grid>
        </Grid>
      </div>
    </div>
  );
};

export default AddRoom;
