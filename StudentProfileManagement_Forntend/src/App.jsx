import { useState } from 'react'
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "../node_modules/bootstrap/dist/js/bootstrap.min.js"
import './App.css'
import Home from './home'
import StudentView from './component/Student/StudentView'
import NavBar from './component/common/NavBar.jsx'
import { BrowserRouter as Router , Route,Routes } from 'react-router-dom'  
import AddStudent from './component/Student/AddStudent.jsx'
import EditStudent from './component/Student/EditStudent.jsx'
import StudentProfile from './component/Student/StudentProfile.jsx'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>

        
        <Router>
          
        <NavBar/>
          <Routes>
            <Route exact path="/" element={<Home/>}> </Route>
               <Route exact path="/view-students" element={<StudentView/>}> </Route>

               <Route exact path="/add-students" element={<AddStudent/>}> </Route>

               <Route exact path="/edit-student/:id" element={<EditStudent/>}> </Route>

               <Route exact path="/student-profile/:id" element={<StudentProfile/>}> </Route>
               
          </Routes>
        </Router>
    </>
  )
}

export default App
