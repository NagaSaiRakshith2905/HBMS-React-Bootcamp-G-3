import { base_url } from "../util/AppConstants";
import axios from "axios";

export function userLogin(username,password,bookingDetails) {
    axios.post(base_url+"user_login/?user_name="+username+"&password="+password,JSON.stringify(bookingDetails));
}