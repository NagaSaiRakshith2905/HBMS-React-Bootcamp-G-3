import Login from "./pages/login/Login";
import Register from "./pages/register/Register";

import SearchHotel from "./pages/search-hotel/SearchHotel";

import ViewHotelByID from "./pages/view-hotel/ViewHotel";
import BookingRoom from "./pages/booking-room/BookingRoom";
import ViewMyBooking from "./pages/view-my-booking/ViewMyBooking";

import Profile from "./pages/profile/Profile";
import ViewProfile from "./components/profile/ViewProfile";
import UpdateProfile from "./components/profile/UpdateProfile";
import DeleteProfile from "./components/profile/DeleteProfile";

import AdminDashboard from "./pages/admin-dashboard/AdminDashboard";

import AddHotel from "./components/admin/add/AddHotel";
import AddRoom from "./components/admin/add/AddRoom";

import UpdateHotel from "./components/admin/update/UpdateHotel";
import UpdateRoom from "./components/admin/update/UpdateRoom";

import ViewUser from "./components/admin/view/ViewUser";
import ViewHotel from "./components/admin/view/ViewHotel";
import ViewRoom from "./components/admin/view/ViewRoom";
import ViewBooking from "./components/admin/view/ViewBooking";
import ViewPayment from "./components/admin/view/ViewPayment";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import VBUpdateBooking from "./components/VBUpdateBooking";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/register" element={<Register />} />
          <Route exact path="/search_hotel" element={<SearchHotel />} />
          <Route
            path="/search_hotel/view_hotel/id=:id"
            element={<ViewHotelByID />}
          />
          <Route
            path="/search_hotel/view_hotel/booking_room/id=:id&name=:name"
            element={<BookingRoom />}
          />
          <Route path="view_bookings" element={<ViewMyBooking />}>
            <Route path="update/:id" element={<VBUpdateBooking />} />
          </Route>
          <Route path="profile" element={<Profile />}>
            <Route path="view" element={<ViewProfile />} />
            <Route path="update" element={<UpdateProfile />} />
            <Route path="delete" element={<DeleteProfile />} />
          </Route>
          <Route path="admin_dashboard" element={<AdminDashboard />}>
            <Route path="add_hotel" element={<AddHotel />} />
            <Route path="add_room" element={<AddRoom />} />

            <Route path="update_hotel" element={<UpdateHotel />} />
            <Route path="update_room" element={<UpdateRoom />} />

            <Route path="view_user" element={<ViewUser />} />
            <Route path="view_hotel" element={<ViewHotel />} />
            <Route path="view_room" element={<ViewRoom />} />
            <Route path="view_booking" element={<ViewBooking />} />
            <Route path="view_payment" element={<ViewPayment />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
