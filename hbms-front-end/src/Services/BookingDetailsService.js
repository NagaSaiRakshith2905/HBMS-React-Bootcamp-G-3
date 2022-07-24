import { base_url } from "../util/Constants";
import axios from "axios";

export function addBookingDetails(bookingDetails) {
  let url = base_url + "booking/add_booking_details/";
  return axios.post(url, JSON.stringify(bookingDetails), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewBookingDetails(id) {
  let url = base_url + "booking/view_booking_details/?booking_id=" + id;
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function viewAllBookingDetails() {
  let url = base_url + "booking/view_all_booking_details/";
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function deleteBookingDetails(id) {
  let url = base_url + "booking/remove_booking_details/?booking_id=" + id;
  return axios.delete(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}

export function updateBookingDetails(bookingDetails) {
  let url = base_url + "booking/update_booking_details/";
  return axios.put(url, JSON.stringify(bookingDetails), {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
