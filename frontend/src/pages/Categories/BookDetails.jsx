import { useLocation } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { getBookDetails } from '../../services/books';
import { config } from '../../services/config';
import Navbar from '../../components/Navbar/navbar';

function BookDetails() {
  const [details, setDetails] = useState(undefined);
  const location = useLocation();

  const loadBookDetails = async (id) => {
    const result = await getBookDetails(id);
    if (result.status === 'success') {
      setDetails(result.data);
    } else {
      toast.error(result.error);
    }
  };

  useEffect(() => {
    loadBookDetails(location.state.id);
  }, [location.state.id]);

  const onAddToCart = () => {
    toast.success('Book added to cart!');
  };

  return (
    <div>
      <Navbar />
      {details && (
        <div className="row mt-5">
          <div className="col-md-4">
            <img
              className="img-fluid"
              style={{
                height: '100%',
                width: '100%',
                borderRadius: 10,
                objectFit: 'cover',
              }}
              src={`${config.serverUrl}/image/${details.profileImage}`}
              alt={details.title}
            />
          </div>
          <div className="col-md-8">
            <h2>{details.title}</h2>
            <h3>by {details.author}</h3>
            <div style={{ fontSize: 18, color: 'rgb(34, 34, 34)' }}>
              Price: ₹{details.price}
            </div>
            <button onClick={onAddToCart} className="btn btn-success mt-3">
              Add to Cart
            </button>
            <hr className="mt-4" />
            <div>
              <h4>About this book</h4>
              <p>{details.description}</p>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default BookDetails;


/*
import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { getBookDetails } from '../../services/books';
import { config } from '../../services/config';
import Navbar from '../../components/navbar';

function BookDetails() {
  const [details, setDetails] = useState(undefined);
  const location = useLocation();

  const loadBookDetails = async (id) => {
    const result = await getBookDetails(id);
    if (result.status === 'success') {
      setDetails(result.data);
    } else {
      toast.error(result.error);
    }
  };

  useEffect(() => {
    loadBookDetails(location.state.id);
  }, [location.state.id]);

  const onAddToCart = () => {
    toast.success('Book added to cart!');
  };

  return (
    <div>
      <Navbar />
      {details && (
        <div className="row mt-5">
          <div className="col-md-4">
            <img
              className="img-fluid"
              style={{
                height: '100%',
                width: '100%',
                borderRadius: 10,
                objectFit: 'cover',
              }}
              src={`${config.serverUrl}/image/${details.profileImage}`}
              alt={details.title}
            />
          </div>
          <div className="col-md-8">
            <h2>{details.title}</h2>
            <h3>by {details.author}</h3>
            <div style={{ fontSize: 18, color: 'rgb(34, 34, 34)' }}>
              Price: ₹{details.price}
            </div>
            <button onClick={onAddToCart} className="btn btn-success mt-3">
              Add to Cart
            </button>
            <hr className="mt-4" />
            <div>
              <h4>About this book</h4>
              <p>{details.description}</p>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default BookDetails;
*/










/*
import { useLocation, useNavigate } from 'react-router-dom';
//import Navbar from '../components/navbar';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { getBookDetails } from '../../services/books'; //// Assuming this service exists
import { config } from '../../services/config';
import Navbar from '../../components/navbar';



function BookDetails() {
  const [details, setDetails] = useState(undefined);

  const location = useLocation();

  const loadBookDetails = async (id) => {
    const result = await getBookDetails(id);
    if (result.status === 'success') {
      setDetails(result.data);
    } else {
      toast.error(result.error);
    }
  };

  useEffect(() => {
    loadBookDetails(location.state.id);
  }, [location.state.id]);

  const navigate = useNavigate();

  const onAddToCart = () => {
    // Handle add to cart logic here
    toast.success('Book added to cart!');
  };

  return (
    <div>
      <Navbar />
      {details && (
        <div className="row mt-5">
          <div className="col-md-4">
            <img
              className="img-fluid"
              style={{
                height: '100%',
                width: '100%',
                borderRadius: 10,
                objectFit: 'cover',
              }}
              src={`${config.serverUrl}/image/${details.profileImage}`}
              alt={details.title}
            />
          </div>
          <div className="col-md-8">
            <h2>{details.title}</h2>
            <h3>by {details.author}</h3>
            <div style={{ fontSize: 18, color: 'rgb(34, 34, 34)' }}>
              Price: ₹{details.price}
            </div>
            <button
              onClick={onAddToCart}
              className="btn btn-success mt-3"
            >
              Add to Cart
            </button>
            <hr className="mt-4" />
            <div>
              <h4>About this book</h4>
              <p>{details.description}</p>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default BookDetails;
*/
