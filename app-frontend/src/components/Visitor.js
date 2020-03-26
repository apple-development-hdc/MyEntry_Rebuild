import React, {Component} from 'react';
import {Button,Row,Col} from "antd";
import {withRouter} from "react-router-dom";
import { Card, Avatar } from 'antd';
import './Home.css';
import UserOutlined from "@ant-design/icons/lib/icons/UserOutlined";
import * as Swal from "sweetalert2";
import "./Visitor.css";
const { Meta } = Card;
class Visitor extends Component {
    onLogClick=()=>{
        if(window.localStorage.getItem("user")==="true" && window.localStorage.getItem("guard")==="false"){
            this.props.history.push("/visitor/log/");
        }
        else{
            Swal.fire(
                "Not Authorized",
                "Will be Reported",
                "error"
            )
        }
    };

    onNewClick=()=>{
        if(window.localStorage.getItem("user")==="true" || window.localStorage.getItem("guard")==="true"){
            this.props.history.push("/visitor/new/");
        }
        else{
            this.props.history.push("/login")
        }

    };

    render() {
        return (
            <div className="cards">
                <Row gutter={16}>
                    <Col span={8}>
                        <Card style={{ width: 300, height:200,marginTop: 16 ,borderRadius:10,backgroundColor:"whitesmoke"}} >
                            <Meta
                                avatar={
                                    <Avatar
                                        style={{
                                            backgroundColor: '#87d068',
                                        }}
                                        icon={<UserOutlined />}
                                    />
                                }
                                title="NEW VISITOR"
                                description="Register New Visitor"

                            />
                            <div className="tofa">
                                <Button type="danger" style={{borderRadius:10}} onClick={this.onNewClick}>Add Visitor</Button>
                            </div>
                        </Card>
                    </Col>
                    <Col span={8}>
                        <Card style={{ width: 300, height:200,marginTop: 16, backgroundColor:"floralwhite",borderRadius:10 }} >
                            <Meta
                                avatar={
                                    <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
                                }
                                title="VISITORS LOG"
                                description="Check Visitor Logs"

                            />
                            <div className="tofa">
                                <Button type="danger" style={{borderRadius:10}} onClick={this.onLogClick}>Visitor Log</Button>
                            </div>
                        </Card>
                    </Col>
                </Row>
            </div>
        );
    }
}

export default withRouter(Visitor);
