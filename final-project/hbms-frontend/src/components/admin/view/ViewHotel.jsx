import React, { useEffect, useState } from "react";
import {
  viewAllHotelAPI,
  deleteHotelAPI,
} from "../../../Services/HotelService";
import {
  TableContainer,
  Paper,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Button,
} from "@mui/material";
import DeleteRoundedIcon from "@mui/icons-material/DeleteRounded";
import BorderColorRounded from "@mui/icons-material/BorderColorRounded";
import { useNavigate } from "react-router-dom";

const ViewHotel = () => {
  let navigate = useNavigate();
  const [hotelList, setHotelList] = useState([]);
  async function getAllHotel() {
    await viewAllHotelAPI()
      .then((resp) => {
        setHotelList(resp.data);
        console.log(resp.data[0].roomDetailsList.length);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getAllHotel();
  }, []);

  async function deleteHotel(id) {
    await deleteHotelAPI(id)
      .then((resp) => {
        if (resp.status === 200 || resp.status === 201) {
          navigate("/admin_dashboard");
        }
      })
      .catch((error) => console.log(error.response.data));
  }

  return (
    <div>
      View Hotel
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 1000 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Hotel ID</TableCell>
              <TableCell align="left">Hotel-name</TableCell>
              <TableCell align="left">City</TableCell>
              <TableCell align="left">Address</TableCell>
              <TableCell align="left">Description</TableCell>
              <TableCell align="left">email</TableCell>
              <TableCell align="left"># Rooms</TableCell>
              
              
              <TableCell align="center">Update Hotel</TableCell>

              <TableCell align="center">Delete-Hotel</TableCell>
              
            </TableRow>
          </TableHead>
          <TableBody>
            {hotelList.map((row) => (
              <TableRow
                key={row.booking_id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell align="left">{row.hotel_id}</TableCell>
                <TableCell align="left">{row.hotel_name}</TableCell>
                <TableCell align="left">{row.city}</TableCell>
                <TableCell align="left">{row.address}</TableCell>
                <TableCell align="left">{row.description}</TableCell>
                <TableCell align="left">{row.email}</TableCell>
                <TableCell align="left">{row.roomDetailsList.length}</TableCell>
                
                  <TableCell align="center">
                  <Button
                    onClick={(e) => {
                      localStorage.setItem("update-hotel", JSON.stringify(row));
                      navigate("/admin_dashboard/update_hotel/" + row.hotel_id);
                    }}
                    color={"warning"}
                  >
                    <BorderColorRounded />
                  </Button>
                  </TableCell>
                  <TableCell align="center">
                  <Button
                    color={"error"}
                    onClick={(e) => {
                      deleteHotel(row.hotel_id);
                    }}
                  >
                    <DeleteRoundedIcon />
                  </Button>
                  </TableCell>
                  
                
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default ViewHotel;
