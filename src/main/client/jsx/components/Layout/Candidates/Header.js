import React from "react";
import { Link, NavLink } from "react-router-dom";
import classes from "./Header.module.css"

const Header = () => {
    return (
        <header className={classes['main-header']}>
            <div>
                <Link to="/welcome" className={classes['main-header__brand']}>
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

    // <header class="main-header">
    //     <div>
    //         <a class="main-header__brand" href="index.html">
    //             uHost
    //         </a>
    //     </div>
    //     <nav class="main-nav">
    //         <ul class="main-nav__items">
    //             <li class="main-nav__item">
    //                 <a href="packages/index.html">Packages</a>
    //             </li>
    //             <li class="main-nav__item">
    //                 <a href="customers/index.html">Customers</a>
    //             </li>
    //             <li class="main-nav__item main-nav__item--cta">
    //                 <a href="start-hosting/index.html">Start Hosting</a>
    //             </li>
    //         </ul>
    //     </nav>
    // </header>
