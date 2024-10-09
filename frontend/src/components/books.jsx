import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { config } from '../services/config';
import { cutString } from '../utils';
import { addToCart } from '../features/cartSlice';

function Books({ books }) {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const onAddToCart = (book) => {
    dispatch(addToCart(book));
    navigate(`/book-details/${book.id}`);
  };

  if (!books || books.length === 0) {
    return <div>No books available.</div>;
  }

  const renderBook = (book) => (
    <div className='col-md-3' key={book.id}>
      <div className='card mb-3'>
        <div className='row no-gutters'>
          <div className='col-md-12'>
            <img
              onClick={() => navigate(`/book-details/${book.id}`)}
              style={{ height: 200, cursor: 'pointer', objectFit: 'cover', width: '100%' }}
              src={`${config.serverUrl}/image/${book.profileImage || 'default.jpg'}`}
              className='card-img'
              alt={book.title || 'Book'}
            />
          </div>
          <div className='col-md-12'>
            <div className='card-body'>
              <div className='card-text'>
                <span style={{ fontWeight: 'bold', fontSize: 18 }}>
                  ₹{book.price || 'N/A'}
                </span>
              </div>
              <h5 style={{ fontWeight: 'bold' }} className='card-title'>
                {cutString(book.title || 'No Title')}
              </h5>
              <div className='card-text'>
                <span>{book.author || 'Unknown Author'}</span>
              </div>
              <div>
                <button onClick={() => onAddToCart(book)} className='btn btn-success'>
                  Add To Cart
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );

  const rows = [];
  for (let i = 0; i < books.length; i += 4) {
    const rowBooks = books.slice(i, i + 4);
    rows.push(
      <div className='row' key={i}>
        {rowBooks.map(book => renderBook(book))}
      </div>
    );
  }

  return (
    <div className='container-fluid'>
      {rows}
    </div>
  );
}

export default Books;




/*
import { useDispatch } from 'react-redux';
import { config } from '../services/config';
import { cutString } from '../utils';
import { addToCart } from '../features/cartSlice';

function Books({ books, onClick }) {
  const dispatch = useDispatch();

  const onAddToCart = () => {
    dispatch(addToCart());
  };

  return (
    <div className='col-6'>
      <div className='card mb-3'>
        <div className='row no-gutters'>
          <div className='col-md-4'>
            <img
              onClick={onClick}
              style={{ height: 200, cursor: 'pointer', objectFit: 'cover', width: '100%' }}
              src={`${config.serverUrl}/image/${books?.profileImage || 'default.jpg'}`}
              className='card-img'
              alt={books?.title || 'Book'}
            />
          </div>
          <div className='col-md-8'>
            <div className='card-body'>
              <h5 style={{ fontWeight: 'bold' }} className='card-title'>
                {cutString(books?.title || 'No Title')}
              </h5>
              <div className='card-text'>
                <span style={{ fontWeight: 'bold', fontSize: 18 }}>
                  ₹{books?.rent || 'N/A'}
                </span>
              </div>
              <div>
                <button onClick={onAddToCart} className='btn btn-success'>
                  Add To Cart
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Books;
*/


