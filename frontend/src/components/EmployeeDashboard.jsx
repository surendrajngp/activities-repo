import React, { useEffect, useState } from "react";
import { Link, Route, Routes } from "react-router-dom";
import ViewAvailableLoans from "./ViewAvailableLoans";
import ApplyLoan from "./ApplyLoan";
import ViewLoanStatus from "./ViewLoanStatus";
import ViewLoanApplications from "./ViewLoanApplications";
import UpdateLoanApplication from "./UpdateLoanApplication";

const EmployeeDashboard = () => {
  const [customerData, setCustomerData] = useState({});

  useEffect(() => {
    const employee = JSON.parse(localStorage.getItem("employee"));
    setCustomerData(employee);
  }, []);
  return (
    <div className="row">
      <div className="col">
        <h1 className="text-success text-center">Welcome</h1>
        <h2 className="text-danger text-center">
          {customerData.employeeName}
        </h2>
      </div>
      <div className="col">
        <Link to="view-loan-applications"> View Applications </Link>
        &nbsp;
        <Link to="update-loan-application"> Update Loan Application</Link>
        &nbsp;
        <Link to="loan-status"> View Credit Score</Link>
        &nbsp;
        <div className="mb-3"></div>
        <Routes>
          <Route path="view-loan-applications" element={<ViewLoanApplications />} />
          <Route path="update-loan-application" element={<UpdateLoanApplication />} />
          <Route path="loan-status" element={<ViewLoanStatus />} />
        </Routes>
      </div>
    </div>
  );
};

export default EmployeeDashboard;
