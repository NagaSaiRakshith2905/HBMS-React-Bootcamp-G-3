import axios from "axios";
import { base_url } from "../util/Constants";

export function addUserAPI(userData) {
  let url = base_url + "user/add_user/";
  return axios.post(url, JSON.stringify(userData), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewUserByIdAPI(id) {
  let url = base_url + "user/view_user/?user_id=" + id;
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewAllUserAPI() {
  let url = base_url + "user/view_allUsers/";
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function updateUserAPI(user) {
  let url = base_url + "user/update_user/";
  return axios.put(url, JSON.stringify(user), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function deleteUserAPI(id) {
  let url = base_url + "user/remove_user/?user_id=" + id;
  return axios.delete(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
