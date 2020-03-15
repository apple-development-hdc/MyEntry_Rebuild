import React, {Component} from 'react';
import {Button} from "antd";
import {withRouter} from "react-router-dom";

class Home extends Component {

    componentDidMount() {
        console.log("in here");
    }

    render() {
        return (
            <div>
                <Button type="primary" />
                <Button type="primary" />
            </div>
        );
    }
}

export default withRouter(Home);
