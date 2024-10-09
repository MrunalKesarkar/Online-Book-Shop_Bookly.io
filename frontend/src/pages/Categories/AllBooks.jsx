
import { Link, Navigate, useNavigate } from 'react-router-dom';
import Navbar from '../../components/Navbar/navbar';
import React, { useEffect, useState } from 'react';
import Books from '../../components/books';
import { getBooksByCategory } from '../../services/books'; // Update the service to fetch books by category

const AllBooks = () => {
  const [books, setBooks] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('All');
  const navigate = useNavigate(); // Initialize navigate

  const categories = [
    'Sciencefiction',
    'Mystery',
    'Fantasy',
    'Biography',
    'Romance',
    'Thriller',
    'Historical',
    'Political',
    'Horror',
    'Poetry',
    'Suspense'
  ];

  useEffect(() => {
    const fetchBooks = async () => {
      const result = await getBooksByCategory(selectedCategory);
      if (result) {
        setBooks(result);
      }
    };

    fetchBooks();
  }, [selectedCategory]);

  return (
    <div>
      <Navbar />
      <div style={{ display: 'flex' }}>
        <div style={{ width: '200px', borderRight: '1px solid #ddd', padding: '30px' }}>
          <h3>Categories</h3>
          <ul>
            {categories.map((type, index) => (
              <li key={index}>
                <Link to="#" onClick={() => setSelectedCategory(type)}>
                  {type}
                </Link>
              </li>
            ))}
          </ul>
        </div>
        <div style={{ flex: 1, padding: '30px' }}>
          <h3>Results</h3>
          {books.length === 0 && (
            <h3 className='mt-5' style={{ textAlign: 'center' }}>
              There are no books at the moment.
            </h3>
          )}
          <div className='row mt-5'>
            {books.map((book) => (
              <Books
                key={book.id}
                onClick={() => navigate('/book-details', { state: { id: book.id } })}
                books={book}
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default AllBooks;





/*import React, { useEffect, useState } from 'react';
import { Link , Navigate} from 'react-router-dom';
import Navbar from '../../components/navbar';
import Books from '../../components/books';
import { getBooks } from '../../services/books';

const AllBooks = () => {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    const fetchBooks = async () => {
      const result = await getBooks();
      if (result) {
        setBooks(result);
      }
    };

    fetchBooks();
  }, []);

  const categories = [
    'Sciencefiction',
    'Mystery',
    'Fantasy',
    'Biography',
    'Romance',
    'Thriller',
    'Historical',
    'Political',
    'Horror',
    'Poetry',
    'Suspense'
  ];

  return (
    <div>
      <Navbar />
      <div style={{ display: 'flex' }}>
        <div style={{ width: '200px', borderRight: '1px solid #ddd', padding: '10px' }}>
          <h3>Categories</h3>
          <ul>
            {categories.map((type, index) => (
              <li key={index}>
                <Link to={`/${type}`}>{type}</Link>
              </li>
            ))}
          </ul>
        </div>
        <div style={{ flex: 1, padding: '10px' }}>
          <h3>Results</h3>
          {books.length === 0 && (
            <h3 className='mt-5' style={{ textAlign: 'center' }}>
              There are no books at the moment.
            </h3>
          )}
          <div className='row mt-5'>
            {books.map((book) => (
              <Books
                key={book.id}
                onClick={() => Navigate('/book-details', { state: { id: book.id } })}
                books={book}
              />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default AllBooks;
*/




/*
import { useEffect } from 'react';
import Books from '../../components/books';
import Navbar from '../../components/navbar';
import { Link , Navigate } from 'react-router-dom'


const AllBooks = () => {
    const books = [
    'Sciencefiction',
      'Mystery',
      'Fantasy',
      'Biography',
      'Romance',
      'Thriller',
      'Historical',
      'Political',
      'Horror',
      'Poetry',
      'Suspense'
    ];



    return (
        <div>
            <Navbar />
        <div style ={{display : 'flex'}}>
            <div style = {{ width : '200px', borderRight:'1px solid #ddd', padding: '10px'}}>
            <h3>Categories</h3>
            <ul>
                {books.map((type, index) => (
                <li>
                <Link to={`/${type}`}>{type}</Link>
                
                </li>
                 ))}
            </ul>
            </div>

            <div style={{flex: 1, padding: '10px'}}>
                <h3>Results</h3>
                 {books.length == 0 && (
                    <h3 className='mt-5' style={{ textAlign: 'center' }}>
                        There are not books at the moment.
                    </h3>
                )}

        <div className='row mt-5'>
        {books.map((books) => {
          return (
            <Books
              onClick={() => {
                // navigate with extra data (id)
                Navigate('/books-details', { state: { id: books['id'] } })
              }}
              books={books}
            />
          )
        })}
      </div> 

            </div>

        </div>
        </div>
    );
}

export default AllBooks;
*/
