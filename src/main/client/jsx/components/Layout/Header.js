import React from "react";
import { Link, NavLink } from "react-router-dom";
import classes from "./Header.module.css"

const Header = () => {
    return (
        <header className={classes['main-header']}>
            <div className={classes['main-header__brand']}>
                <Link to="/welcome">
                    <h1>People</h1>
                </Link>
            </div>
            <ul>
                <li>
                    <NavLink to="/candidate">Candidates</NavLink>
                </li>
            </ul>
        </header>
    )
}

export default Header 