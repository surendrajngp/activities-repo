import axios from "axios";

export const getAllLoans = async () => {
  return await axios
    .get("http://localhost:9091/api/availableLoans")
    .then((response) => response);
};

export const applyNewLoan = async (loanObj) => {
  return await axios
    .post("http://localhost:9091/api/applyLoan", loanObj)
    .then((response) => response);
};

export const getAppliedLoans = async (id) => {
  return await axios
    .get("http://localhost:9091/api/getAppliedLoans/" + id)
    .then((response) => response);
};

export const getAllLoanApplications = async () => {
  return await axios
    .get("http://localhost:9091/api/getAllLoanApplications")
    .then((response) => response);
};

export const updateApplication = async (obj) => {
  return axios
    .post("http://localhost:9091/api/updateLoanApplication", obj)
    .then((response) => response);
};
