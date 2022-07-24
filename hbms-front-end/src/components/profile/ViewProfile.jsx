import React from "react";
import { Grid, Button, Typography, Divider } from "@mui/material";

const ViewProfile = () => {
  const user = JSON.parse(localStorage.getItem("User-Data"));
  return (
    <Grid container spacing={2}>
      <Grid item md={12}>
        <Typography variant="h5">User-Name: {user.user_name}</Typography>
      </Grid>
      <Grid item md={12}>
        <Typography variant={"body1"}>Email-Id: {user.email}</Typography>
      </Grid>
      <Grid item md={12}>
        <Typography variant={"body1"}>Mobile-Number: {user.mobile}</Typography>
      </Grid>
      <Grid item md={12}>
        <Typography variant={"body1"}>Address: {user.address}</Typography>
      </Grid>
    </Grid>
  );
};

export default ViewProfile;
