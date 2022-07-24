import React, { useEffect, useState } from "react";
import {
  viewAllBookingDetails,
  deleteBookingDetails,
} from "../../../Services/BookingDetailsService";
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
import { useNavigate } from "react-router-dom";

const ViewBooking = () => {
  let navigate = useNavigate();
  const [bookingList, setBookingList] = useState([]);
  async function getAllBooking() {
    await viewAllBookingDetails()
      .then((resp) => {
        setBookingList(resp.data);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getAllBooking();
  }, []);

  async function deleteBooking(id) {
    await deleteBookingDetails(id)
      .then((resp) => {
        if (resp.status === 200 || resp.status === 201) {
          navigate("/admin_dashboard");
        }
      })
      .catch((error) => console.log(error.response.data));
  }

  return (
    <div>
      View Booking
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 1000 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Booking ID</TableCell>
              <TableCell align="left">From</TableCell>
              <TableCell align="left">To</TableCell>
              <TableCell align="left">No.of Adults</TableCell>
              <TableCell align="left">No.of Childrens</TableCell>
              <TableCell align="left">Amount</TableCell>
              <TableCell align="left">No.of Rooms</TableCell>
              <TableCell align="center">Delete-Booking</TableCell>
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
                <TableCell align="left">{row.no_of_adults}</TableCell>
                <TableCell align="left">{row.no_of_children}</TableCell>
                <TableCell align="left">{row.amount}</TableCell>
                <TableCell align="left">{row.roomDetails.length}</TableCell>
                <TableCell align="center">
                  <Button
                    color={"error"}
                    onClick={(e) => deleteBooking(row.booking_id)}
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

export default ViewBooking;
