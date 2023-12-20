import React from 'react'
import classes from "./PanelContainer.module.css"


function PanelContainer(props) {
    return (
        <div className={classes.container}>{props.children}</div>
    )
}

export default PanelContainer