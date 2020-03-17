import React from 'react';
import { Route  , BrowserRouter as Router} from 'react-router-dom';
import './App.css';
import PageLayout from "./components/PageLayout";
import Home from "./components/Home";
import 'antd/dist/antd.css';
import UserLogin from "./components/UserLogin";
import Visitor from "./components/Visitor";
import Tofa from "./components/Tofa";

function App() {

  return (
      <div>

          <Router>
              <PageLayout/>
        <div className="pageset">
            <Route exact path={["/","/login/"]} ><UserLogin /></Route>
        </div>
              <Route exact path={"/home/"} ><Home /></Route>
              <Route exact path={"/tofa/"} ><Tofa/></Route>
              <Route exact path={"/visitor/"} ><Visitor/></Route>


          </Router>
      </div>
  );
}

export default App;
