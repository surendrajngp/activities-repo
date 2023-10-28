import axios from "axios";

export const login = async (userObj) => {
  return await axios
    .post("http://localhost:9091/api/customer/login", userObj)
    .then((response) => response);
};

export const register = async (customerObj) => {
  return await axios
    .post("http://localhost:9091/api/customer/register", customerObj)
    .then((response) => response);
};
