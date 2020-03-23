import React from 'react';
import { Form, Input,Button,Radio } from 'antd';
import {withRouter} from "react-router";

const layout = {
    labelCol: {
        span: 8,
    },
    wrapperCol: {
        span: 10,
    },
};

const validateMessages = {
    required: 'This field is required!',
    types: {
        email: 'Not a validate email!',
        number: 'Not a validate number!',
    },
    number: {
        range: 'Must be between ${min} and ${max}',
    },
};

const NewVisitor = () => {


    const onFinish = values => {
        console.log(values);
    };

    return (
        <Form {...layout} name="nest-messages" onFinish={onFinish} validateMessages={validateMessages}>
            <Form.Item name={['user', 'source']} label="Source">
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
                <Input />
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
                <Input />
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
                <Input />
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
                <Input />
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
                <Input />
            </Form.Item>
            <Form.Item
                name={['user', 'serialNo']}
                label="Laptop Serial No."
                rules={[
                    {
                      type:'string'

                    },
                ]}
            >
                <Input />
            </Form.Item>
            <Form.Item name={['user', 'remarks']} label="Remarks" >
                <Input.TextArea />
            </Form.Item>
            <Form.Item wrapperCol={{ ...layout.wrapperCol, offset:10 }} >
                <Button style={{borderRadius:10}} type="primary" htmlType="submit" >
                    Submit
                </Button>
                    <Button style={{borderRadius:10, marginLeft:12}} type="danger" htmlType="submit">
                        Cancel
                    </Button>
                    <Button style={{borderRadius:10,marginLeft:14}} type="primary" htmlType="submit">
                        Take Pic
                    </Button>
            </Form.Item>
        </Form>
    );
};



export default withRouter(NewVisitor);
