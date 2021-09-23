import './App.css';
import { useEffect, useState } from 'react';
import { Container } from 'react-bootstrap';
import Pagination from './components/paginate';
import NumbersTable from './components/numbers';
import FilteringForm from './components/filterForm';
function App() {
  const baseUrl = 'http://localhost:8080/api'
  const [numbers, setNumbers] = useState([]);
  const [nPages, setNPages] = useState(0);
  const [currentPage, setCurrentPage] = useState(1);
  const [requestUrl, setUrl] = useState(baseUrl + '/numbers/?');
  const fetchData = (url) => {
    fetch(url)
      .then(res => res.json())
      .then(data => {
        console.log(data);
        setNumbers(data["phoneNumbers"]);
        setNPages(data["numberOfPages"]);
      })
      .catch(err => console.log(err));
  }
  useEffect(() => {
    fetchData(requestUrl)
  }, [requestUrl])
  const onFilterSubmit = (
    cc,
    sc,
    phone,
    ext,
    validate = false
  ) => {
    setCurrentPage(1);
    const newUrl = baseUrl
      .concat('/numbers/?')
      .concat((cc.length > 0) ? `cc=${cc}` : '')
      .concat((sc.length > 0) ? `&&sc=${sc}` : '')
      .concat((phone.length > 0) ? `&&phone=${phone}` : '')
      .concat((ext.length > 0) ? `&&ext=${ext}` : '')
      .concat((validate) ? '&&validate=1' : '');
    setUrl(newUrl);
  }
  const onPageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
    fetchData(requestUrl + `&&page=${pageNumber}`);
  }
  return (
    <Container className='App'>
      <FilteringForm baseUrl={baseUrl} onFilterSubmit={onFilterSubmit} />
      <br />{requestUrl}
      <NumbersTable numbers={numbers} />
      <Pagination currentPage={currentPage} nPages={nPages} onPageChange={onPageChange} />
    </Container>
  );
}

export default App;
