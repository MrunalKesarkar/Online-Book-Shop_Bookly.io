import axios from 'axios';
import { config } from './config';

// Function to get the list of books
export async function getBooks() {
  try {
   const response = await axios.get(`${config.serverUrl}/books/view`);
   debugger 
   return response.data;

  } catch (ex) {
    console.log('exception: ', ex);
  }
  return null;
}

// Function to get book details by id
export async function getBookDetails(id) {
  try {
    const token = sessionStorage['token'];
    const response = await axios.get(`${config.serverUrl}/books/details/${id}`, {
      headers: { token },
    });
    return response.data;
  } catch (ex) {
    console.log('exception: ', ex);
  }
  return null;
}

// Function to add a new book
export async function addBook(
  title,
  author,
  price,
  image
) {
  // Use FormData to upload multi-part file
  const body = new FormData();
  body.append('title', title);
  body.append('author', author);
  body.append('price', price);
  body.append('image', image);

  try {
    const token = sessionStorage['token'];
    const response = await axios.post(`${config.serverUrl}/books`, body, {
      headers: { token },
    });
    return response.data;
  } catch (ex) {
    console.log('exception: ', ex);
  }

  return null;
}

export async function getBooksByCategory(category) {
  try {
    const token = sessionStorage['token'];
    const response = await axios.get(`${config.serverUrl}/books/category/${category}`, {
      headers: { token },
    });
    return response.data;
  } catch (ex) {
    console.log('exception: ', ex);
  }
  return null;
}

