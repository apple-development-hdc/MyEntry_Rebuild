import React from "react";
import { MDBInput, MDBCol } from "mdbreact";
import { BrowserRouter as Router, withRouter } from "react-router-dom";
import {Button} from "antd";
import Swal from "sweetalert2";


class UserLogin extends React.Component {
    state = {
        userName: "",
        password: "",

    };
    componentDidMount() {

    }

    getLoginData = (value, type) =>
        this.setState({
            [type]: value
        });

    onFormSubmit=()=> {

        const { userName, password } = this.state;

        if (
            userName === "saurav" && password ==="saurav"
        ) {
            window.localStorage.setItem("user","true");
            this.props.history.push("/home/");
            window.localStorage.setItem("guard","false");

        }
        else if(userName === "apple" && password==="apple"){
            window.localStorage.setItem("guard","true");
            this.props.history.push("/home/");
            window.localStorage.setItem("user","false");
        }
        else {
         Swal.fire(
             'Retry',
             'Wrong Credentials',
             'error'
         )
        }


    };
    render() {
        return (
            <Router>
                <MDBCol size="3">
                    <form onSubmit={this.onFormSubmit}>
                        <p className="h5 text-center mb-4">Sign in</p>
                        <div className="grey-text">
                            <MDBInput
                                label="Type your email"
                                icon="envelope"
                                group
                                type="text"
                                validate
                                error="wrong"
                                success="right"
                                getValue={value => this.getLoginData(value, "userName")}
                            />
                            <MDBInput
                                label="Type your password"
                                icon="lock"
                                group
                                type="password"
                                validate
                                getValue={value => this.getLoginData(value, "password")}
                            />
                        </div>
                        <div className="text-center">
                            <Button type="primary" onClick={this.onFormSubmit}>
                                Login
                            </Button>
                        </div>
                    </form>
                </MDBCol>
            </Router>
        );
    }
}

export default withRouter(UserLogin);
