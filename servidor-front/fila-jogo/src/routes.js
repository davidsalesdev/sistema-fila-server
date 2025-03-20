import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import FilaPage from "./pages/FilaPage";

const AppRoutes = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<FilaPage />} />
      </Routes>
    </Router>
  );
};

export default AppRoutes;
