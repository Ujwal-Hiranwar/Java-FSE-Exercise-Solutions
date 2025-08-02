import React from 'react';

const BookDetails = ({ books }) => {
  return (
    <div className="separator">
      <h1>Book Details</h1>
      {books.length > 0 && (
        <ul>
          {books.map(book => (
            <div key={book.id}>
              <h3>{book.bname}</h3>
              <h4>{book.price}</h4>
            </div>
          ))}
        </ul>
      )}
    </div>
  );
};

export default BookDetails;
