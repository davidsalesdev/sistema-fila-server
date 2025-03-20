import React from "react";

const Button = ({ onClick, children, disabled }) => {
  return (
    <button onClick={onClick} disabled={disabled} style={{ padding: "10px", margin: "10px" }}>
      {children}
    </button>
  );
};

export default Button;
