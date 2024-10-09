// BookDescriptionPage.jsx
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { config } from '../../services/config';
import axios from 'axios';
import Navbar from '../../components/Navbar/navbar';
import { Link } from 'react-router-dom';

const BookDescriptionPage = () => {
  const { id } = useParams();
  const [book, setBook] = useState(null);

  useEffect(() => {
    const getBook = async () => {
      if (!id) {
        console.error('No book ID provided');
        return;
      }

      try {
          
        const foundBook = await axios.get(`${config.serverUrl}/books/book/${id}`);
        
          setBook(foundBook.data);
        
      } catch (error) {
        console.error('Error fetching book details:', error);
      }
    };

    getBook();
  }, [id]);

  if (!book) {
    return <div>Book not found</div>;
  }

  return (
    <div> 
        <Navbar />
    
    <div style={styles.container}>
      <div style={styles.bookCoverContainer}>
        <img src={`${config.serverUrl}/${book.imgPath}`} alt={`Cover of ${book.title}`} style={styles.coverImage} />
      </div>
      <div style={styles.detailsContainer}>
        <h1 style={styles.title}>{book.title}</h1>
        <h2 style={styles.author}>{book.author}</h2>
        <p style={styles.description}>{book.description}</p>
        <p style={styles.description}>Rs. {book.price}</p>
        <Link to={`/shoppingcart/book/${book.bookId}`} style={styles.purchaseLink} >Add To Cart</Link>
        
      </div>
    </div>
    </div>
  );
};

const styles = {
  container: {
    display: 'flex',
    padding: '20px',
    maxWidth: '800px',
    margin: '0 auto',
  },
  bookCoverContainer: {
    flex: '1',
    marginRight: '20px',
  },
  coverImage: {
    width: '100%',
    borderRadius: '8px',
  },
  detailsContainer: {
    flex: '2',
  },
  title: {
    fontSize: '2em',
    margin: '0',
  },
  author: {
    fontSize: '1.2em',
    color: '#555',
    margin: '0 0 20px 0',
  },
  description: {
    fontSize: '1em',
    lineHeight: '1.5',
    color: '#333',
    margin: '0 0 20px 0',
  },
  purchaseLink: {
    display: 'inline-block',
    padding: '10px 20px',
    backgroundColor: '#007BFF',
    color: '#fff',
    textDecoration: 'none',
    borderRadius: '4px',
    fontWeight: 'bold',
  },
};

export default BookDescriptionPage;
