import React, { useEffect, useState } from "react";
import { Link, Route, Routes } from "react-router-dom";
import ViewAvailableLoans from "./ViewAvailableLoans";
import ApplyLoan from "./ApplyLoan";
import ViewLoanStatus from "./ViewLoanStatus";

const SuccessDashboard = () => {
  const [customerData, setCustomerData] = useState({});

  useEffect(() => {
    const customer = JSON.parse(localStorage.getItem("customer"));
    setCustomerData(customer);
  }, []);
  return (
    <div className="row">
      <div className="col">
        <h1 className="text-success text-center">Welcome</h1>
        <h2 className="text-danger text-center">
          {customerData.firstname + " " + customerData.lastname}
        </h2>
      </div>
      <div className="col">
        <Link to="view-loans"> View Loans </Link>
        &nbsp;
        <Link to="apply-loan"> Apply For Loan</Link>
        &nbsp;
        <Link to="loan-status"> See Loan Status</Link>
        &nbsp;
        <div className="mb-3"></div>
        <Routes>
          <Route path="view-loans" element={<ViewAvailableLoans />} />
          <Route path="apply-loan" element={<ApplyLoan />} />
          <Route path="loan-status" element={<ViewLoanStatus />} />
        </Routes>
      </div>
    </div>
  );
};

export default SuccessDashboard;
