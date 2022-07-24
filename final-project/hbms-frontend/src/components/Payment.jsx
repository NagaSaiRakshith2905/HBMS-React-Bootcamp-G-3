import { SendRounded } from "@mui/icons-material";
import { Backdrop, Fade, Modal, Typography } from "@mui/material";
import { Box } from "@mui/system";
import React, { useState } from "react";
import LoadingButton from "@mui/lab/LoadingButton";
import { maketransactionAPI } from "../Services/PaymentService";

import { useNavigate } from "react-router-dom";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "auto",
  height: "auto",
  padding: "16px",
  backgroundColor: "var(--bg-primary)",
  border: "1px solid var(--stroke)",
  borderRadius: "8px",
  p: 2,
};

const Payment = ({ open, setOpen, amount }) => {
  let navigate = useNavigate();
  const [loading, setLoading] = useState(false);
  const [sucess, setSucess] = useState(false);
  const booking = JSON.parse(localStorage.getItem("Booking-Data"));

  async function makePayment() {
    setLoading(true);
    const transaction = {
      amount: booking.amount,
      booking_id: booking.booking_id,
    };
    await maketransactionAPI(transaction)
      .then((resp) => {
        if (resp.status === 200 || resp.status === 201) {
          localStorage.removeItem("Booking-Data");
          setLoading(false);
          alert("payment sucess");
          setOpen(false);
          navigate("/view_bookings");
        }
      })
      .catch((err) => console.log(err));
  }
  return (
    <div>
      <Modal
        aria-labelledby="transition-modal-title"
        aria-describedby="transition-modal-description"
        open={open}
        onClose={(e) => setOpen(false)}
        closeAfterTransition
        BackdropComponent={Backdrop}
        BackdropProps={{
          timeout: 500,
        }}
      >
        <Fade in={open}>
          <Box sx={style}>
            <Typography id="transition-modal-title" variant="h5" component="h2">
              Payment:
            </Typography>
            <Typography id="transition-modal-title" variant="h6" component="h2">
              Cost : Rs{amount}/-
            </Typography>
            <LoadingButton
              size="large"
              fullWidth
              onClick={makePayment}
              endIcon={<SendRounded />}
              loading={loading}
              loadingPosition="end"
              variant="contained"
              color="success"
              style={{
                marginTop: "16px",
                backgroundColor: "var(--green)",
              }}
            >
              Confirm and Pay
            </LoadingButton>
          </Box>
        </Fade>
      </Modal>
    </div>
  );
};

export default Payment;
