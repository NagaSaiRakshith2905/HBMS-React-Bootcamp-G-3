import {
  TextField,
  Button,
  Stack,
  Typography,
  Divider,
  FormControlLabel,
  Checkbox,
  Grid,
} from "@mui/material";
import { useState } from "react";
import { adminLoginAPI, userLoginAPI } from "../../Services/LoginService";
import "./Login.css";
import Logo from "../../image/logo.svg";
import { NavLink, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [isAdmin, setIsAdmin] = useState(false);

  const [formValidation, setFormValidation] = useState({});

  const [authError, setAuthError] = useState("");

  async function login() {
    let error = {};
    if (!username) {
      error["usernameError"] = isAdmin
        ? "admin-name can't be empty"
        : "user-name can't be empty";
    }
    if (!password) {
      error["passwordError"] = "password can't be empty";
    }
    setFormValidation(error);
    const length = Object.keys(error).length;
    if (length === 0) {
      !isAdmin
        ? await userLoginAPI(username, password)
            .then((resp) => {
              if (resp.status === 200 || resp.status === 201) {
                localStorage.setItem("User-Data", JSON.stringify(resp.data));
                navigate("/search_hotel");
              }
            })
            .catch((error) => setAuthError(error.response.data))
        : await adminLoginAPI(username, password)
            .then((resp) => {
              if (resp.status === 200 || resp.status === 201) {
                localStorage.setItem("Admin-Data", JSON.stringify(resp.data));
                navigate("/admin_dashboard");
              }
            })
            .catch((error) => setAuthError(error.response.data));
    }
  }

  return (
    <div className="login">
      <div className="logo">
        <a href="/">
          <img src={Logo} alt="" />
        </a>
      </div>
      <h1>LOGIN</h1>
      <div className="login-cont">
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
            <Grid item md={12}>
              <TextField
                fullWidth
                label={isAdmin ? "admin-name" : "user-name"}
                size="small"
                variant="outlined"
                error={formValidation.usernameError}
                helperText={formValidation.usernameError}
                sx={{ backgroundColor: "white" }}
                value={username}
                onChange={(e) => {
                  setUsername(e.target.value);
                }}
              />
            </Grid>
            <Grid item md={12}>
              <TextField
                fullWidth
                label="password"
                size="small"
                sx={{ backgroundColor: "white" }}
                variant="outlined"
                error={formValidation.usernameError}
                helperText={formValidation.usernameError}
                type={"password"}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Grid>
            <Grid item md={4}>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={isAdmin}
                    size={"small"}
                    color={"warning"}
                    onChange={(e) => {
                      setIsAdmin(e.target.checked);
                    }}
                  />
                }
                label="Admin"
              />
            </Grid>
            <Grid item md={8}></Grid>
            <Grid item md={5}>
              <NavLink to={"/register"}>
                <Button variant={"outlined"} fullWidth color={"info"}>
                  register
                </Button>
              </NavLink>
            </Grid>
            <Grid item md={2}></Grid>
            <Grid item md={5}>
              <Button
                fullWidth
                variant={"contained"}
                onClick={login}
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

export default Login;
