import axios from "axios";

export const login = async (userObj) => {
  return await axios
    .post("http://localhost:9091/api/employee/login", userObj)
    .then((response) => response);
};
