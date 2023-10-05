import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';
import { useState } from 'react';

const RegisterForm = () => {
    const api = 'http://localhost:8088/api/v1/user/register';
    const navigate = useNavigate();

    const [ userName, setUserName ] = useState('');
    const [ firstName, setFirstName ] = useState('');
    const [ lastName, setLastName ] = useState('');
    const [ password, setPassword ] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        axios.post(api, {
            userName: userName,
            firstName: firstName,
            lastName: lastName,
            password: password
        })
        .then(response => {
            if(response.status === 201) {
                console.log('User submission success');
                navigate('/user');
            }
        })
        .catch(err => {
            console.error(err);
        })
    }

    return (
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
                    controlId='formBasicFirstName'>
                        <Form.Label>First Name</Form.Label>
                        <Form.Control
                            required
                            type='text'
                            value={firstName}
                            onChange={event => setFirstName(event.target.value)}
                            placeholder='Enter first name'>

                        </Form.Control>
                </Form.Group>

                <Form.Group
                    className='mb-3'
                    controlId='formBasicLastName'>
                        <Form.Label>Last Name</Form.Label>
                        <Form.Control
                            required
                            type='text'
                            value={lastName}
                            onChange={event => setLastName(event.target.value)}
                            placeholder='Enter last name'>

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
                    Register
                </Button>
            </Form>
        </div>
    )
};

export default RegisterForm;