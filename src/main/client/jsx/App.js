import React from "react"
import Header from "./components/Layout/Candidates/Header";
import Candidates from "./pages/Candidates";
import { Redirect, Route } from "react-router-dom";
import Welcome from "./pages/Welcome";

function App() {
  return (
    <React.Fragment>
      <Header/>
      <main>
        <Route path="/" exact>
          <Redirect to="/welcome"/>
        </Route>
        <Route path="/welcome">
          <Welcome/>
        </Route>
        <Route path="/candidate">
          <Candidates/>
        </Route>
      </main>
    </React.Fragment>
);
}

export default App;
