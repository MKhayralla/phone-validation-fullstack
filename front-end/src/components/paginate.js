import React from 'react'
import { Button, ButtonGroup } from 'react-bootstrap';

const Pagination = (props) => {
    const { nPages, currentPage, onPageChange } = props;
    let pageNumbers = [];
    for (let i = 1; i <= nPages; i++) {
        pageNumbers.push(i);
    }
    return (
        <ButtonGroup className='MarginTop'>
            <Button onClick={() => onPageChange(currentPage - 1)}
            className="PaginationButton"
            disabled={currentPage === 1}>
                prev    
            </ Button>
            {
                pageNumbers.map(
                    (number) => (
                    <Button key={number} onClick={() => onPageChange(number)}
                    disabled={number === currentPage} >
                        {number}
                    </Button>
                    )
                )
            }
            <Button onClick={() => onPageChange(currentPage + 1)}
            className="PaginationButton"
            disabled={currentPage === nPages}>
                Next
            </ Button>
        </ButtonGroup>
    )
}
export default Pagination;