import React, {
	useEffect,
	useState,
} from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
const StudentProfile = () => {
	const { id } = useParams();

	const [student, setStudent] = useState({
		firstName: "",
		lastName: "",
		email: "",
		department: "",
	});

    useEffect(() => {
		loadStudent();
	}, []);
	
	const loadStudent = async () => {
		const result = await axios.get(
			`http://localhost:8080/students/student/${id}`
		);
		setStudent(result.data);
	};

  return (
	<section className="py-5" style={{ backgroundColor: "#f8f9fa" }}>
  <div className="container">
    <div className="row">
      {/* Left Column - Avatar & Actions */}
      <div className="col-lg-3 col-md-4 col-sm-12 mb-4">
        <div className="card shadow-sm text-center">
          <div className="card-body">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
              alt="avatar"
              className="rounded-circle img-fluid mb-3"
              style={{ width: 150, height: 150, objectFit: "cover" }}
            />
            <h5 className="mb-3">{`${student.firstName} ${student.lastName}`}</h5>
            <div className="d-flex justify-content-center gap-2">
              <button type="button" className="btn btn-outline-primary">
                Call
              </button>
              <button type="button" className="btn btn-outline-warning">
                Message
              </button>
            </div>
          </div>
        </div>
      </div>

      {/* Right Column - Student Details */}
      <div className="col-lg-9 col-md-8 col-sm-12">
        <div className="card shadow-sm">
          <div className="card-body">
            {/* Detail Row */}
            {[
              { label: "First Name", value: student.firstName },
              { label: "Last Name", value: student.lastName },
              { label: "Email", value: student.email },
              { label: "Department", value: student.department },
            ].map((item, idx) => (
              <div key={idx}>
                <div className="row mb-3">
                  <div className="col-sm-3">
                    <h6 className="mb-0">{item.label}</h6>
                  </div>
                  <div className="col-sm-9">
                    <p className="text-muted mb-0">{item.value}</p>
                  </div>
                </div>
                {idx < 3 && <hr />}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


	);
  
}

export default StudentProfile