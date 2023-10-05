import './App.css';
import { Route, Routes } from 'react-router-dom';
import RegisterPage from './page/RegisterPage';
import HomePage from './page/HomePage';
import LoginPage from './page/LoginPage';
import LoginSuccess from './component/LoginSuccess';
import LoginFailed from './component/LoginFailed';

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={ <HomePage /> } />

        <Route path='/register' element = { <RegisterPage /> } />
        <Route path='/login' element={<LoginPage />} />

        <Route path='/login-success' element={<LoginSuccess />} />
        <Route path='/login-failed' element = {<LoginFailed />} />
      </Routes>
      
    </div>
  );
}

export default App;
