import React from 'react';
import { Route  , BrowserRouter as Router} from 'react-router-dom';
import './App.css';
import PageLayout from "./components/PageLayout";
import Home from "./components/Home";
import 'antd/dist/antd.css';
import UserLogin from "./components/UserLogin";
import Visitor from "./components/Visitor";
import Tofa from "./components/Tofa";
import VisitorLog from "./components/VisitorLog";
import NewVisitor from "./components/NewVisitor";

function App() {

  return (
      <div>

          <Router>
              <PageLayout/>
        <div className="pageset">
            <Route exact path={["/","/login/"]} ><UserLogin /></Route>
        </div>
        <div className="homeset">
            <Route exact path={"/home/"} ><Home /></Route>
        </div>

              <Route exact path={"/tofa/"} ><Tofa/></Route>
         <div className="visitor">
             <Route exact path={"/visitor/"} ><Visitor/></Route>
         </div>

              <Route exact path={"/visitor/log/"} ><VisitorLog/></Route>
              <Route exact path={"/visitor/new/"} ><NewVisitor/></Route>


          </Router>
      </div>
  );
}

export default App;
