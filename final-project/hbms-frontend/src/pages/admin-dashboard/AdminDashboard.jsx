import React from "react";
import Logo from "../../image/logo.svg";
import "./dashboard.css";
import PageNotFound from "../../components/page-not-found/PageNotFound";
import { Grid, Button } from "@mui/material";
import { useNavigate, Outlet } from "react-router-dom";

const AdminDashboard = () => {
  let navigate = useNavigate();
  const admin = localStorage.getItem("Admin-Data");
  function logout() {
    if (admin !== null) {
      localStorage.removeItem("Admin-Data");
      navigate("/");
    }
  }

  return (
    <>
      {admin === null ? (
        <PageNotFound />
      ) : (
        <div className="dashboard">
          <div className="nav-bar">
            <img src={Logo} alt="" />
          </div>
          <div className="container">
            <Grid container rowSpacing={1} columnSpacing={2}>
              {/* view */}
              <>
                <Grid item md={10}>
                  <div
                    style={{ cursor: "pointer" }}
                    onClick={(e) => navigate("/admin_dashboard")}
                  >
                    Admin-Dashboard
                  </div>
                </Grid>
                <Grid item md={2}>
                  <Button
                    style={{
                      textTransform: "capitalize",
                      background: "var(--orange)",
                      borderRadius: "16px",
                      height: "24px",
                      boxShadow: "none",
                      padding: "0 16px",
                      fontSize: "12px",
                    }}
                    variant={"contained"}
                    size={"small"}
                    color={"warning"}
                    onClick={logout}
                  >
                    Logout
                  </Button>
                </Grid>
                <Grid item md={12}>
                  -View
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"primary"}
                    onClick={(e) => navigate("/admin_dashboard/view_user")}
                  >
                    Users
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"primary"}
                    onClick={(e) => navigate("/admin_dashboard/view_hotel")}
                  >
                    Hotels
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"primary"}
                    onClick={(e) => navigate("/admin_dashboard/view_room")}
                  >
                    Rooms
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"primary"}
                    onClick={(e) => navigate("/admin_dashboard/view_booking")}
                  >
                    Bookings
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"primary"}
                    onClick={(e) => navigate("/admin_dashboard/view_payment")}
                  >
                    Payments
                  </Button>
                </Grid>
              </>
              {/* add */}
              <>
                <Grid item md={12}>
                  -add
                </Grid>
                <Grid item md={2}>
                  <Button
                    onClick={(e) => navigate("/admin_dashboard/add_hotel")}
                    fullWidth
                    variant={"contained"}
                    color={"success"}
                  >
                    Hotels
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    onClick={(e) => navigate("/admin_dashboard/add_room")}
                    fullWidth
                    variant={"contained"}
                    color={"success"}
                  >
                    Rooms
                  </Button>
                </Grid>
              </>
              {/* update */}
              <>
                <Grid item md={12}>
                  -update
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"warning"}
                    onClick={(e) => navigate("/admin_dashboard/update_hotel")}
                  >
                    Hotel
                  </Button>
                </Grid>
                <Grid item md={2}>
                  <Button
                    fullWidth
                    variant={"contained"}
                    color={"warning"}
                    onClick={(e) => navigate("/admin_dashboard/update_room")}
                  >
                    Room
                  </Button>
                </Grid>
              </>
            </Grid>
          </div>
          <div className="dashboard-cont">
            <div className="data">
              <Outlet />
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default AdminDashboard;
