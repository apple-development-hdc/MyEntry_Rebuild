import React from 'react';
import { Route  , BrowserRouter as Router} from 'react-router-dom';
import './App.css';
import PageLayout from "./components/PageLayout";
import Home from "./components/Home";
import 'antd/dist/antd.css';
import UserLogin from "./components/UserLogin";

function App() {

  return (
      <div>

          <Router>
              <PageLayout/>
        <div className="pageset">
                  <Route path={"/login/"} >
                      <UserLogin />
                  </Route>
        </div>
                  <Route path={"/home/"} >
                      <Home />
                  </Route>

          </Router>
      </div>
  );
}

export default App;
