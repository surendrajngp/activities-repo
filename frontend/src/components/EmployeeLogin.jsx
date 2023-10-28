import React, { useState } from "react";
import { login } from "../services/EmployeeService";
import { Link, redirect, useNavigate } from "react-router-dom";

const EmployeeLogin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const loginSubmit = (event) => {
    event.preventDefault();

    login({ email, password })
      .then((response) => {
        localStorage.setItem("employee", JSON.stringify(response.data));
        navigate("/EmployeeDashboard");
      })
      .catch((error) => {
        if (error.response.data) {
          setErrorMessage(error.response.data.message);
        } else {
          setErrorMessage("Something went wrong");
        }
      });
  };
  return (
    <div className="container">
      <form
        className="w-50 mx-auto mt-5 bg-dark p-4 rounded"
        onSubmit={loginSubmit}
      >
        <div className="mb-3">
          <label for="exampleInputEmail1" className="form-label text-white">
            Email address
          </label>
          <input
            type="email"
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            value={email}
            onChange={(event) => setEmail(event.target.value)}
            required
          />
          <div id="emailHelp" className="form-text text-white">
            We'll never share your email with anyone else.
          </div>
        </div>
        <div className="mb-3">
          <label for="exampleInputPassword1" className="form-label text-white">
            Password
          </label>
          <input
            type="password"
            className="form-control"
            id="exampleInputPassword1"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
            required
          />
        </div>
        <div id="errorMsg" className="form-text text-danger">
          {errorMessage}
        </div>
        <button type="submit" className="btn btn-primary mt-2">
          Submit
        </button>
      </form>
    </div>
  );
};

export default EmployeeLogin;
