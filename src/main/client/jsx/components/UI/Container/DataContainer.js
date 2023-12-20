import React from 'react'

import classes from "./DataContainer.module.css"

function DataContainer(props) {
  return (
    <div className={classes.container}>{props.children}</div>
  )
}

export default DataContainer