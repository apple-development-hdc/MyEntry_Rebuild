import React, {Component} from 'react';
import { Form, Input,Button,Radio} from 'antd';
import {withRouter} from "react-router";
import Webcam from "react-webcam";
import * as Swal from "sweetalert2";


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
    number: {
        range: 'Must be between ${min} and ${max}',
    },
};



class NewVisitor extends Component {


       state = {
            cam : false,
            snap : null,
        };

    render() {


        const onFinish = values => {
            console.log(values);
            sessionStorage.clear();
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
                <Form.Item name={['user', 'source']}
                           label="Source"
                            rules={[
                                {
                                  required: true,
                                },
                            ]}>
                    <Radio.Group>
                        <Radio value="Wipro">Wipro</Radio>
                        <Radio value="External">External</Radio>
                    </Radio.Group>
                </Form.Item>
                <Form.Item
                    name={['user', 'firstName']}
                    label="First Name"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item
                    name={['user', 'lastName']}
                    label="Last Name"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item
                    name={['user', 'contact']}
                    label="Contact"
                    rules={[
                        {
                            type: 'string',
                            required: true,

                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item
                    name={['user', 'comingFrom']}
                    label="Coming From"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item
                    name={['user', 'purpose']}
                    label="Purpose"
                    rules={[
                        {
                            required: true,
                        },
                    ]}
                >
                    <Input/>
                </Form.Item>
                <Form.Item
                    name={['user', 'serialNo']}
                    label="Laptop Serial No."
                    rules={[
                        {
                            type: 'string'

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





export default withRouter(NewVisitor);