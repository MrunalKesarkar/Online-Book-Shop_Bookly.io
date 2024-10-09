// import { useDispatch } from 'react-redux';
// import { config } from '../services/config';
// //import { cutString } from '../utils';
// //import { addToCart } from '../features/cartSlice';
// import Navbar from '../../components/navbar';
// import { Link , useNavigate } from 'react-router-dom'

// function Biography({ books, onClick }) {
//   const dispatch = useDispatch();

//   const onAddToCart = () => {
//     dispatch(addToCart());
//   };

//   return (
//     <div className='col-6'>
//       <div className='card mb-3'>
//         <div className='row no-gutters'>
//           <div className='col-md-4'>
//             <img
//               onClick={onClick}
//               style={{ height: 200, cursor: 'pointer', objectFit: 'cover', width: '100%' }}
//               src={`${config.serverUrl}/image/${books['profileImage']}`}
//               className='card-img'
//               alt={books['title']}
//             />
//           </div>
//           <div className='col-md-8'>
//             <div className='card-body'>
//               <h5 style={{ fontWeight: 'bold' }} className='card-title'>
//                 {cutString(books['title'])}
//               </h5>
//               <div className='card-text'>
//                 <span style={{ fontWeight: 'bold', fontSize: 18 }}>
//                   ₹{books['rent']}
//                 </span>
//               </div>
//               <div>
//                 <button onClick={onAddToCart} className='btn btn-success'>
//                   Add To Cart
//                 </button>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default Biography;