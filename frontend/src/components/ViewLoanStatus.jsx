import React, { useState } from "react";
import { getAppliedLoans } from "../services/LoanService";

const ViewLoanStatus = () => {
  const [appliedLoans, setAppliedLoans] = useState([]);

  useState(() => {
    const customer = JSON.parse(localStorage.getItem("customer"));
    getAppliedLoans(customer.customerId).then((response) => {
      setAppliedLoans(response.data);
    });
  }, []);
  return (
    <table className="table table-dark">
      <thead>
        <tr>
          <th scope="col">Application No.</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        {appliedLoans.map((item, index) => {
          return (
            <tr key={index}>
              <th scope="row">{item.applicationId}</th>
              <td>{item.status}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};

export default ViewLoanStatus;
