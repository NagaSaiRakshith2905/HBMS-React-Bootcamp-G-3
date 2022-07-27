import React, { useEffect, useState } from "react";
import {
  viewAllRoomAPI,
  deleteRoomAPI,
} from "../../../Services/RoomManagementService";
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

const ViewRoom = () => {
  let navigate = useNavigate();
  const [roomList, setRoomList] = useState([]);
  async function getAllRoom() {
    await viewAllRoomAPI()
      .then((resp) => {
        setRoomList(resp.data);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getAllRoom();
  }, []);
  async function deleteRoom(id) {
    await deleteRoomAPI(id)
      .then((resp) => {
        if (resp.status === 200 || resp.status === 201) {
          navigate("/admin_dashboard");
        }
      })
      .catch((error) => console.log(error.response.data));
  }

  return (
    <div>
      View Room
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 1000 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Room ID</TableCell>
              <TableCell align="left">Room-Number</TableCell>
              <TableCell align="left">Room-Type</TableCell>
              <TableCell align="left">Rate-Per-Day</TableCell>
              <TableCell align="left">Available</TableCell>
              <TableCell align="left">Update Room</TableCell>
              <TableCell align="center">Delete-Room</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {roomList.map((row) => (
              <TableRow
                key={row.booking_id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell align="left">{row.room_id}</TableCell>
                <TableCell align="left">{row.room_no}</TableCell>
                <TableCell align="left">{row.room_type}</TableCell>
                <TableCell align="left">{row.rate_per_day}</TableCell>
                
                <TableCell align="left">
                  {row.available ? "Yes" : "No"}
                </TableCell>
                <TableCell align="center">
                  <Button
                    onClick={(e) => {
                      localStorage.setItem("update-room", JSON.stringify(row));
                      navigate("/admin_dashboard/update_room/" + row.room_id);
                    }}
                    color={"warning"}
                  >
                    <BorderColorRounded />
                  </Button>
                  </TableCell>
                <TableCell align="center">
                  <Button
                    color={"error"}
                    onClick={(e) => deleteRoom(row.room_id)}
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

export default ViewRoom;
