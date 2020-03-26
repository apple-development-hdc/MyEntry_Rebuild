import React, {Component} from 'react';
import { Menu } from 'antd';
import {
    AppleOutlined,

} from '@ant-design/icons';
import {withRouter} from "react-router-dom";



class PageLayout extends Component {


    componentDidMount() {
        console.log(window.location.pathname);
        let p = window.location.pathname;
        // api call
        if(window.localStorage.getItem("user")==="true" || window.localStorage.getItem("guard")==="true"){
            this.props.history.push("/home/");
        }
        else{
            this.props.history.push("/login");
        }

    }

    state = {
        current : 'in',
    };
    handleClick = e => {
        console.log('click ', e);
        if(e.key === "out"){
            this.props.history.push("/");
            window.localStorage.setItem("user","false");
            window.localStorage.setItem("guard","false");
            this.setState({
                current: 'in',
            });
        }

    };
    render() {

        return (
            <Menu onClick={this.handleClick} selectedKeys={[this.state.current]} mode="horizontal">
                <Menu.Item key="in">
                    <AppleOutlined />
                    LOG IN
                </Menu.Item>
                <Menu.Item key="out" >

                    LOG OUT
                </Menu.Item>
            </Menu>


        );
    }
}

export default withRouter(PageLayout);
