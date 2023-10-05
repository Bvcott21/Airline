import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useState } from 'react'

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

const LoginForm = () => {
    const api = 'http://localhost:8088/api/v1/user/login';
    const navigate = useNavigate();

    const [ userName, setUserName ] = useState('');
    const [ password, setPassword ] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        axios.post(api, {
            userName: userName,
            password: password
    })
    .then(r => {
        if(r.status ===200 && r.data.success === true) {
            navigate('/login-success');
        } else {
            navigate('/login-failed');
        }
    })
    .catch(e => {
        console.error(e);
    })
    }

    return(
        <div>
            <Form
                className='w-50 align-content-center m-auto'
                onSubmit={handleSubmit}>
                <Form.Group
                    className='mb-3'
                    controlId='formBasicUserName'>
                        <Form.Label>User Name</Form.Label>
                        <Form.Control
                            required
                            type='text'
                            value={userName}
                            onChange={event => setUserName(event.target.value)}
                            placeholder='Enter username'>

                        </Form.Control>
                </Form.Group>

                <Form.Group
                    className='mb-3'
                    controlId='formBasicPassword'>
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            required
                            type='text'
                            value={password}
                            onChange={event => setPassword(event.target.value)}
                            placeholder='Enter password'>

                        </Form.Control>
                </Form.Group>

                <Button variant='primary' className='mx-3' type='submit'>
                    Login
                </Button>
            </Form>
        </div>
    )
}

export default LoginForm;