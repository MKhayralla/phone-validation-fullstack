import React, { useEffect, useState } from 'react';
import { Dropdown, Form, Col, Row, Button, InputGroup } from 'react-bootstrap';

const FilteringForm = ({ onFilterSubmit, baseUrl }) => {
    const [dataState, setDataState] = useState({
        'cc': '',
        'sc': '',
        'phone': '',
        'ext': '',
        'validate': false
    })
    const [countries, setCountries] = useState({})
    useEffect(() => {
        fetch(baseUrl + '/codes/')
            .then(res => res.json())
            .then(data => setCountries(data))
            .catch(err => console.log(err))
    }, [baseUrl]);
    const handleChange = (e) => {
        e.preventDefault();
        setDataState(currentState => (
            {
                ...currentState,
                [e.target.name]: e.target.value
            }
        ))
    };
    return (
        <Form>
            <Row>
                <Col xs={6} lg={3}>
                    <InputGroup>
                        <InputGroup.Text>+</InputGroup.Text>
                        <Form.Control placeholder='country code' name='cc' id='cc'
                            value={dataState['cc']}
                            onChange={handleChange} />
                    </InputGroup>
                </ Col>
                <Col xs={6} lg={3}>
                    <Form.Control placeholder='state code' name='sc' id='sc'
                        value={dataState['sc']}
                        onChange={handleChange} />
                </ Col>
                <Col xs={6} lg={3}>
                    <Form.Control placeholder='phone' name='phone' id='phone'
                        value={dataState['phone']}
                        onChange={handleChange} />
                </ Col>
                <Col xs={6} lg={3}>
                    <Form.Control placeholder='ext' name='ext' id='ext'
                        value={dataState['ext']}
                        onChange={handleChange} />
                </ Col>
            </Row>
            <Row>
                <Col xs={4}>
                    <Dropdown>
                        <Dropdown.Toggle id='toggle' variant='warning'>
                            Choose Country
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            {
                                Object.entries(countries)
                                    .map(entry => (
                                        <Dropdown.Item key={entry[1]}
                                            onClick={() => setDataState(
                                                lastState => (
                                                    { ...lastState, 'cc': entry[1] }
                                                )
                                            )}>
                                            {entry[0]}
                                        </ Dropdown.Item>
                                    ))
                            }
                        </ Dropdown.Menu>
                    </ Dropdown>
                </ Col>
                <Col xs={4}>
                    <Form.Check type='checkbox' checked={dataState['validate']}
                        name='validate'
                        id='validate'
                        label='validate results'
                        onChange={() => setDataState(
                            (prev) => ({
                                ...prev, validate: !prev.validate
                            })
                        )} />
                </ Col>
                <Col xs={4}>
                    <Button variant="danger"
                        onClick={() => onFilterSubmit(
                            dataState['cc'],
                            dataState['sc'],
                            dataState['phone'],
                            dataState['ext'],
                            dataState['validate']
                        )}>
                        Filter
                    </ Button>
                </Col>
            </Row>
            {JSON.stringify(dataState, 2, null)}
        </Form>
    )
};

export default FilteringForm;