import React, { useEffect, useState } from "react";
import { viewAllUserAPI, deleteUserAPI } from "../../../Services/UserService";
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

const ViewUser = () => {
  let navigate = useNavigate();
  const [userList, setUserList] = useState([]);
  async function getAllUser() {
    await viewAllUserAPI()
      .then((resp) => {
        setUserList(resp.data);
      })
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    getAllUser();
  }, []);

  async function deleteUser(id) {
    await deleteUserAPI(id)
      .then((resp) => {
        if (resp.status === 200 || resp.status === 201) {
          navigate("/admin_dashboard");
        }
      })
      .catch((error) => console.log(error.response.data));
  }

  return (
    <div>
      View User
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 1000 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>User ID</TableCell>
              <TableCell align="left">User-name</TableCell>
              <TableCell align="left">Address</TableCell>
              <TableCell align="left">Email</TableCell>
              <TableCell align="left">Mobile</TableCell>
              <TableCell align="left">Role</TableCell>
              <TableCell align="center">Delete-User</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {userList.map((row) => (
              <TableRow
                key={row.booking_id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell align="left">{row.user_id}</TableCell>
                <TableCell align="left">{row.user_name}</TableCell>
                <TableCell align="left">{row.address}</TableCell>
                <TableCell align="left">{row.email}</TableCell>
                <TableCell align="left">{row.mobile}</TableCell>
                <TableCell align="left">{row.role}</TableCell>
                <TableCell align="center">
                  <Button
                    color={"error"}
                    onClick={(e) => deleteUser(row.user_id)}
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

export default ViewUser;
