import React, {Component} from 'react';
import {Button,Row,Col} from "antd";
import {withRouter} from "react-router-dom";
import { Card, Avatar } from 'antd';
import './Home.css';
import UserOutlined from "@ant-design/icons/lib/icons/UserOutlined";
import * as Swal from "sweetalert2";


const { Meta } = Card;

window.addEventListener("beforeunload", (ev) =>
{
    ev.preventDefault();
    console.log("close");
    sessionStorage.clear();
    for(let i=0;i<localStorage.length;i++){
        let key=(localStorage.key(i));
        localStorage.setItem(key,"false");
    }
    return ev.returnValue = 'Are you sure you want to close?';
});
class Home extends Component {

    onTofaClick = () =>{
            if(window.localStorage.getItem("user")==="true" && window.localStorage.getItem("guard")==="false"){
                this.props.history.push("/tofa/");
            }
            else{
                Swal.fire(
                    'Not Authorized',
                    'Wrong Credentials Reported',
                    'error'
                )
            }
    };

    onVisitorClick = () =>{
        if(window.localStorage.getItem("guard")==="true" ||  window.localStorage.getItem("user")==="true"){
            this.props.history.push("/visitor/")
        }
        else{
            this.props.history.push("/");
        }
    };
    onScannerClick = () =>{

        if(window.localStorage.getItem("guard")==="true" ||  window.localStorage.getItem("user")==="true") {
            //this.dangerouslySetInnerHTML={this.createMarkup()}

           function f() {
             window.location.assign("http://localhost:63342/app-frontend/src/Scanner/index1.html?_ijt=qude5eb4olraiqtuoms83ifatv");
           }
           f.call();
        }
        else{
            this.props.history.push("/");
        }
    };

    onAssetClick=()=>{
        if(window.localStorage.getItem("guard")==="true" ||  window.localStorage.getItem("user")==="true"){
            this.props.history.push("/assets/")
        }
        else{
            this.props.history.push("/");
        }

    };

    render() {
        return (
             <div className="cards" style={{marginBottom:500}}>
                <Row gutter={16}>
                    <Col span={12}>


                <Card style={{ width: 300, height:200,marginTop: 16 ,borderRadius:10,backgroundColor:"ghostwhite"}} >
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
                        <Button type="danger" style={{borderRadius:10}} onClick={this.onTofaClick}>TOFA Handle</Button>
                    </div>
                </Card>
                    </Col>
                    <Col span={8}>
                        <Card style={{ width: 300, height:200,marginTop: 16,borderRadius:10,backgroundColor:"floralwhite" }} >
                            <Meta
                                avatar={
                                    <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
                                }
                                title="VISITORS"
                                description="To get the visitor badge"

                            />
                            <div className="tofa">
                            <Button type="danger" style={{borderRadius:10}} onClick={this.onVisitorClick}>Visitor Log</Button>
                            </div>
                            </Card>
                    </Col>


                </Row>

                 <Row gutter={16}>
                     <Col span={12}>
                         <Card style={{ width: 300, height:200,marginTop: 16 ,borderRadius:10,backgroundColor:"ghostwhite"}} >
                             <Meta
                                 avatar={
                                     <Avatar icon={<UserOutlined />} />
                                 }
                                 title="ASSETS"
                                 description="Assets Management"

                             />
                             <div className="tofa">

                                 <Button type="danger" style={{borderRadius:10}} onClick={this.onAssetClick}>Assets</Button>
                             </div>
                         </Card>
                     </Col>
                     <Col span={8}>
                         <Card style={{ width: 300, height:200,marginTop: 16 ,borderRadius:10,backgroundColor:"whitesmoke"}} >
                             <Meta
                                 avatar={
                                     <Avatar icon={<UserOutlined />} />
                                 }
                                 title="SCANNER"
                                 description="Unable Scanner"

                             />
                             <div className="tofa">

                                 <Button type="danger" style={{borderRadius:10}} onClick={this.onScannerClick}>Scanner ON</Button>
                             </div>
                         </Card>
                     </Col>
                 </Row>
            </div>
        );
    }
}


export default withRouter(Home);
