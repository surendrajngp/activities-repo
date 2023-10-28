import React, { useState } from "react";
import { getAllLoanApplications, getAppliedLoans } from "../services/LoanService";

const ViewLoanApplications = () => {
  const [appliedLoans, setAppliedLoans] = useState([]);

  useState(() => {
    getAllLoanApplications().then((response) => {
      setAppliedLoans(response.data);
    });
  }, []);
  return (
    <table className="table table-dark">
      <thead>
        <tr>
          <th scope="col">Application No.</th>
          <th scope="col">Customer Id</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
        {appliedLoans.map((item, index) => {
          return (
            <tr key={index}>
              <th scope="row">{item.applicationId}</th>
              <td>{item.customerId}</td>
              <td>{item.status}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};

export default ViewLoanApplications;
