import axios from "axios";
import { base_url } from "../util/Constants";

export function userLoginAPI(username, password) {
  let url =
    base_url +
    "login/user_login/?user_name=" +
    username +
    "&password=" +
    password;
  return axios.post(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
export function adminLoginAPI(adminname, password) {
  let url =
    base_url +
    "login/admin_login/?admin_name=" +
    adminname +
    "&password=" +
    password;
  return axios.post(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
