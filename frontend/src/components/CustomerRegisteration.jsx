import React, { useState } from "react";
import { register } from "../services/CustomerService";
import { useNavigate } from "react-router-dom";

const CustomerRegisteration = () => {
  const [firstname, setFirstName] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phone, setPhone] = useState("");
  const [pan, setPan] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const loginSubmit = (event) => {
    event.preventDefault();

    register({ firstname, lastname, email, password, phone, pan })
      .then((response) => {
        console.log("Response: ", response.data);
        navigate("/customer");
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
          <label for="firstname" className="form-label text-white">
            Firstname
          </label>
          <input
            type="text"
            className="form-control"
            id="firstname"
            value={firstname}
            onChange={(event) => setFirstName(event.target.value)}
            required
            minLength={3}
          />
        </div>
        <div className="mb-3">
          <label for="lastname" className="form-label text-white">
            Lastname
          </label>
          <input
            type="text"
            className="form-control"
            id="lastname"
            value={lastname}
            onChange={(event) => setLastName(event.target.value)}
            required
            minLength={1}
          />
        </div>
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
        <div className="mb-3">
          <label for="firstname" className="form-label text-white">
            Phone
          </label>
          <input
            type="text"
            className="form-control"
            id="phone"
            value={phone}
            onChange={(event) => setPhone(event.target.value)}
            required
            minLength={10}
            maxLength={10}
          />
        </div>
        <div className="mb-3">
          <label for="firstname" className="form-label text-white">
            Pan Number
          </label>
          <input
            type="text"
            className="form-control"
            id="pan"
            value={pan}
            onChange={(event) => setPan(event.target.value)}
            required
          />
        </div>
        <div id="emailHelp" className="form-text text-danger">
          {errorMessage}
        </div>
        <button type="submit" className="btn btn-primary mt-2">
          Submit
        </button>
      </form>
    </div>
  );
};

export default CustomerRegisteration;
