import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Alert from '../alert/alert';
import "./addnewbook.css";
import { config } from '../services/config';
import Navbar from '../components/Navbar/navbar';


const AddNewBook = () => {
    const [newBook, setNewBook] = useState({
        title: "",
        quantity: "",
        price: "",
        description: "",
        author: "",
        categoryId: "", // Use categoryId instead of category name
        publication: "",
    });

    const [alert, setAlert] = useState(false);
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        // Fetch categories from backend
        const fetchCategories = async () => {
            try {
              
                const { data } = await axios.get(`${config.serverUrl}/categories/view`);
                setCategories(data);

            } catch (error) {
                console.error('Error fetching categories:', error);
            }
        };
        fetchCategories();
    }, []);

    const handleChange = (e) => {
        setNewBook({
            ...newBook,
            [e.target.name]: e.target.value,
        });
    };

    const resetInputField = () => {
        setNewBook({
            title: "",
            quantity: "",
            price: "",
            description: "",
            author: "",
            categoryId: "", // Reset categoryId
            publication: "",
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Create FormData to send file and other data
            const formData = new FormData();
formData.append('title', newBook.title);
formData.append('quantity', newBook.quantity);
formData.append('price', newBook.price);
formData.append('description', newBook.description);
formData.append('author', newBook.author);
formData.append('publication', newBook.publication);
formData.append('file', document.querySelector('input[type="file"]').files[0]);
debugger
await axios.post(`${config.serverUrl}/books/${newBook.categoryId}`, formData, {
    headers: {
        'Content-Type': 'multipart/form-data',
    },
});
            setAlert(true);
            resetInputField();
        } catch (error) {
            console.error("Error adding the book:", error);
        }
    };

    return (
        
        <React.Fragment>
            {alert && <Alert message={"Book added successfully!"} />}
            <Navbar />
            <div className="title my-3 text-center">
                <h2>Add New <b>Book</b></h2>
            </div>

            <form className="editbooks" onSubmit={handleSubmit}>
                <div className="mb-3 itemdata">
                    <label htmlFor="title" className="form-label">Book Title</label>
                    <input
                        name="title"
                        type="text"
                        className="form-control"
                        value={newBook.title}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="quantity" className="form-label">Quantity</label>
                    <input
                        name="quantity"
                        type="number"
                        className="form-control"
                        value={newBook.quantity}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="price" className="form-label">Price</label>
                    <input
                        name="price"
                        type="number"
                        className="form-control"
                        value={newBook.price}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="description" className="form-label">Book Description</label>
                    <textarea
                        name="description"
                        className="form-control"
                        value={newBook.description}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="author" className="form-label">Author</label>
                    <input
                        name="author"
                        type="text"
                        className="form-control"
                        value={newBook.author}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="category" className="form-label">Category</label>
                    <select
                        name="categoryId" // Use categoryId for the name
                        className="form-control"
                        value={newBook.categoryId}
                        onChange={handleChange}
                    >
                        <option value="">Select Category</option>
                        {categories.map((category) => (
                            <option key={category.categoryId} value={category.categoryId}>
                                {category.categoryName}
                            </option>
                        ))}
                    </select>
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="publication" className="form-label">Book Publication</label>
                    <input
                        name="publication"
                        type="text"
                        className="form-control"
                        value={newBook.publication}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3 itemdata">
                    <label htmlFor="image" className="form-label">Book Image</label>
                    <input
                        type="file"
                        name="image"
                        className="form-control"
                    />
                </div>
                <div className="itemdata d-inline-flex">
                    <button type="submit" className="btn btn-danger px-5 mx-2 rounded-pill">Add</button>
                    <button type="button" onClick={resetInputField} className="btn btn-danger px-5 rounded-pill">Reset</button>
                </div>
            </form>
        </React.Fragment>
    );
};

export default AddNewBook;
