import React, { useEffect, useState } from "react";
import { viewAllPaymentAPI } from "../../../Services/PaymentService";
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

const ViewPayment = () => {
  const [paymentList, setPaymentList] = useState([]);
  async function getAllPayments() {
    await viewAllPaymentAPI()
      .then((resp) => {
        setPaymentList(resp.data);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getAllPayments();
  }, []);
  return (
    <div>
      View Payment
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 1000 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Payment ID</TableCell>
              <TableCell align="left">Transaction ID</TableCell>
              <TableCell align="left">Booking ID</TableCell>
              <TableCell align="left">Amount</TableCell>
              <TableCell align="left">Transaction Date</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {paymentList.map((row) => (
              <TableRow
                key={row.booking_id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell align="left">{row.payment_id}</TableCell>
                <TableCell align="left">{row.transaction_id}</TableCell>
                <TableCell align="left">{row.booking_id}</TableCell>
                <TableCell align="left">{row.amount}</TableCell>
                <TableCell align="left">{row.transaction_date}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default ViewPayment;
