import React from 'react';
import {Form, Input, Button, Checkbox} from 'antd';
import {withRouter} from "react-router";

const layout = {
    labelCol: {

        span: 5,
    },
    wrapperCol: {

        span: 5,
    },
};
const tailLayout = {
    wrapperCol: {
        offset: 6,
        span: 9,
    },
};

const UserLogin = () => {
    const onFinish = values => {
        console.log('Success:', values);
    };

    const onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    return (
        <Form
            {...layout}
            name="basic"
            initialValues={{
                remember: true,
            }}
            onFinish={onFinish}
            onFinishFailed={onFinishFailed}
        >
            <Form.Item

                label="Username"
                name="username"
                rules={[
                    {
                        required: true,
                        message: 'Please input your username!',
                    },
                ]}
            >
                <Input />
            </Form.Item>

            <Form.Item

                label="Password"
                name="password"
                rules={[
                    {
                        required: true,
                        message: 'Please input your password!',
                    },
                ]}
            >

                <Input.Password/>
            </Form.Item>

            <Form.Item {...tailLayout} name="remember" valuePropName="checked">
                <Checkbox>Remember me</Checkbox>
            </Form.Item>

            <Form.Item {...tailLayout}>
                <Button type="danger" htmlType="submit">
                    Submit
                </Button>
            </Form.Item>
        </Form>
    );
};

export default withRouter(UserLogin);
