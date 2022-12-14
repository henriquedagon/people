import React from "react"
import Candidates from "./pages/Candidates";
import { Redirect, Route, Switch } from "react-router-dom";
import Welcome from "./pages/Welcome";
import Candidate from "./pages/Candidate";
import Layout from "./components/Layout/Layout";
import NotFound from "./pages/NotFound";

function App() {
  return (
    <Layout>
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
        <Route path="*">
          <NotFound/>
        </Route>
      </Switch>
    </Layout>
  );
}

export default App;
