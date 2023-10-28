import React, { useEffect, useState } from "react";
import {
  applyNewLoan,
  getAllLoanApplications,
  getAllLoans,
  getAppliedLoans,
  updateApplication,
} from "../services/LoanService";
import { useNavigate } from "react-router-dom";

const UpdateLoanApplication = () => {
  const [loans, setLoans] = useState([]);
  const [applicationId, setApplicationId] = useState(1);
  const [status, setStatus] = useState("");

  useEffect(() => {
    getAllLoanApplications().then((response) => {
      setLoans(response.data);
    });
  }, []);

  const applyLoan = (event) => {
    event.preventDefault();
    // const customer = JSON.parse(localStorage.getItem("customer"));
    const obj = loans.find((l) => l.applicationId == applicationId);
    obj.status = status;
    updateApplication(obj)
      .then((response) => {
        window.alert("Application Update Successfully");
      })
      .catch((error) => {
        window.alert("Application Updation Failed");
      });
  };
  return (
    <div className="mt-3">
      <form onSubmit={applyLoan}>
        <div class="form-group col-md-4">
          <label for="inputState">Select Application Id</label>
          <select
            id="inputState"
            class="form-control"
            required
            onChange={(event) => {
              setApplicationId(event.target.value);
            }}
            value={applicationId}
          >
            <option selected disabled>
              Choose...
            </option>
            {loans.map((item, index) => (
              <option key={index} value={item.applicationId}>
                {item.applicationId}
              </option>
            ))}
          </select>
        </div>

        <div class="form-group col-md-4">
          <label for="inputState">Select Status</label>
          <select
            id="inputState"
            class="form-control"
            required
            onChange={(event) => {
              setStatus(event.target.value);
            }}
            value={status}
          >
            <option selected disabled>
              Choose...
            </option>
            <option value="Approved">Approved</option>
            <option value="Rejected">Rejected</option>
          </select>
        </div>
        <button type="submit" className="btn btn-primary mt-2">
          Submit
        </button>
      </form>
    </div>
  );
};

export default UpdateLoanApplication;
