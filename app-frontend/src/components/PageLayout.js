import React, {Component} from 'react';
import { Menu } from 'antd';
import {
    AppleOutlined,

} from '@ant-design/icons';
import {withRouter} from "react-router-dom";

const { SubMenu } = Menu;

class PageLayout extends Component {


    componentDidMount() {
        console.log(window.location.pathname);
        let p = window.location.pathname;
        // api call 
        if(p === "/home/" || p === "/home") {
            let valid = localStorage.getItem("is_valid");
            console.log(valid);
            if(valid === "false") {
                console.log("upda");
                this.props.history.push("/login");
            }
        }
    }

    state = {
        current : 'mail',
    };
    handleClick = e => {
        console.log('click ', e);
        this.setState({
            current: e.key,
        });
    };
    render() {

        return (
            <Menu onClick={this.handleClick} selectedKeys={[this.state.current]} mode="horizontal">
                <Menu.Item key="mail" >
                    <AppleOutlined />
                    Log In
                </Menu.Item>
            </Menu>
        );
    }
}

export default withRouter(PageLayout);
