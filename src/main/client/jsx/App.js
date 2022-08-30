import React from "react"
import Header from "./components/Layout/Candidates/Header";
import Candidates from "./pages/Candidates";
import { Redirect, Route, Switch } from "react-router-dom";
import Welcome from "./pages/Welcome";
import Candidate from "./pages/Candidate";

function App() {
  return (
    <React.Fragment>
      <Header/>
      <main>
        <Switch>
          <Route path="/" exact>
            <Redirect to="/welcome"/>
          </Route>
          <Route path="/welcome">
            <Welcome/>
          </Route>
          <Route path="/candidate" exact>
            <Candidates/>
          </Route>
          <Route path="/candidate/:candidateId">
            <Candidate/>
          </Route>
        </Switch>
      </main>
    </React.Fragment>
);
}

export default App;
