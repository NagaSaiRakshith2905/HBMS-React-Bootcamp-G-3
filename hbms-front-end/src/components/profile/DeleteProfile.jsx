import React from "react";
import { Grid, Button, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { deleteUserAPI } from "../../Services/UserService";
const DeleteProfile = () => {
  let navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem("User-Data"));
  async function deleteUser(id) {
    await deleteUser(id).then((resp) => {
      if (resp.status === 200 || resp.status === 201) {
        alert("User deleted");
        navigate("/");
      }
    });
  }
  return (
    <Grid container rowSpacing={3} columnSpacing={1}>
      <Grid item md={12}>
        <Typography variant="h5">
          Are you sure to delete the profile?
        </Typography>
      </Grid>
      <Grid item md={12}>
        <Typography variant={"body1"}>
          All your <u>booking details</u> will be <u>deleted</u> along with your{" "}
          <u>Profile</u>.
        </Typography>
      </Grid>
      <Grid item md={2}>
        <Button
          variant={"text"}
          color={"info"}
          size={"small"}
          onClick={(e) => navigate("/profile/view")}
        >
          cancel
        </Button>
      </Grid>
      <Grid item md={2}>
        <Button variant={"contained"} color={"error"} size={"small"}>
          delete
        </Button>
      </Grid>
    </Grid>
  );
};

export default DeleteProfile;
