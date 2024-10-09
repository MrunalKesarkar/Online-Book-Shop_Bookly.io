import React from 'react';
import './booksview.css';
import { Link } from 'react-router-dom';
import { config } from '../../services/config'; // Import config to get the server URL

const BooksView = ({ books }) => {
   
    return (
        <section className="most-books">
            <div className="container" id="Science">
                <div className="row">
                    <div className="col-md-12">
                        <h2><b>All Books</b></h2>
                    </div>
                    <div className="books">
                        {books.slice(0, 10).map((book) => (
                            <div className="book" key={book.bookId}>
                                <Link to={`/book/${book.bookId}`}>
                                    <img
                                        
                                        src={`${config.serverUrl}/${book.imgPath}`}
                                        alt={book.title}
                                        loading="lazy"
                                    />
                                </Link>
                                <div className="thumb-content">
                                    <h5>{book.title}</h5>
                                    <p className="item-price">
                                        <strike>{book.price}</strike> <span>25% Off</span>
                                    </p>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </section>
    );
};

export default BooksView;
