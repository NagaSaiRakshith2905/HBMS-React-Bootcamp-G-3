import "./App.css";
import NavBar from "./components/NavBar/NavBar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import SearchHotel from "./pages/Search-Hotel/SearchHotel";
import ViewBooking from "./pages/View-bookings/ViewBookings";
import Profile from "./pages/Profile/Profile";

function App() {
  return (
    <Router>
      <div className="App">
        <NavBar />

        <Routes>
          <Route exact
            path="/" element={<SearchHotel />} />
          <Route  exact
            path="/view_bookings" element={<ViewBooking />} />
          <Route  exact
            path="/profile" element={<Profile />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
