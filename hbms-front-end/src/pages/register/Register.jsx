import React from "react";
import "./Register.css";
import Logo from "../../image/logo.svg";
import { NavLink, useNavigate } from "react-router-dom";
import { TextField, Button, Typography, Grid } from "@mui/material";
import { useState } from "react";
import { addUserAPI } from "../../Services/UserService";

const Register = () => {
  const navigate = useNavigate();

  const [userData, setUserData] = useState({
    user_name: "",
    password: "",
    email: "",
    mobile: "",
    address: "",
  });
  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function register() {
    let error = {};
    if (!userData.user_name) {
      error["usernameError"] = "user-name can't be empty";
    }
    if (!userData.password) {
      error["passwordError"] = "password can't be empty";
    }
    if (!userData.email) {
      error["emailError"] = "email can't be empty";
    }
    if (!userData.mobile) {
      error["mobileError"] = "mobile number can't be empty";
    }
    if (userData.mobile.length !== 10) {
      error["mobileError"] = "invalid mobile number";
    }
    if (!userData.address) {
      error["addressError"] = "address can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      await addUserAPI(userData)
        .then((resp) => {
          if (resp.status === 200 || resp.status === 201) {
            localStorage.setItem("User-Data", JSON.stringify(resp.data));
            navigate("/search_hotel");
          }
        })
        .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <div className="register">
      <div className="logo">
        <a href="/">
          <img src={Logo} alt="" />
        </a>
      </div>
      <h1>REGISTER</h1>
      <div className="register-cont">
        <div className="item">
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
                value={userData.user_name}
                onChange={(e) => {
                  setUserData({ ...userData, user_name: e.target.value });
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
                value={userData.password}
                onChange={(e) => {
                  setUserData({ ...userData, password: e.target.value });
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
                value={userData.email}
                onChange={(e) => {
                  setUserData({ ...userData, email: e.target.value });
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
                value={userData.mobile}
                onChange={(e) => {
                  setUserData({ ...userData, mobile: e.target.value });
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
                value={userData.address}
                onChange={(e) => {
                  setUserData({ ...userData, address: e.target.value });
                }}
              />
            </Grid>
            <Grid item md={5}>
              <NavLink to={"/"}>
                <Button variant={"outlined"} fullWidth color={"info"}>
                  login
                </Button>
              </NavLink>
            </Grid>
            <Grid item md={2}></Grid>
            <Grid item md={5}>
              <Button
                fullWidth
                variant={"contained"}
                onClick={register}
                color={"success"}
              >
                continue
              </Button>
            </Grid>
          </Grid>
        </div>
      </div>
    </div>
  );
};

export default Register;
