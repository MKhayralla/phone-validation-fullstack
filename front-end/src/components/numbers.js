import React, { Fragment } from "react";
import { Col, Row } from 'react-bootstrap';

const NumbersTable = ({ numbers }) => (
    <Fragment>
        <Row className='Orange'>
            <Col xs={2}>
                ID
            </Col>
            <Col xs={5}>
                Name
            </Col>
            <Col xs={5}>
                Number
            </Col>
        </Row>
        {
            numbers.map(
                number => (
                    <Row key={number.id} className='BorderBottom'>
                        <Col xs={2}>
                            {number.id}
                        </Col>
                        <Col xs={5}>
                            {number.name}
                        </Col>
                        <Col xs={5}>
                            {number.phone}
                        </Col>
                    </Row>
                )
            )
        }
    </Fragment>
)

export default NumbersTable;