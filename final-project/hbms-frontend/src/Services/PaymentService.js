import { base_url } from "../util/Constants";

import axios from "axios";

export function maketransactionAPI(transactions) {
  let url = base_url + "transaction/make_transaction/";

  return axios.post(url, JSON.stringify(transactions), {
    mode: "no-cors",

    headers: {
      "Access-Control-Allow-Origin": "*",

      "Content-Type": "application/json",
    },
  });
}

export function viewPaymentAPI(id) {
  let url = base_url + "transaction/view_payment/?payment_id=" + id;

  return axios.get(url, {
    mode: "no-cors",

    headers: {
      "Access-Control-Allow-Origin": "*",

      "Content-Type": "application/json",
    },
  });
}

export function viewAllPaymentAPI() {
  let url = base_url + "transaction/view_all_payment/";
  return axios.get(url, {
    mode: "no-cors",
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Content-Type": "application/json",
    },
  });
}
