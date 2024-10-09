import { Route, Routes } from "react-router-dom";
import { Login } from "./pages/Login/Login";
import { Register } from "./pages/Register/Register";
import Home from "./pages/Home/Home";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Profile from "./pages/Profile/Profile";
import AllBooks from "./pages/Categories/AllBooks";
import BookDetails from "./pages/Categories/BookDetails";
import SignIn from "./signin/signin";
import Admin from "./admin/admin";
import AddNewBook from "./addBooks/addnewbook";
import React, { useState } from "react";
import Footer from "./components/Footer/Footer";
import PaymentForm from "./pages/Payment/Paymentform";
import AboutUsPage from "./pages/AboutUs/AboutUsPage";
import BookDescriptionPage from "./components/BookDetails/BookDescriptionPage";
import AddToCart from "./addtocart/addtocart";
import { Provider } from 'react-redux';
import { store } from "./store";

function App() {
  const [books, setBooks] = useState([]); // Initialize with an empty array
  const [user, setUser] = useState("");

  const onCart = (book) => {
    setBooks(prevBooks =>
      prevBooks.map(b => b.id === book.id ? { ...b, isInCart: true, count: b.count + 1 } : b)
    );
  };

  const handleRemoveItem = (book) => {
    setBooks(prevBooks =>
      prevBooks.map(b => b.id === book.id ? { ...b, isInCart: false, wishlist: false } : b)
    );
  };

  const handleDelete = (book) => {
    setBooks(prevBooks => prevBooks.filter(b => b.id !== book.id));
  };

  const handleIncrement = (book) => {
    setBooks(prevBooks =>
      prevBooks.map(b => b.id === book.id ? { ...b, count: b.count + 1 } : b)
    );
  };

  const handleDecrement = (book) => {
    setBooks(prevBooks =>
      prevBooks.map(b => b.id === book.id ? { ...b, count: Math.max(b.count - 1, 1) } : b)
    );
  };

  return (
    <div className="container-fluid">
      <Provider store={store}>
        <Routes>
          <Route index element={<Home />} />
          <Route path='/' element={<Home />} />
          <Route path='/login' element={<Login />} />
          <Route path='/register' element={<Register />} />
          <Route path='/profile' element={<Profile />} />
          <Route path="/aboutus" element={<AboutUsPage />} />
          <Route path='/allBooks' element={<AllBooks />} />
          <Route path="/bookDetails" element={<BookDetails />} />
          <Route path='/scienceFiction' element={<AllBooks />} />
          <Route path="/signin" element={<SignIn setUser={setUser} />} />
          <Route path="/book/:id" element={<BookDescriptionPage />} />
          <Route path="/addNewBook" element={<AddNewBook />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/admin/addnewitem" element={<AddNewBook books={books} setBooks={setBooks} />} />
          <Route path="/payment" element={<PaymentForm />} />
          <Route path="/shoppingcart" element={
            <AddToCart
              books={books}
              onSave={onCart}
              onIncrement={handleIncrement}
              onDecrement={handleDecrement}
              onDelete={handleRemoveItem}
            />
          } />
        </Routes>
        <ToastContainer />
        <Footer />
      </Provider>
    </div>
  );
}

export default App;
