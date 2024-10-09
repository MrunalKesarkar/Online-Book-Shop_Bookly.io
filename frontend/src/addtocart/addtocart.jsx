import React, { useState, useEffect } from "react";
import Books from "../db";
import Navbar from "../components/Navbar/navbar";



const AddToCart = ({ onIncrement, onDecrement, onDelete }) => {
  const [cartBook, setCartBook] = useState([]);
  const [total, setTotal] = useState(0);

  useEffect(() => {
    const cartBooks = Books.filter((element) => element.isInCart === true);
    setCartBook(cartBooks);
  }, []);

  useEffect(() => {
    let subtotal = 0;
    for (let i = 0; i < cartBook.length; i++) {
      subtotal += cartBook[i].price * cartBook[i].count;
    }
    setTotal(subtotal);
  }, [cartBook]);

  
  return (
    <div>
        <Navbar cartnum={cartBook.length}/>
    <div className="container mt-5 p-3 cart">
      <div className="row no-gutters">
        <div className="col-md-8">
          <div className="product-details mb-3">
            <div className="d-flex justify-content-between align-items-center">
              <h2>Add To <b>Cart</b></h2>
              </div>
              <div>
                <h4 className="d-flex justify-content-between">
                 <span>Shopping Cart</span>
                <span>{cartBook.length} Items</span>
                </h4>
              </div>

            <div className="container">
              <div className="row">
                <div className="col-md-12 col-sm-4">
                  <table className="table text-center tablecart">
                    <thead className="text-grey">
                      <tr>
                        <th>Product Details</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Remove</th>
                      </tr>
                    </thead>
                    <tbody>
                      {cartBook.map((book) => (
                        <tr key={book.bookId}>
                          <td className="align-middle d-flex bookImage">



                            <img className="rounded" src={book.image} width={40} alt={book.name} />
                            <div className="p-2">
                              <span className="d-block bookname">{book.name}</span>
                            </div>
                          </td>
                          <td className="align-middle">
                            <div className="d-flex justify-content-center">
                              <button
                                className="btn-sm bg-muted"
                                onClick={() => onDecrement(book)}
                                type="button"
                              >
                                <i className="fas fa-minus"></i>
                              </button>
                              <div className="px-2 border-bg-muted input">{book.quantity}</div>
                              <button
                                className="btn-sm bg-muted"
                                onClick={() => onIncrement(book)}
                                type="button"
                              >
                                <i className="fas fa-plus"></i>
                              </button>
                              </div>
                            </td>
                            <td className="align-middle">{book.price}</td>
                            <td className="align-middle">{book.price * book.count}</td>
                            <td className="align-middle">
                              <i className="fas fa-trash mx-4 delete" onClick={() => onDelete(book)} />
                            </td>
                          </tr>
                        ))}
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div className="d-flex align-items-center">
  <i className="fas fa-arrow-left"></i>
  <span
    className="ml-2 continue-shopping"
    style={{
      border: '1px solid #ffc107', // Same color as btn-warning
      padding: '5px 10px',
      borderRadius: '5px',
      cursor: 'pointer',
    }}
    onClick={() => window.location.href = '/'}
  >
    Continue Shopping
  </span>
</div>

          </div>
        </div>
        <div className="card col-md-3 mx-auto">
          <div className="card-header">
            <h6 className="card-text">Order Summary</h6>
          </div>
          <div className="card-body">
            <div className="d-flex justify-content-between pt-1">
              <h6>Subtotal</h6>
              <h6>{total}Rs</h6>
            </div>
            <div className="d-flex justify-content-between">
              <h6>Shipping</h6>
              <h6>10Rs</h6>
            </div>
          </div>
          <div className="card-footer border-secondary bg-transparent">
            <div className="d-flex justify-content-between">
              <h6>Total Cost</h6>
              <h6>{total + 10}Rs</h6>
            </div>
            <button className="btn btn-block btn-warning">Proceed To Checkout</button>
          </div>
        </div>
      </div>
    </div>
    </div>
  );
};

export default AddToCart;

                            {/* Assuming images is imported or properly handled */}