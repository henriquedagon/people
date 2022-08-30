import React from "react";
import Header from "./Candidates/Header";

const Layout = (props) => {
    return (
        <React.Fragment>
            <Header/>
            <main>{props.children}</main>
        </React.Fragment>
    )
}

export default Layout