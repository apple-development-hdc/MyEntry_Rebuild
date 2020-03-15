import React, {Component} from 'react';
import {Button} from "antd";
import {withRouter} from "react-router-dom";

class LoginPage extends Component {

    handle = () => {
        this.props.history.push("/home");
    };
    render() {
        return (
            <div>
                <Button onClick={this.handle} />
            </div>
        );
    }
}

export default withRouter(LoginPage);
