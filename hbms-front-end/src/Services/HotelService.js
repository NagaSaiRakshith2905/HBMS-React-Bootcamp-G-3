import { base_url } from "../util/Constants";

import axios from "axios";

export function addHotelAPI(hotelDetails) {
  let url = base_url + "hotel/add_hotel/";

  return axios.post(url, JSON.stringify(hotelDetails), {
    mode: "no-cors",

    headers: {
      "Access-Control-Allow-Origin": "*",

      "Content-Type": "application/json",
    },
  });
}

export function viewHotelAPI(id) {
  let url = base_url + "hotel/view_hotel/?hotel_id=" + id;

  return axios.get(url, {
    mode: "no-cors",

    headers: {
      "Access-Control-Allow-Origin": "*",

      "Content-Type": "application/json",
    },
  });
}

export function viewAllHotelAPI() {
  let url = base_url + "hotel/view_all/";
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function deleteHotelAPI(id) {
  let url = base_url + "hotel/remove_hotel/?hotel_id=" + id;
  return axios.delete(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function updateHotelAPI(hotelDetails) {
  let url = base_url + "hotel/update_hotel/";
  return axios.put(url, JSON.stringify(hotelDetails), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
