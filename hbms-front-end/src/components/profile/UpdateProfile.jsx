import React, { useState } from "react";
import { Grid, Button, Typography, Divider, TextField } from "@mui/material";
import { updateUserAPI } from "../../Services/UserService";
import { useNavigate } from "react-router-dom";

const UpdateProfile = () => {
  const user = JSON.parse(localStorage.getItem("User-Data"));
  let navigate = useNavigate();
  const [userUpdate, setUserUpdate] = useState({
    user_id: user.user_id,
    user_name: user.user_name,
    email: user.email,
    password: user.password,
    role: user.role,
    mobile: user.mobile,
    address: user.address,
  });
  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function updateUser() {
    let error = {};
    if (!userUpdate.user_name) {
      error["usernameError"] = "user-name can't be empty";
    }
    if (!userUpdate.password) {
      error["passwordError"] = "password can't be empty";
    }
    if (!userUpdate.email) {
      error["emailError"] = "email can't be empty";
    }
    if (!userUpdate.mobile) {
      error["mobileError"] = "mobile number can't be empty";
    }
    if (userUpdate.mobile.length !== 10) {
      error["mobileError"] = "invalid mobile number";
    }
    if (!userUpdate.address) {
      error["addressError"] = "address can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await updateUserAPI(userUpdate)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            localStorage.removeItem("User-Data");
            localStorage.setItem("User-Data", JSON.parse(resp.data));
            navigate("/profile/view");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <Grid container rowSpacing={1} columnSpacing={2}>
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
          label="user-name"
          size="small"
          variant="outlined"
          error={formValidation.usernameError}
          helperText={formValidation.usernameError}
          sx={{ backgroundColor: "white" }}
          value={userUpdate.user_name}
          onChange={(e) => {
            setUserUpdate({ ...userUpdate, user_name: e.target.value });
          }}
        />
      </Grid>
      <Grid item md={6}>
        <TextField
          fullWidth
          label="password"
          size="small"
          variant="outlined"
          error={formValidation.passwordError}
          helperText={formValidation.passwordError}
          sx={{ backgroundColor: "white" }}
          value={userUpdate.password}
          onChange={(e) => {
            setUserUpdate({ ...userUpdate, password: e.target.value });
          }}
        />
      </Grid>
      <Grid item md={6}>
        <TextField
          fullWidth
          label="email"
          size="small"
          variant="outlined"
          error={formValidation.emailError}
          helperText={formValidation.emailError}
          sx={{ backgroundColor: "white" }}
          value={userUpdate.email}
          onChange={(e) => {
            setUserUpdate({ ...userUpdate, email: e.target.value });
          }}
        />
      </Grid>
      <Grid item md={6}>
        <TextField
          fullWidth
          label="mobile"
          size="small"
          variant="outlined"
          error={formValidation.mobileError}
          helperText={formValidation.mobileError}
          sx={{ backgroundColor: "white" }}
          value={userUpdate.mobile}
          onChange={(e) => {
            setUserUpdate({ ...userUpdate, mobile: e.target.value });
          }}
        />
      </Grid>

      <Grid item md={12}>
        <TextField
          label="address"
          size="small"
          fullWidth
          variant="outlined"
          error={formValidation.addressError}
          helperText={formValidation.addressError}
          sx={{ backgroundColor: "white" }}
          value={userUpdate.address}
          onChange={(e) => {
            setUserUpdate({ ...userUpdate, address: e.target.value });
          }}
        />
      </Grid>
      <Grid item md={8}></Grid>
      <Grid item md={4}>
        <Button
          fullWidth
          variant={"contained"}
          color={"warning"}
          onClick={updateUser}
        >
          continue
        </Button>
      </Grid>
    </Grid>
  );
};

export default UpdateProfile;
