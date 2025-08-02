import React from 'react';

const CourseDetails = ({ courses }) => {
  if (!courses || courses.length === 0) {
    return <p>No course data found.</p>;
  }

  return (
    <div >
      <h1>Course Details</h1>
      {courses.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
