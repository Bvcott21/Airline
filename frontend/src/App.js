import './App.css';
import { Route, Routes } from 'react-router-dom';
import LoginRegisterPage from './page/LoginRegisterPage';

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={ <LoginRegisterPage /> } />
      </Routes>
      
    </div>
  );
}

export default App;
