import { base_url } from "../util/Constants";
import axios from "axios";

export function addRoomAPI(roomDetails) {
  let url = base_url + "room/add_room/";
  return axios.post(url, JSON.stringify(roomDetails), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewRoomAPI(id) {
  let url = base_url + "room/view_room_details/?roomDetails_id=" + id;
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewAllRoomAPI() {
  let url = base_url + "room/view_all_room_details/";
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function deleteRoomAPI(id) {
  let url = base_url + "room/remove_room_details/?roomDetails_id=" + id;
  return axios.delete(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function updateRoomAPI(roomDetails) {
  let url = base_url + "room/update_room_details/";
  return axios.put(url, JSON.stringify(roomDetails), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
