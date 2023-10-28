import React, { useEffect, useState } from "react";
import { getAllLoans } from "../services/LoanService";

const ViewAvailableLoans = () => {
  const [loans, setLoans] = useState([]);

  useEffect(() => {
    getAllLoans().then((response) => {
      setLoans(response.data);
    });
  }, []);
  return (
    <table className="table table-dark">
      <thead>
        <tr>
          <th scope="col">Sr No.</th>
          <th scope="col">Loan Type</th>
        </tr>
      </thead>
      <tbody> 
        {loans.map((item, index) => {
          return (
            <tr key={index}>
              <th scope="row">{item.loanId}</th>
              <td>{item.loanType}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};

export default ViewAvailableLoans;
