import React from 'react';
import { render } from "react-dom";
import {
  Routes,
  Route,
} from "react-router-dom";
import Home from './pages/Home';
import Profile from './pages/Profile';

export default function MainRoutes() {
  return(
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="profile" element={<Profile />} />
    </Routes>
  );
}

// const Routes = () => (
//   <BrowserRouter>
//     <Switch>
//       <Route exat path='/' component={Home}/>
//     </Switch>    
//   </BrowserRouter>
// ); 

// export default Routes;