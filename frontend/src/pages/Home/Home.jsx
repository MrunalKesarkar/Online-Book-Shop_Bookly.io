import React, { useState, useEffect } from 'react';
import Navbar from '../../components/Navbar/navbar';
import Header from '../../components/header/header';
import BooksView from '../../components/booksview/booksview';
import { getBooks } from '../../services/books'; // Import the getBooks function

const Home = () => {
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchBooks = async () => {
            try {
                const booksData = await getBooks();
               
                setBooks(booksData || []);
            } catch (err) {
                setError('Failed to load books.');
            } finally {
                setLoading(false);
            }
        };

        fetchBooks();
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;

    return (
        <>
            <Navbar />
            <Header />
            <BooksView books={books} />
        </>
    );
};

export default Home;
