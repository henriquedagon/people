import React from "react";
import classes from "./Header.module.css"

const Header = props => {
    return (
        <header className={classes['main-header']}>
            <div>
                <h1>People</h1>
            </div>
        </header>
    )
}

export default Header 