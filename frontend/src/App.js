import logo from "./logo.svg";
import "./App.css";
import Navbar from "./components/Navbar";
import { Route, Routes } from "react-router-dom";
import CustomerLogin from "./components/CustomerLogin";
import CustomerRegisteration from "./components/CustomerRegisteration";
import SuccessDashboard from "./components/SuccessDashboard";
import EmployeeLogin from "./components/EmployeeLogin";
import EmployeeDashboard from "./components/EmployeeDashboard";

function App() {
  return (
    <>
      <Navbar />
      <div style={{ marginTop: "80px" }}>
        <Routes>
          <Route extact path="/customer/*" element={<CustomerLogin />} />
          <Route path="/registration" element={<CustomerRegisteration />} />
          <Route path="/dashboard/*" element={<SuccessDashboard />} />
          <Route path="/employeeLogin" element={<EmployeeLogin />} />
          <Route path="/employeeDashboard/*"  element={<EmployeeDashboard />} />
        </Routes>
      </div>
    </>
  );
}

export default App;
