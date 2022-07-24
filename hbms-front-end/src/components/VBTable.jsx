import React from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  IconButton,
  Button,
} from "@mui/material";

import DeleteRoundedIcon from "@mui/icons-material/DeleteRounded";
import BorderColorRoundedIcon from "@mui/icons-material/BorderColorRounded";

import { deleteBookingDetails } from "../Services/BookingDetailsService";
import { useNavigate } from "react-router-dom";

const VBTable = ({ bookingList }) => {
  let navigate = useNavigate();
  async function deleteBooking(e, id) {
    await deleteBookingDetails(id)
      .then((resp) => resp.status === 200 && alert("deleted successfully"))
      .catch((err) => console.log(err));
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Booking ID</TableCell>
            <TableCell align="left">From</TableCell>
            <TableCell align="left">To</TableCell>
            <TableCell align="left">Amount</TableCell>
            <TableCell align="left">No.of Rooms</TableCell>
            <TableCell align="center">Update Booking</TableCell>
            <TableCell align="center">Delete Booking</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {bookingList.map((row) => (
            <TableRow
              key={row.booking_id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="left">{row.booking_id}</TableCell>
              <TableCell align="left">{row.booked_from}</TableCell>
              <TableCell align="left">{row.booked_to}</TableCell>
              <TableCell align="left">{row.amount}</TableCell>
              <TableCell align="left">{row.roomDetails.length}</TableCell>
              <TableCell align="center">
                <Button
                  onClick={(e) => {
                    localStorage.setItem("update-booking", JSON.stringify(row));
                    navigate("/view_bookings/update/" + row.booking_id);
                  }}
                  color={"warning"}
                >
                  <BorderColorRoundedIcon />
                </Button>
              </TableCell>
              <TableCell align="center">
                <Button
                  onClick={(e) => {
                    deleteBooking(e, row.booking_id);
                  }}
                  color={"error"}
                >
                  <DeleteRoundedIcon />
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default VBTable;
