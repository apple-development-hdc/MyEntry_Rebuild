import React, {Component} from 'react';
import {withRouter} from "react-router";
import { Input,DatePicker } from 'antd';
import moment from 'moment';
import "./VisitorLog.css";
const { Search } = Input;

const { RangePicker } = DatePicker;
function onChange(dates, dateStrings) {
    console.log('From: ', dates[0], ', to: ', dates[1]);
    console.log('From: ', dateStrings[0], ', to: ', dateStrings[1]);
}

class VisitorLog extends Component {
state={
  date:null,
};
   onFill={

   };
    render() {
        return (
            <div>
                <div className="namesearch">
                    <Search
                        placeholder="input search text"
                        onSearch = {value => console.log(value)}
                        style={{ width: 200 }}
                    />
                </div>
                <div className="searchDate" >
                    <RangePicker
                        ranges={{
                            Today: [moment(), moment()],
                            'This Month': [moment().startOf('month'), moment().endOf('month')],
                        }}
                        showTime
                        format="YYYY/MM/DD HH:mm:ss"
                        onChange={onChange}
                    />
                </div>
            </div>


        );
    }
}

export default withRouter(VisitorLog);
