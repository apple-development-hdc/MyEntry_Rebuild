import React, {Component} from 'react';
import {Button,Row,Col} from "antd";
import {withRouter} from "react-router-dom";
import { Card, Avatar } from 'antd';
import './Home.css';
import UserOutlined from "@ant-design/icons/lib/icons/UserOutlined";

const { Meta } = Card;

class Home extends Component {
    onTofaClick = () =>{

    };

    onVisitorClick = () =>{

    };
    onScannerClick = () =>{
        window.localStorage.setItem("user","false");
        if(window.localStorage.getItem("guard")==="false"){
            this.props.history.push("/");
        }
        else{
            // to Scanner
        }
    };



    render() {


        return (
            <div className="cards">
                <Row gutter={16}>
                    <Col span={8}>


                <Card style={{ width: 300, height:200,marginTop: 16 }} >
                    <Meta
                        avatar={
                            <Avatar
                                style={{
                                    backgroundColor: '#87d068',
                                }}
                                icon={<UserOutlined />}
                            />
                        }
                        title="TOFA"
                        description="Time On Floor Application"

                    />
                    <div className="tofa">
                        <Button type="danger" onClick={this.onTofaClick}>TOFA Handle</Button>
                    </div>
                </Card>
                    </Col>
                    <Col span={8}>
                        <Card style={{ width: 300, height:200,marginTop: 16 }} >
                            <Meta
                                avatar={
                                    <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
                                }
                                title="VISITORS"
                                description="To get the visitor badge"

                            />
                            <div className="tofa">
                            <Button type="danger" onClick={this.onVisitorClick}>Visitor Log</Button>
                            </div>
                            </Card>
                    </Col>

                <Col span={8}>
                    <Card style={{ width: 300, height:200,marginTop: 16 }} >
                        <Meta
                            avatar={
                                <Avatar icon={<UserOutlined />} />
                            }
                            title="SCANNER"
                            description="Unable Scanner"

                        />
                        <div className="tofa">
                            <Button type="danger" onClick={this.onScannerClick}>Scanner ON</Button>
                        </div>
                    </Card>
                </Col>
                </Row>
            </div>
        );
    }
}


export default withRouter(Home);
