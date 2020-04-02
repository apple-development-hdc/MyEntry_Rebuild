import React, {Component} from 'react';
import {Form, Input, Button, Radio, Select} from 'antd';
import {withRouter} from "react-router";
import Webcam from "react-webcam";
import * as Swal from "sweetalert2";

const { Option } = Select;
const layout = {
    labelCol: {
        span: 6,
    },
    wrapperCol: {
        span: 10,
    },
};
const validateMessages = {
    required: 'This field is required!',
    camrequired:'Taking Photo is Mandatory !!',
    types: {
        email: 'Not a validate email!',
        number: 'Not a validate number!',
    },

};

class AssetMovement extends Component{
    //drop down manager selection dropdown from backend
    constructor(props) {
        super(props);
        this.state = {
            behalf: [],
        };
    }
    // componentDidMount() { API INTEGRATION
    //     let managers = [];
    //     fetch('https://swapi.co/api/planets/')
    //         .then(response => {
    //             return response.json();
    //         }).then(data => {
    //         managers = data.results.map((behalf) => {
    //             return behalf
    //         });
    //         console.log(managers);
    //         this.setState({
    //             behalf: managers,
    //         });
    //     });
    // }
    state = {
        cam : false,
        snap : null,
    };

    render() {


        const onFinish = values => {
            console.log(values);
        };

        const videoConstraints = {
            width: 1280,
            height: 720,
            facingMode: "user"
        };

        const setRef = webcam => {
            this.webcam = webcam;
        };

        const capture = () => {

            const imageSrc = this.webcam.getScreenshot();
            sessionStorage.setItem("image",imageSrc.trim());
            if(imageSrc.length>0){
                Swal.fire(
                    'Photo Taken',
                    'Image has been recorded',
                    'success'
                )
            }
            this.setState({imagebase: imageSrc.trim()});
            this.setState({snap : imageSrc});
            this.setState({cam : false});
        };

        const camera = () => {
            if (this.state.cam === true) {
                return (<div>
                    <Webcam
                        audio={false}
                        height={350}
                        ref={setRef}
                        screenshotFormat="image/jpeg"
                        width={350}
                        videoConstraints={videoConstraints}
                    />
                    <button onClick={capture} type="danger">Capture photo</button>
                </div>);
            } else {
                return (<div></div>);
            }
        };


        return (

            <Form {...layout} name="nest-messages" onFinish={onFinish} validateMessages={validateMessages}
                  initialValues={{
                      camImage : this.state.snap,
                  }} >
                <Form.Item name={['user', 'asset']}
                           label="Asset"
                           rules={[
                               {
                                   required: true,
                               },
                           ]}>
                    <Radio.Group>
                        <Radio value="IT Asset">IT Asset</Radio>
                        <Radio value="NON-IT Asset">NON-IT Asset</Radio>
                    </Radio.Group>
                </Form.Item>
                <Form.Item
                    name={['user', 'behalf']}
                    label="Behalf Of"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Select
                        showSearch
                        placeholder="Select a person"
                        optionFilterProp="children"
                        filterOption={(input, option) =>
                            option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                        }
                    >
                        <Option value="from">From</Option>
                        <Option value="backend">Backend</Option>
                    </Select>

                </Form.Item>
                <Form.Item
                    name={['user', 'assetsType']}
                    label="Asset Type"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Select
                        showSearch
                        placeholder="Asset Type"
                        optionFilterProp="children"
                        filterOption={(input, option) =>
                            option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                        }
                    >
                        <Option value="desktop">Desktop</Option>
                        <Option value="Keyboard">Keyboard</Option>
                        <Option value="Mouse">Mouse</Option>
                        <Option value="RAM">RAM</Option>
                        <Option value="Records">Record Book</Option>
                        <Option value="Chair">Chair</Option>
                        <Option value="Table">Table</Option>
                        <Option value="Duster">Duster</Option>
                        <Option value="Highlighter">Highlighter</Option>
                        <Option value="Book">Visitor Book</Option>
                        <Option value="Others">Other</Option>
                    </Select>
                </Form.Item>

                <Form.Item
                    name={['user', 'Movement']}
                    label="Movement Type"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Select
                        showSearch
                        placeholder="Movement Type"
                        optionFilterProp="children"
                        filterOption={(input, option) =>
                            option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
                        }
                    >
                        <Option value="inward">Inward</Option>
                        <Option value="outward">Outward</Option>
                    </Select>
                </Form.Item>
                <Form.Item
                    name={['user', 'assetId']}
                    label="ASSET ID"
                    rules={[
                        {
                            type: 'string',
                            required: true,

                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item name={['user', 'remarks']} label="Remarks">
                    <Input.TextArea/>
                </Form.Item>
                <Form.Item wrapperCol={{...layout.wrapperCol, offset: 10}}>
                    <Button style={{borderRadius: 10}} type="primary" htmlType="submit">
                        Submit
                    </Button>
                    <Button style={{borderRadius: 10, marginLeft: 14}} type="primary" htmlType="reset" onClick={() => {
                        this.setState({cam : true}); console.log("CAM Activated");
                    }}>
                        Take Pic
                    </Button>
                    <Form.Item name={['user', 'camera',sessionStorage.getItem("image")]}
                               rules={[
                                   {
                                       camrequired: true
                                   },
                               ]}>
                        {camera()}
                    </Form.Item>
                </Form.Item>
            </Form>
        );
    }
}


export  default withRouter(AssetMovement);

