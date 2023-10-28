import React, { useEffect, useState } from "react";
import { applyNewLoan, getAllLoans } from "../services/LoanService";
import { useNavigate } from "react-router-dom";
const ApplyLoan = () => {
  const [loans, setLoans] = useState([]);
  const [loadId, setLoanId] = useState(1);

  useEffect(() => {
    getAllLoans().then((response) => {
      console.log("Resp - ", response.data);
      setLoans(response.data);
    });
  }, []);
  const navigate = useNavigate();
  const applyLoan = (event) => {
    event.preventDefault();
    const customer = JSON.parse(localStorage.getItem("customer"));
    applyNewLoan({
      customerId: customer.customerId,
      loanId: loadId,
      status: "Pending",
    })
      .then((response) => {
        window.alert("Loan Appplied Successfully");
      })
      .catch((error) => {
        window.alert("Loan Appplied Successfully");
      });
  };
  return (
    <div className="mt-3">
      <form onSubmit={applyLoan}>
        <div class="form-group col-md-4">
          <label for="inputState">Select Loan To Apply</label>
          <select
            id="inputState"
            class="form-control"
            required
            onChange={(event) => {
              setLoanId(event.target.value);
            }}
            value={loadId}
          >
            <option selected disabled>
              Choose...
            </option>
            {loans.map((item, index) => (
              <option key={index} value={item.loanId}>
                {item.loanType}
              </option>
            ))}
          </select>
        </div>
        <button type="submit" className="btn btn-primary mt-2">
          Submit
        </button>
      </form>
    </div>
  );
};

export default ApplyLoan;
